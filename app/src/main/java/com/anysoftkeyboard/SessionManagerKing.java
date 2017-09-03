package com.anysoftkeyboard;

public class SessionManagerKing implements Serializable {

    private static volatile SessionManagerKing sSoleInstance;

    //private constructor.
    private SingletonClass(){

        //Prevent form the reflection api.
        if (sSoleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SessionManagerKing getInstance() {
        if (sSoleInstance == null) { //if there is no instance available... create new one
            synchronized (SessionManagerKing.class) {
                if (sSoleInstance == null) sSoleInstance = new SessionManagerKing();
            }
        }

        return sSoleInstance;
    }

    //Make singleton from serialize and deserialize operation.
    protected SessionManagerKing readResolve() {
        return getInstance();
    }

    public void CreateNewSessionManager(String AppPackageId)
    {

    }
}
