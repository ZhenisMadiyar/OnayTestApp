package kz.madiyarapps.onaytestapplication.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kz.madiyarapps.onaytestapplication.data.network.AnswerApi
import kz.madiyarapps.onaytestapplication.domain.Resource
import kz.madiyarapps.onaytestapplication.domain.repository.AnswerRepository
import kz.madiyarapps.onaytestapplication.domain.response.AnswerResponse
import java.lang.Exception
import javax.inject.Inject

class AnswerRepositoryImpl @Inject constructor(
    private val answerApi: AnswerApi,
    private val networkDispatcher: CoroutineDispatcher
) : AnswerRepository {

    override suspend fun getAnswerById(id: Long): Resource<AnswerResponse> {
        return withContext(networkDispatcher) {
            val result = answerApi.getAnswer(id = id)
            if (result.isSuccessful) return@withContext Resource.success(result.body()!!)
            throw Exception(result.errorBody()?.string() ?: "Error getting answer")
        }
    }
}