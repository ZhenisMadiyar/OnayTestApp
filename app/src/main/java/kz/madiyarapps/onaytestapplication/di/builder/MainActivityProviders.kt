package kz.madiyarapps.onaytestapplication.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.madiyarapps.onaytestapplication.ui.answer.AnswerFragment
import kz.madiyarapps.onaytestapplication.ui.questions.QuestionFragment
import kz.madiyarapps.onaytestapplication.ui.tags.TagsFragment

@Module
abstract class MainActivityProviders{

    @ContributesAndroidInjector
    abstract fun provideTagsFragment(): TagsFragment

    @ContributesAndroidInjector
    abstract fun provideQuestionFragment(): QuestionFragment

    @ContributesAndroidInjector
    abstract fun provideAnswerFragment(): AnswerFragment
}