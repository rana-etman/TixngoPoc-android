package uk.org.lta.tixngodemo

import android.app.Application
import com.amazonaws.regions.Regions
import uk.org.lta.tixngodemo.AwsCognitoService
import io.tixngo.exampleAndroid.service.FirebaseMessageHelper

class MainApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        AwsCognitoService(this, Regions.EU_WEST_1,
            "1dblf7p82qg23pt4plusr4muf8",
            "eu-west-1_Uk3AzbQZ0")
        FirebaseMessageHelper(this).initialize()
    }
}