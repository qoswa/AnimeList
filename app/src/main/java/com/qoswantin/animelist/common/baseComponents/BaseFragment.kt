package com.qoswantin.animelist.common.baseComponents

import androidx.fragment.app.Fragment
import com.qoswantin.animelist.di.controller.ControllerComponent
import com.qoswantin.animelist.di.controller.ControllerModule


abstract class BaseFragment : Fragment() {

    private var mIsControllerComponentUsed = false

    val controllerComponent: ControllerComponent
        get() {
            check(!mIsControllerComponentUsed) { "must not use ControllerComponent more than once" }
            mIsControllerComponentUsed = true
            return (requireActivity() as BaseActivity).activityComponent
                .newControllerComponent(ControllerModule())
        }

}