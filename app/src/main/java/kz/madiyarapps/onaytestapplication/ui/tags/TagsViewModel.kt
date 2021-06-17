package kz.madiyarapps.onaytestapplication.ui.tags

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ServiceLifecycleDispatcher
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.madiyarapps.onaytestapplication.core.BaseViewModel
import kz.madiyarapps.onaytestapplication.data.repository.TagsRepositoryImpl
import kz.madiyarapps.onaytestapplication.domain.Resource
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse
import java.lang.Exception
import javax.inject.Inject

class TagsViewModel @Inject constructor(
    private val networkDispatcher: CoroutineDispatcher,
    private val repositoryImpl: TagsRepositoryImpl
) : BaseViewModel() {

    private val TAG = TagsViewModel::class.java.name

    private val tagsLiveData = MutableLiveData<Resource<TagsResponse>>()
    fun getTagsLiveData(): LiveData<Resource<TagsResponse>> = tagsLiveData

    init {
        getTags()
    }

    fun getTags(sort: String = "popular", order: String = "desc") {
        uiScope.launch {
            tagsLiveData.value = Resource.loading()
            try {
                val result = withContext(networkDispatcher) {
                    repositoryImpl.getTags(sort, order)
                }
                tagsLiveData.value = result
            } catch (e: Exception) {
                tagsLiveData.value = Resource.error(e)
            }
        }
    }

}