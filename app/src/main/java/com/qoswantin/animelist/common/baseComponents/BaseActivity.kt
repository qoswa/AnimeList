package com.qoswantin.animelist.common.baseComponents

import androidx.fragment.app.FragmentActivity
import com.qoswantin.animelist.AnimeApp
import com.qoswantin.animelist.di.activity.ActivityComponent
import com.qoswantin.animelist.di.activity.ActivityModule
import com.qoswantin.animelist.di.controller.ControllerComponent
import com.qoswantin.animelist.di.controller.ControllerModule


abstract class BaseActivity : FragmentActivity() {

    private var mIsControllerComponentUsed = false
    private var mActivityComponent: ActivityComponent? = null

    val activityComponent: ActivityComponent
        get() {
            if (mActivityComponent == null) {
                mActivityComponent = (application as AnimeApp).getApplicationComponent()
                    .newActivityComponent(ActivityModule(this))
            }
            return mActivityComponent as ActivityComponent
        }

    protected val controllerComponent: ControllerComponent
        get() {
            check(!mIsControllerComponentUsed) { "must not use ControllerComponent more than once" }
            mIsControllerComponentUsed = true
            return activityComponent
                .newControllerComponent(ControllerModule())
        }
}