(function() {

    var exec = require('cordova/exec');

    module.exports = {
      openReactNativeApp: function (eventname) {
                        exec(null, null, "ReactNativeAppBridge", "openReactNativeApp", []);
      }
    }
})();

