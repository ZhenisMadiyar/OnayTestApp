package kz.madiyarapps.onaytestapplication.di.module

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider

import dagger.Binds
import dagger.Module
import kz.madiyarapps.onaytestapplication.OnayTestApp
import kz.madiyarapps.onaytestapplication.di.ViewModelProviderFactory
import kz.madiyarapps.onaytestapplication.di.builder.ViewModelBuilder
import kz.madiyarapps.onaytestapplication.di.qualifiers.AppContext
import kz.madiyarapps.onaytestapplication.di.scopes.PerApplication

@Module
abstract class AppModule {

    @Binds
    @PerApplication
    abstract fun provideApp(azamatApp: OnayTestApp): Application

    @Binds
    @PerApplication
    @AppContext
    abstract fun bindAppContext(azamatApp: OnayTestApp): Context
}