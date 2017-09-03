package com.anysoftkeyboard.AgentsFramework;


import java.util.HashMap;

/**
 * Created by krist on 03/09/2017.
 */

public interface ISessionReport<T extends IKeyEvent> {

    HashMap<Long,T> getKeyMap();
}
