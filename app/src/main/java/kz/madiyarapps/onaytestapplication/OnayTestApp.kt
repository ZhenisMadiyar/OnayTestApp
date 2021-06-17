package kz.madiyarapps.onaytestapplication

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector
import kz.madiyarapps.onaytestapplication.di.component.DaggerCoreComponent

class OnayTestApp: DaggerApplication(), HasAndroidInjector {

    companion object {
        lateinit var instance: OnayTestApp
    }

    init {
        instance = this
    }
    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerCoreComponent.factory().create(this)
    }

}