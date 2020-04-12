package com.qoswantin.animelist.di.application

import android.app.Application
import com.qoswantin.animelist.di.activity.ActivityComponent
import com.qoswantin.animelist.di.activity.ActivityModule
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [
    ApplicationModule::class,
    NetworkModule::class,
    AnimeModule::class
])
interface ApplicationComponent {

    fun newActivityComponent(
        activityModule: ActivityModule
    ):ActivityComponent

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent

    }

}