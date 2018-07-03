package org.apache.cordova.reactnativeappbridge;

import android.content.Context;
import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class ReactNativeAppBridge extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("openReactNativeApp")) {
            this.cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Context mContext = cordova.getActivity();
                    Intent reactNativeIntent = new Intent(mContext, com.fourth.marketplace.qa.MainReactActivity.class);
                    mContext.startActivity(reactNativeIntent);
                }
            });
            if(callbackContext != null) {
                PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
                pluginResult.setKeepCallback(true);
                callbackContext.sendPluginResult(pluginResult);
            }

            return true;
        }

        return false;
    }
}
