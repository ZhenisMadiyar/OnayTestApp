package kz.madiyarapps.onaytestapplication.domain.repository

import kz.madiyarapps.onaytestapplication.domain.Resource
import kz.madiyarapps.onaytestapplication.domain.response.AnswerResponse
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse
import okhttp3.ResponseBody

interface AnswerRepository {
    suspend fun getAnswerById(id: Long): Resource<AnswerResponse>
}