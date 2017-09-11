package com.AideaClient.AgentsFramework;

/**
 * Created by krist on 03/09/2017.
 */

public interface IAgentReceiver<T extends IKeyEvent,K extends ISessionReport<T>>  {

    public boolean connect();
    public boolean receiveRecord(T t);
    public boolean crateNewSessionReport(K k);
}
