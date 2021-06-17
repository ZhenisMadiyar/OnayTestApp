package kz.madiyarapps.onaytestapplication.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_questions.*
import kotlinx.android.synthetic.main.fragment_tags.progress_circular
import kz.beemobile.homebank.ui.product_credit.adapters.QuestionAdapter
import kz.beemobile.homebank.ui.product_credit.adapters.TagsAdapter
import kz.madiyarapps.onaytestapplication.MainActivity
import kz.madiyarapps.onaytestapplication.R
import kz.madiyarapps.onaytestapplication.core.BaseViewModelFragment
import kz.madiyarapps.onaytestapplication.domain.Resource
import kz.madiyarapps.onaytestapplication.domain.response.QuestionResponse
import kz.madiyarapps.onaytestapplication.domain.response.QuestionResponse.*
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse.TagItem
import kz.madiyarapps.onaytestapplication.ui.answer.AnswerFragment

class QuestionFragment : BaseViewModelFragment<QuestionViewModel>() {

    companion object {
        fun newInstance(tag: String) = QuestionFragment().apply {
            arguments = Bundle().apply {
                putString("tag", tag)
            }
        }
    }

    private val questionsAdapter by lazy {
        QuestionAdapter {
            onQuestionSelected(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    override fun getViewModelClass(): Class<QuestionViewModel> = QuestionViewModel::class.java

    override fun onViewModelCreated() {
        setUpToolbar()
        initRV()
        viewModel.getQuestionsLiveData().observe(viewLifecycleOwner, questionObserver)
        arguments?.let {
            viewModel.getQuestions(it.getString("tag", "android"))
        }
    }

    private fun setUpToolbar() {
        (requireActivity() as MainActivity).apply {
            title = getString(R.string.questions)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            requireActivity().supportFragmentManager.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initRV() {
        rv_question.adapter = questionsAdapter
    }

    private fun onQuestionSelected(questionItem: QuestionItem) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, AnswerFragment.newInstance(id = questionItem.questionId))
            .addToBackStack(null)
            .commit()
    }

    override fun onViewModelDestroyed() {
        viewModel.getQuestionsLiveData().removeObservers(this)
    }

    private val questionObserver = Observer<Resource<QuestionResponse>> {
        when (it.state) {
            Resource.State.SUCCESS -> {
                progress_circular.visibility = View.GONE
                it.baseData?.items?.let { questionList -> questionsAdapter.loadList(questionList) }
            }
            Resource.State.ERROR -> {
                progress_circular.visibility = View.GONE
            }
            Resource.State.LOADING -> {
                progress_circular.visibility = View.VISIBLE
            }
        }
    }

}