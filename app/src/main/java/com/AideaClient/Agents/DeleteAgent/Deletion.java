package com.AideaClient.Agents.DeleteAgent;

import com.AideaClient.Framework.AgentsFramework.IKeyEvent;

/**
 * Created by krist on 03/09/2017.
 */

public class Deletion implements IKeyEvent{

    private long deletionID;
    private long pressTime;
    private long releaseTime;

    public long getDeletionID() {
        return deletionID;
    }

    public void setDeletionID(long deletionID) {
        this.deletionID = deletionID;
    }

    public long getPressTime() {
        return pressTime;
    }

    public void setPressTime(long pressTime) {
        this.pressTime = pressTime;
    }

    public long getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(long releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Deletion(long deletionID, long pressTime, long releaseTime) {
        this.deletionID = deletionID;
        this.pressTime = pressTime;
        this.releaseTime = releaseTime;
    }
}
