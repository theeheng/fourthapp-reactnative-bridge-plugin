cordova.define("fourthapp-reactnative-bridge-plugin", function(require, exports, module) {


(function() {

    var exec = require('cordova/exec');

    module.exports = {
      openReactNativeApp: function (eventname) {
                        exec(null, null, "InAppBrowser", "openReactNativeApp", []);
      }
    }
})();

});
