package com.qoswantin.animelist.di.activity

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ActivityModule(
    private val fragmentActivity: FragmentActivity
) {

    @ActivityScope
    @Provides
    fun provideActivityFragmentManager(): FragmentManager {
        return fragmentActivity.supportFragmentManager
    }

    @ActivityScope
    @Provides
    @Named(ACTIVITY_CONTEXT)
    fun provideActivityContext(): Context {
        return fragmentActivity
    }

    companion object {
        const val ACTIVITY_CONTEXT = "ACTIVITY_CONTEXT"
    }

}