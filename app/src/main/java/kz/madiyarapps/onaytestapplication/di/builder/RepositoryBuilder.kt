package kz.madiyarapps.onaytestapplication.di.builder

import dagger.Binds
import dagger.Module
import kz.madiyarapps.onaytestapplication.data.repository.AnswerRepositoryImpl
import kz.madiyarapps.onaytestapplication.data.repository.QuestionRepositoryImpl
import kz.madiyarapps.onaytestapplication.data.repository.TagsRepositoryImpl
import kz.madiyarapps.onaytestapplication.domain.repository.AnswerRepository
import kz.madiyarapps.onaytestapplication.domain.repository.QuestionRepository
import kz.madiyarapps.onaytestapplication.domain.repository.TagsRepository

@Module
abstract class RepositoryBuilder {
    @Binds
    abstract fun bindsTagsRepository(repoImp: TagsRepositoryImpl): TagsRepository

    @Binds
    abstract fun bindsQuestionRepository(questionImp: QuestionRepositoryImpl): QuestionRepository

    @Binds
    abstract fun bindsAnswerRepository(questionImp: AnswerRepositoryImpl): AnswerRepository
}