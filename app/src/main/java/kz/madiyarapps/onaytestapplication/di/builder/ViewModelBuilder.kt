package kz.madiyarapps.onaytestapplication.di.builder

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import kz.madiyarapps.onaytestapplication.di.ViewModelProviderFactory

@Module(includes = [
    RepositoryBuilder::class,
    AppViewModelBuilder::class
])
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}