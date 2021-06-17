package kz.madiyarapps.onaytestapplication.ui.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ServiceLifecycleDispatcher
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.madiyarapps.onaytestapplication.core.BaseViewModel
import kz.madiyarapps.onaytestapplication.data.repository.QuestionRepositoryImpl
import kz.madiyarapps.onaytestapplication.data.repository.TagsRepositoryImpl
import kz.madiyarapps.onaytestapplication.domain.Resource
import kz.madiyarapps.onaytestapplication.domain.response.QuestionResponse
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse
import java.lang.Exception
import javax.inject.Inject

class QuestionViewModel @Inject constructor(
    private val networkDispatcher: CoroutineDispatcher,
    private val repositoryImpl: QuestionRepositoryImpl
) : BaseViewModel() {

    private val TAG = QuestionViewModel::class.java.name

    private val questionsLiveData = MutableLiveData<Resource<QuestionResponse>>()
    fun getQuestionsLiveData(): LiveData<Resource<QuestionResponse>> = questionsLiveData

    fun getQuestions(tag: String) {
        uiScope.launch {
            questionsLiveData.value = Resource.loading()
            try {
                val result = withContext(networkDispatcher) {
                    repositoryImpl.getQuestions(tag)
                }
                questionsLiveData.value = result
            } catch (e: Exception) {
                questionsLiveData.value = Resource.error(e)
            }
        }
    }

}