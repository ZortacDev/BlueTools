package com.zortac.bluetools;


import java.util.ArrayList;

public class VDeviceInfo {
    private String mName;
    private boolean mActive;
    private String [] mMembers;

    public VDeviceInfo(String name, boolean active, String [] members) {
        mName = name;
        mActive = active;
        mMembers = members;
    }

    public String getName() {
        return mName;
    }

    public boolean isActive() {
        return mActive;
    }

    public String [] getMembers() {
        return mMembers;
    }

    private static int lastVDeviceId = 0;

    public static ArrayList<VDeviceInfo> createVDeviceList(int numVDevices) {
        ArrayList<VDeviceInfo> vDevices = new ArrayList<VDeviceInfo>();

        String [] dummyMembers = {"BTDevice 1", "BTDevice 2"};

        for (int i = 1; i <= numVDevices; i++) {
            vDevices.add(new VDeviceInfo("Adapter " + ++lastVDeviceId, true, dummyMembers));
        }

        return vDevices;
    }

}
