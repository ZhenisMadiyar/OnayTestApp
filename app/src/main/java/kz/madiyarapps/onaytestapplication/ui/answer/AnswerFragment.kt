package kz.madiyarapps.onaytestapplication.ui.answer

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_answer.*
import kotlinx.android.synthetic.main.fragment_tags.progress_circular
import kz.madiyarapps.onaytestapplication.MainActivity
import kz.madiyarapps.onaytestapplication.R
import kz.madiyarapps.onaytestapplication.core.BaseViewModelFragment
import kz.madiyarapps.onaytestapplication.domain.Resource
import kz.madiyarapps.onaytestapplication.domain.response.AnswerResponse
import kz.madiyarapps.onaytestapplication.domain.response.QuestionResponse

class AnswerFragment : BaseViewModelFragment<AnswerViewModel>() {

    companion object {
        fun newInstance(id: Long) = AnswerFragment().apply {
            arguments = Bundle().apply {
                putLong("id", id)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_answer, container, false)
    }

    override fun getViewModelClass(): Class<AnswerViewModel> = AnswerViewModel::class.java

    override fun onViewModelCreated() {
        setUpToolbar()
        viewModel.getAnswerLiveData().observe(viewLifecycleOwner, answerObserver)
        arguments?.let {
            viewModel.getAnswer(it.getLong("id", 0))
        }
    }

    private fun setUpToolbar() {
        (requireActivity() as MainActivity).apply {
            title = getString(R.string.answers)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onViewModelDestroyed() {
        viewModel.getAnswerLiveData().removeObservers(this)
    }

    private val answerObserver = Observer<Resource<AnswerResponse>> {
        when (it.state) {
            Resource.State.SUCCESS -> {
                if (it?.baseData?.items?.isEmpty()!!) {
                    answer_title.text = getString(R.string.no_answer_yet)
                } else {
                    val answerItem = it.baseData.items.get(0)
                    answer_title.text = answerItem.title
                    answer_body.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Html.fromHtml(answerItem.body, Html.FROM_HTML_MODE_COMPACT)
                    } else {
                        Html.fromHtml(answerItem.body)
                    }
                }
                progress_circular.visibility = View.GONE
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