package uk.org.lta.tixngodemo

import TixngoConfiguration
import TixngoSDKConfig
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.tixngo.exampleAndroid.service.FirebaseMessageHelper
import io.tixngo.sdkutils.TixngoManager
import uk.org.lta.tixngodemo.ui.theme.TixngoDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
     initialize(this)
        setContent {
            TixngoDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )

                    TixngoManager.instance.openHomePage(this)

                }
            }
        }
    }
}

private fun initialize(context: Context){
    TixngoManager.instance.initialize(context = context, config = TixngoConfiguration(
        isEnableScreenshotSSK = true,
        isEnableDebug = true,
        defaultEnv = TixngoEnv.PREPROD,
        isEnableWallet = false,
        isCheckAppStatus = false,
        supportLanguages = arrayOf(TixngoLanguages.EN),
        defaultLanguage = TixngoLanguages.EN,
        appId = "io.tixngo.app.fwwc23",
        config = TixngoSDKConfig(
            displayType = DisplayType.Present,
            isHaveMenu = false,
            isHaveSignOut = false
        )
    ), onInitializedHandler = {

        Log.e("Hltest"," => onInitializedHandler => $it")
    }, onTokenExpiredHandler = {},
        onGetJwtTokenHandler = {
            Log.e("Hltest"," => onGetJwtTokenHandler")
            AwsCognitoService.instance.getToken { _, jwtToken ->
                it.invoke(jwtToken)
            }
        },
        onGetDeviceTokenHandler = {
            FirebaseMessageHelper.instance.getFcmToken { fcmToken ->
                it.invoke(fcmToken)
            }
        },
        onCloseHandler = {})
    TixngoManager.instance.setEnv(TixngoEnv.PREPROD)
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TixngoDemoTheme {
        Greeting("Android")
    }
}