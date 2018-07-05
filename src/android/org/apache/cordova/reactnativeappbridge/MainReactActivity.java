package org.apache.cordova.reactnativeappbridge;

import android.content.pm.PackageManager;
import com.facebook.react.ReactActivity;
import com.salesforce.androidsdk.phonegap.app.ReactNativeGeoBridge;
import static com.salesforce.androidsdk.phonegap.app.ReactNativeGeoBridge.ACCESS_LOCATION_REQUEST;

public class MainReactActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "MainReactActivity";
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        if (requestCode == ACCESS_LOCATION_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // request was accepted
                ReactNativeGeoBridge.callNativeLocation(ReactNativeGeoBridge.mSuccessCallback, ReactNativeGeoBridge.mErrorCallback);
            }
            else
            {
                ReactNativeGeoBridge.mErrorCallback.invoke("GeoLocation Access Denied.");
            }
        }
    }
}
