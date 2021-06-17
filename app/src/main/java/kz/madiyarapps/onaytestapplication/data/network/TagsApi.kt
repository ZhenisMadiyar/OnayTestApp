package kz.madiyarapps.onaytestapplication.data.network

import kz.madiyarapps.onaytestapplication.core.Config.API_VERSION
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TagsApi {

    @GET("$API_VERSION/tags")
    suspend fun getTags(
        @Query("order") order: String,
        @Query("sort") sort: String,
        @Query("site") site: String = "stackoverflow"
    ): Response<TagsResponse>
}