package com.AideaClient.Agents.DeleteAgent;

import com.AideaClient.Framework.AgentsFramework.ISessionReport;

import java.util.HashMap;

/**
 * Created by krist on 03/09/2017.
 */

public class DeleteSessionReport implements ISessionReport<Deletion>
{
    private long sessionID;

    private HashMap<Long, Deletion> deletionsMap;
    private int amountOfDeletionsPerSession;
    private int avgTimePressedOnDelete;
    private int totalAmountOfTimePressed;

    public long getSessionID() {
        return sessionID;
    }

    public void setSessionID(long sessionID) {
        this.sessionID = sessionID;
    }



    public void setDeletionsMap(HashMap<Long, Deletion> deletionsMap) {
        this.deletionsMap = deletionsMap;
    }

    public int getAmountOfDeletionsPerSession() {
        return amountOfDeletionsPerSession;
    }

    public void setAmountOfDeletionsPerSession(int amountOfDeletionsPerSession) {
        this.amountOfDeletionsPerSession = amountOfDeletionsPerSession;
    }

    public int getAvgTimePressedOnDelete() {
        return avgTimePressedOnDelete;
    }

    public void setAvgTimePressedOnDelete(int avgTimePressedOnDelete) {
        this.avgTimePressedOnDelete = avgTimePressedOnDelete;
    }

    public int getTotalAmountOfTimePressed() {
        return totalAmountOfTimePressed;
    }

    public void setTotalAmountOfTimePressed(int totalAmountOfTimePressed) {
        this.totalAmountOfTimePressed = totalAmountOfTimePressed;
    }

    public DeleteSessionReport(long sessionID, HashMap<Long, Deletion> deletionsMap, int amountOfDeletionsPerSession, int avgTimePressedOnDelete, int totalAmountOfTimePressed) {
        this.sessionID = sessionID;
        this.deletionsMap = deletionsMap;
        this.amountOfDeletionsPerSession = amountOfDeletionsPerSession;
        this.avgTimePressedOnDelete = avgTimePressedOnDelete;
        this.totalAmountOfTimePressed = totalAmountOfTimePressed;
    }

    @Override
    public HashMap<Long,Deletion> getKeyMap() {
        return this.deletionsMap;
    }
}
