package kz.madiyarapps.onaytestapplication.di

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelProviderFactory @Inject constructor(
    app: Application,
    private val vmMap: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
): ViewModelProvider.AndroidViewModelFactory(app) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return vmMap[modelClass]?.get() as T
    }

}