package com.zortac.bluetools;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VDeviceListFragment extends Fragment {

    public VDeviceListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {

        String [] testlistArray = {
                "Lorem Ipsum Channel: 2 Devices",
                "Toll",
                "Dolor sit",
                "amet."
        };

        List<String> testList = new ArrayList<>(Arrays.asList(testlistArray));

        ArrayAdapter<String> testlistAdapter =
                new ArrayAdapter<String>(
                        getActivity(),
                        R.layout.list_item_test,
                        R.id.list_item_test_textview,
                        testList);

        View rootView = inflater.inflate(R.layout.fragment_vdevicelist, container, false);

        ListView testListView = (ListView) rootView.findViewById(R.id.listview_testlist);
        testListView.setAdapter(testlistAdapter);

        return rootView;
    }

}
