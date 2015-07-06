package com.graystone.Bluetooth;

/**
 * Created by shenlong on 15/7/6.
 */
public interface BluetoothInterface {

    /**
     * Device Searching Process
     *
     */

    public void onSearchStart();

    public void onSearchProgress();

    public void onSearchFinished();
}
