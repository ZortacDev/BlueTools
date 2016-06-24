package com.zortac.bluetools;


import java.util.ArrayList;
import java.util.Random;

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

    @SuppressWarnings("unused")
    public static ArrayList<VDeviceInfo> createVDeviceList(int numVDevices) {
        ArrayList<VDeviceInfo> vDevices = new ArrayList<>();

        String [] dummyMembers = {"BTDevice 1", "BTDevice 2"};

        for (int i = 1; i <= numVDevices; i++) {
            Random rnd = new Random();
            vDevices.add(new VDeviceInfo("Adapter " + ++lastVDeviceId, rnd.nextBoolean(), dummyMembers));
        }

        return vDevices;
    }


}
