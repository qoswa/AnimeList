package com.qoswantin.animelist.di.activity

import com.qoswantin.animelist.di.controller.ControllerComponent
import com.qoswantin.animelist.di.controller.ControllerModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun newControllerComponent(
        controllerModule: ControllerModule
    ): ControllerComponent

}