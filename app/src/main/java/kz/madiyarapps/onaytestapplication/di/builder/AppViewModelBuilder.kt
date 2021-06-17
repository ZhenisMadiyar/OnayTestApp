package kz.madiyarapps.onaytestapplication.di.builder

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kz.madiyarapps.onaytestapplication.di.qualifiers.ViewModelKey
import kz.madiyarapps.onaytestapplication.ui.answer.AnswerViewModel
import kz.madiyarapps.onaytestapplication.ui.questions.QuestionViewModel
import kz.madiyarapps.onaytestapplication.ui.tags.TagsViewModel
import javax.inject.Named

@Module
interface AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(TagsViewModel::class)
    fun bindTagsViewModel(tagsViewModel: TagsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(QuestionViewModel::class)
    fun bindQuestionViewModel(questionViewModel: QuestionViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AnswerViewModel::class)
    fun bindAnswerViewModel(answerViewModel: AnswerViewModel): ViewModel
}