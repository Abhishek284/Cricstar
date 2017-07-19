package com.example.abhishek.cricstar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.usb.UsbManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by abhishek on 18/07/17.
 */

public class MyReceiver extends BroadcastReceiver {
    //private static final String ACTION_USB_PERMISSION = "com.example.abhishek.cricstar.USB_ATTACHED";
    @Override
    public void onReceive(Context context, Intent intent) {
//        String action = intent.getAction();
//        Log.d("ahjhgl","connected");
//        if (UsbManager.ACTION_USB_ACCESSORY_ATTACHED.equals(action)){
//
//            Toast.makeText(context, "Usb attached Intent Detected.", Toast.LENGTH_LONG).show();
//
//    }

        Toast.makeText(context , intent.getAction(),Toast.LENGTH_SHORT).show();

        Log.d("hjklag",intent.getAction()+"extras" + intent.getExtras());
        if (intent.getAction().equals("com.test.CUSTOM_INTENT")){
            Toast.makeText(context, "Custom Intent Detected.", Toast.LENGTH_LONG).show();
        }
        if (intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED")){
            Toast.makeText(context, "Power connected.", Toast.LENGTH_LONG).show();
//            PackageManager pm = context.getPackageManager();
//            Intent launchIntent = pm.getLaunchIntentForPackage("com.example.abhishek.cricstar");
//            context.startActivity(launchIntent);
        }
        Toast.makeText(context , intent.getAction(),Toast.LENGTH_SHORT).show();
//        if(intent.getAction().equals("android.hardware.usb.action.USB_ACCESSORY_ATTACHED")){
//            PackageManager pm = context.getPackageManager();
//            Intent launchIntent = pm.getLaunchIntentForPackage("com.example.abhishek.cricstar");
//            context.startActivity(launchIntent);
//            Toast.makeText(context, "USBBBB connected.", Toast.LENGTH_LONG).show();
//
//        }


}}

