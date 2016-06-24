package com.zortac.bluetools;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class VDevicesAdapter extends RecyclerView.Adapter<VDevicesAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public Button activateButton;
        public Button configureButton;

        public ViewHolder(View itemView) {

            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.vdevice_name);
            activateButton = (Button) itemView.findViewById(R.id.activate_button);
            configureButton = (Button) itemView.findViewById(R.id.configure_button);

        }

    }

    private List<VDeviceInfo> mVDevices;
    private Context mContext;

    public VDevicesAdapter(Context context, List<VDeviceInfo> vdevices) {
        mVDevices = vdevices;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public VDevicesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View vdevicesView = inflater.inflate(R.layout.item_vdevice, parent, false);

        ViewHolder viewHolder = new ViewHolder(vdevicesView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VDevicesAdapter.ViewHolder viewHolder, int position) {
        VDeviceInfo vdevice = mVDevices.get(position);

        TextView textView = viewHolder.nameTextView;
        textView.setText(vdevice.getName());
        Button configureButton = viewHolder.configureButton;
        configureButton.setText(R.string.configure_vdevice);
        Button activateButton = viewHolder.activateButton;
        if(vdevice.isActive()) {
            activateButton.setText(R.string.deactivate_vdevice);
            activateButton.setBackgroundTintList(ColorStateList.valueOf(getContext().getResources()
                    .getColor(R.color.md_red_500)));
        } else {
            activateButton.setText(R.string.activate_vdevice);
            activateButton.setBackgroundTintList(ColorStateList.valueOf(getContext().getResources()
                    .getColor(R.color.md_green_500)));
        }

    }

    @Override
    public int getItemCount() {
        return mVDevices.size();
    }
}
