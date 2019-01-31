package org.albaspazio.myapplication


import android.app.Application
import android.os.Vibrator
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import java.util.*

// HERE SHOULD GO ONLY IMMUTABLE DATA !!!! (since system may re-create this instance silently)
// now it contains support for:
// - tts
// - vibrator

class MainApplication : Application(), TextToSpeech.OnInitListener  {

    lateinit var vibrator: Vibrator
    var tts: TextToSpeech? = null

    override fun onCreate() {
        super.onCreate()

        Log.d("ME", "${NavHostFragment::class.java}")

        vibrator    = getSystemService(AppCompatActivity.VIBRATOR_SERVICE) as Vibrator
        tts         = TextToSpeech(applicationContext, this)
    }

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {
            // set US English as language for tts
            val result = tts!!.setLanguage(Locale.ENGLISH)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", resources.getString(R.string.tts_language_notsupported))
            }

        } else {
            Log.e("TTS", resources.getString(R.string.tts_notinitialized))
            tts = null
        }
    }
}