package kz.madiyarapps.onaytestapplication.domain.repository

import kz.madiyarapps.onaytestapplication.domain.Resource
import kz.madiyarapps.onaytestapplication.domain.response.QuestionResponse
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse
import okhttp3.ResponseBody

interface QuestionRepository {
    suspend fun getQuestions(tag: String): Resource<QuestionResponse>
}