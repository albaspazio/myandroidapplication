package org.albaspazio.myapplication.fragments

import android.view.View
import androidx.navigation.Navigation
import org.albaspazio.myapplication.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(
    layout = R.layout.fragment_main,
    landscape = false,
    hideAndroidControls = false
)
{

    override val LOG_TAG = MainFragment::class.java.simpleName

    override fun onResume() {
        super.onResume()

        activity!!.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE

        bt_1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_testFragment)
        }
    }
}