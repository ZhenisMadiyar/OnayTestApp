package kz.madiyarapps.onaytestapplication.data.network

import kz.madiyarapps.onaytestapplication.core.Config.API_VERSION
import kz.madiyarapps.onaytestapplication.domain.response.AnswerResponse
import kz.madiyarapps.onaytestapplication.domain.response.QuestionResponse
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnswerApi {

    @GET("$API_VERSION/questions/{id}/answers")
    suspend fun getAnswer(
        @Path("id") id: Long,
        @Query("sort") sort: String = "activity",
        @Query("site") site: String = "stackoverflow",
        @Query("filter") filter: String = "ShSlq_sa88SJ9RrPuq1Hi"
    ): Response<AnswerResponse>

}