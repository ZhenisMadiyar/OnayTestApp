package kz.madiyarapps.onaytestapplication.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kz.madiyarapps.onaytestapplication.data.network.QuestionApi
import kz.madiyarapps.onaytestapplication.data.network.TagsApi
import kz.madiyarapps.onaytestapplication.domain.repository.TagsRepository
import kz.madiyarapps.onaytestapplication.domain.Resource
import kz.madiyarapps.onaytestapplication.domain.repository.QuestionRepository
import kz.madiyarapps.onaytestapplication.domain.response.QuestionResponse
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse
import java.lang.Exception
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor(
    private val questionApi: QuestionApi,
    private val networkDispatcher: CoroutineDispatcher
) : QuestionRepository {

    override suspend fun getQuestions(tag: String): Resource<QuestionResponse> {
        return withContext(networkDispatcher) {
            val result = questionApi.getQuestions(tagged = tag)
            if (result.isSuccessful) return@withContext Resource.success(result.body()!!)
            throw Exception(result.errorBody()?.string() ?: "Error getTags")
        }
    }
}