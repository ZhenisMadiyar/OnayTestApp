package kz.madiyarapps.onaytestapplication.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.madiyarapps.onaytestapplication.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityProviders::class])
    abstract fun bindMainActivity(): MainActivity
}