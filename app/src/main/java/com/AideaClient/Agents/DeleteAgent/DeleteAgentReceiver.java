package com.AideaClient.Agents.DeleteAgent;

import com.AideaClient.Framework.AgentsFramework.IAgentReceiver;

/**
 * Created by krist on 03/09/2017.
 */

public class DeleteAgentReceiver implements IAgentReceiver<Deletion,DeleteSessionReport>
{
    public void DeleteAgentReciever()
    {


    }
    public void StartSession()
    {}


    @Override
    public boolean connect() {
        return false;
    }

    @Override
    public boolean receiveRecord(Deletion deletion) {
        return false;
    }

    @Override
    public boolean crateNewSessionReport(DeleteSessionReport deleteSessionReport) {
        return false;
    }
}
