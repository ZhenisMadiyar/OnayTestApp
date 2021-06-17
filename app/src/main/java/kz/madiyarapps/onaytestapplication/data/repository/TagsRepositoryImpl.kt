package kz.madiyarapps.onaytestapplication.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kz.madiyarapps.onaytestapplication.data.network.TagsApi
import kz.madiyarapps.onaytestapplication.domain.repository.TagsRepository
import kz.madiyarapps.onaytestapplication.domain.Resource
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse
import java.lang.Exception
import javax.inject.Inject

class TagsRepositoryImpl @Inject constructor(
    private val tagsApi: TagsApi,
    private val networkDispatcher: CoroutineDispatcher
) : TagsRepository {

    override suspend fun getTags(sort: String, order: String): Resource<TagsResponse> {
        return withContext(networkDispatcher) {
            val result = tagsApi.getTags(sort = sort , order = order)
            if (result.isSuccessful) return@withContext Resource.success(result.body()!!)
            throw Exception(result.errorBody()?.string() ?: "Error getTags")
        }
    }
}