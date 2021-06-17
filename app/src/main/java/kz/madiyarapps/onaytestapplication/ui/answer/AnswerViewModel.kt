package kz.madiyarapps.onaytestapplication.ui.answer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.madiyarapps.onaytestapplication.core.BaseViewModel
import kz.madiyarapps.onaytestapplication.data.repository.AnswerRepositoryImpl
import kz.madiyarapps.onaytestapplication.data.repository.QuestionRepositoryImpl
import kz.madiyarapps.onaytestapplication.domain.Resource
import kz.madiyarapps.onaytestapplication.domain.response.AnswerResponse
import kz.madiyarapps.onaytestapplication.domain.response.QuestionResponse
import java.lang.Exception
import javax.inject.Inject

class AnswerViewModel @Inject constructor(
    private val networkDispatcher: CoroutineDispatcher,
    private val repositoryImpl: AnswerRepositoryImpl
) : BaseViewModel() {

    private val TAG = AnswerViewModel::class.java.name

    private val answerLiveData = MutableLiveData<Resource<AnswerResponse>>()
    fun getAnswerLiveData(): LiveData<Resource<AnswerResponse>> = answerLiveData

    fun getAnswer(id: Long) {
        uiScope.launch {
            answerLiveData.value = Resource.loading()
            try {
                val result = withContext(networkDispatcher) {
                    repositoryImpl.getAnswerById(id)
                }
                answerLiveData.value = result
            } catch (e: Exception) {
                answerLiveData.value = Resource.error(e)
            }
        }
    }

}