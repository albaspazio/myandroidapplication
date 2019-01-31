package org.albaspazio.myapplication.classes

import android.os.Handler
import com.jakewharton.rxrelay2.PublishRelay

class TestClass {

    val LOG_TAG = TestClass::class.java.simpleName

    val testEvent: PublishRelay<Int> = PublishRelay.create()

    companion object {
        @JvmStatic val STATIC_CONST_VAR             = 1


    }


    // just emit a 1 after 2000ms
    fun testMethod(){

        val mStimuliHandler = Handler()
        mStimuliHandler.postDelayed({
            testEvent.accept(STATIC_CONST_VAR)
        }, 2000)
    }

}