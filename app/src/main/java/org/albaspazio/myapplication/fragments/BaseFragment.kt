package org.albaspazio.myapplication.fragments

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable
import org.albaspazio.myapplication.MainActivity

//--------------------------------------------------------------------------------------------------
// abstract layer containing behaviour common to all fragments:
// - manage page orientation
// - show/hide android controls
//--------------------------------------------------------------------------------------------------

abstract class BaseFragment(
        @LayoutRes
        val layout: Int,
        val landscape: Boolean,
        val hideAndroidControls: Boolean
) : Fragment() {

    protected val disposable = CompositeDisposable()

    open val LOG_TAG = BaseFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(layout, container, false)
    }

    override fun onStart() {
        super.onStart()

        if (landscape != (activity!!.requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)) {
            activity!!.requestedOrientation = if (landscape) ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE else ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            return
        }
    }

    override fun onResume() {
        super.onResume()
        disposable.clear()
        (activity as MainActivity).refreshNavigationVisibility()
    }

    override fun onPause(){
        super.onPause()
        disposable.clear()
    }
}
