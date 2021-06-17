package kz.madiyarapps.onaytestapplication.data.network

import kz.madiyarapps.onaytestapplication.core.Config.API_VERSION
import kz.madiyarapps.onaytestapplication.domain.response.QuestionResponse
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionApi {

    @GET("$API_VERSION/questions")
    suspend fun getQuestions(
        @Query("tagged") tagged: String,
        @Query("order") order: String = "desc",
        @Query("site") site: String = "stackoverflow"
    ): Response<QuestionResponse>

}