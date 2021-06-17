package kz.madiyarapps.onaytestapplication.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import kz.madiyarapps.onaytestapplication.OnayTestApp
import kz.madiyarapps.onaytestapplication.di.builder.ActivityBuilder
import kz.madiyarapps.onaytestapplication.di.builder.ViewModelBuilder
import kz.madiyarapps.onaytestapplication.di.module.ApiModule
import kz.madiyarapps.onaytestapplication.di.module.AppModule
import kz.madiyarapps.onaytestapplication.di.module.NetworkModule
import kz.madiyarapps.onaytestapplication.di.scopes.PerApplication
import javax.inject.Singleton

@PerApplication
@Component(modules = [AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    ActivityBuilder::class,
    ApiModule::class,
    ViewModelBuilder::class])
interface CoreComponent : AndroidInjector<OnayTestApp> {

    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<OnayTestApp>
}