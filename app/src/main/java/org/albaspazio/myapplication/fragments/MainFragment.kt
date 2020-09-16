package org.albaspazio.myapplication.fragments

import android.view.View
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import org.albaspazio.core.fragments.BaseFragment
import org.albaspazio.myapplication.R

class MainFragment : BaseFragment(
    layout = R.layout.fragment_main,
    landscape = false,
    hideAndroidControls = false
)
{

    override val LOG_TAG = MainFragment::class.java.simpleName

    override fun onResume() {
        super.onResume()

        requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE

        bt_1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_testFragment)
        }
    }
}