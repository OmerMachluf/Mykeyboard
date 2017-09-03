package com.anysoftkeyboard.TextAgent;

import com.anysoftkeyboard.AgentsFramework.ISessionReport;

import java.util.HashMap;

/**
 * Created by krist on 04/09/2017.
 */

public class TextSessionReport implements ISessionReport<KeyEvent> {
    @Override
    public HashMap<Long, KeyEvent> getKeyMap() {
        return null;
    }
}
