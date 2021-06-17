package kz.madiyarapps.onaytestapplication.di.module

import dagger.Module
import dagger.Provides
import kz.madiyarapps.onaytestapplication.data.network.AnswerApi
import kz.madiyarapps.onaytestapplication.data.network.QuestionApi
import kz.madiyarapps.onaytestapplication.data.network.TagsApi
import kz.madiyarapps.onaytestapplication.di.scopes.PerApplication
import retrofit2.Retrofit

@Module
object ApiModule {

    @Provides
    @PerApplication
    fun provideTagsApi(retrofit: Retrofit): TagsApi = retrofit.create(TagsApi::class.java)

    @Provides
    @PerApplication
    fun provideQuestionApi(retrofit: Retrofit): QuestionApi = retrofit.create(QuestionApi::class.java)

    @Provides
    @PerApplication
    fun provideAnswerApi(retrofit: Retrofit): AnswerApi = retrofit.create(AnswerApi::class.java)
}