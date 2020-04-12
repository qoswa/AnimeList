package com.qoswantin.animelist.di.activity

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.qoswantin.animelist.ui.FragmentNavigator
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ActivityModule(
    private val activity: FragmentActivity
) {

    @ActivityScope
    @Provides
    fun provideActivityFragmentManager(): FragmentManager {
        return activity.supportFragmentManager
    }

    @ActivityScope
    @Provides
    @Named(ACTIVITY_CONTEXT)
    fun provideActivityContext(): Context {
        return activity
    }

    @ActivityScope
    @Provides
    fun provideFragmentNavigator(
        fragmentManager: FragmentManager
    ): FragmentNavigator {
        return FragmentNavigator(
            activity,
            fragmentManager
        )
    }

    companion object {
        const val ACTIVITY_CONTEXT = "ACTIVITY_CONTEXT"
    }

}