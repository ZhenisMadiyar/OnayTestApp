package kz.madiyarapps.onaytestapplication.domain.repository

import kz.madiyarapps.onaytestapplication.domain.Resource
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse
import okhttp3.ResponseBody

interface TagsRepository {
    suspend fun getTags(sort: String, order: String): Resource<TagsResponse>
}