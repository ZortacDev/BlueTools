package com.zortac.bluetools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final String VDEVICE_OBJECT = "VDeviceObject";

    static final int ADD_VDEVICE_REQUEST = 1;

    ArrayList<VDeviceInfo> vdevices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvVDeviceList = (RecyclerView) findViewById(R.id.rvVDeviceList);

        VDevicesAdapter adapter = new VDevicesAdapter(this, vdevices);

        assert rvVDeviceList != null;
        rvVDeviceList.setAdapter(adapter);
        rvVDeviceList.setLayoutManager(new LinearLayoutManager(rvVDeviceList.getContext()));

    }

    public void addFabClicked(View v) {
        Intent intent = new Intent(this, AddVDeviceActivity.class);
        startActivityForResult(intent, ADD_VDEVICE_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ADD_VDEVICE_REQUEST && resultCode == RESULT_OK) {
            VDeviceInfo vdevice = (VDeviceInfo) data.getSerializableExtra(VDEVICE_OBJECT);
            vdevices.add(vdevice);

            RecyclerView rvVDeviceList = (RecyclerView) findViewById(R.id.rvVDeviceList);

            assert rvVDeviceList != null;
            rvVDeviceList.getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);

    }
}
