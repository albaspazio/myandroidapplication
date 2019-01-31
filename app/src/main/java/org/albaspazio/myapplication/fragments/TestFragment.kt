package org.albaspazio.myapplication.fragments

import android.speech.tts.TextToSpeech
import android.view.View
import androidx.navigation.Navigation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import org.albaspazio.myapplication.R
import kotlinx.android.synthetic.main.fragment_main.*
import org.albaspazio.myapplication.MainApplication
import org.albaspazio.myapplication.classes.TestClass

class TestFragment : BaseFragment(
    layout = R.layout.fragment_test,
    landscape = false,
    hideAndroidControls = false
)
{

    override val LOG_TAG = TestFragment::class.java.simpleName

    var tts: TextToSpeech? = null


    override fun onResume() {
        super.onResume()

        activity!!.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE

        val application         = context!!.applicationContext as MainApplication
        tts                     = application.tts


        val test = TestClass()
        test.testEvent
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                when(it)
                {
                    1 -> playbackText(resources.getString(R.string.hello_android))
                }
            }
            .addTo(disposable)


        bt_1.setOnClickListener {
            test.testMethod()
        }
    }

    private fun playbackText(text:String, queuemode:Int=TextToSpeech.QUEUE_FLUSH){

        tts!!.speak(text, queuemode, null, "")
    }
}