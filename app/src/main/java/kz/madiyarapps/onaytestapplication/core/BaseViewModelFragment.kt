package kz.madiyarapps.onaytestapplication.core

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class BaseViewModelFragment<VM : BaseViewModel> : BaseFragment() {

    @Inject
    protected open lateinit var factory: ViewModelProvider.Factory

    protected lateinit var viewModel: VM

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(viewModelStore, factory).get(getViewModelClass())

        onViewModelCreated()
    }

    abstract fun getViewModelClass(): Class<VM>
    abstract fun onViewModelCreated()

    open fun onViewModelDestroyed() {

    }

    override fun onDestroy() {
        super.onDestroy()
        onViewModelDestroyed()
    }

}