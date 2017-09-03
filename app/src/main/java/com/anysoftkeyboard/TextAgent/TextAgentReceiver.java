package com.anysoftkeyboard.TextAgent;

import com.anysoftkeyboard.AgentsFramework.IAgentReceiver;

/**
 * Created by krist on 03/09/2017.
 */

public class TextAgentReceiver implements IAgentReceiver<KeyEvent,TextSessionReport>
{

    @Override
    public boolean connect() {
        return false;
    }

    @Override
    public boolean receiveRecord(KeyEvent keyEvent) {
        return false;
    }

    @Override
    public boolean crateNewSessionReport(TextSessionReport textSessionReport) {
        return false;
    }
}
