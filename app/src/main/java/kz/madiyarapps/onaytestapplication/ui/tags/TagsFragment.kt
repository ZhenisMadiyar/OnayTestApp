package kz.madiyarapps.onaytestapplication.ui.tags

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_tags.*
import kz.beemobile.homebank.ui.product_credit.adapters.TagsAdapter
import kz.madiyarapps.onaytestapplication.R
import kz.madiyarapps.onaytestapplication.core.BaseViewModelFragment
import kz.madiyarapps.onaytestapplication.domain.Resource
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse.TagItem
import kz.madiyarapps.onaytestapplication.ui.questions.QuestionFragment

class TagsFragment : BaseViewModelFragment<TagsViewModel>() {

    companion object {
        fun newInstance() = TagsFragment()
    }

    private val tagsAdapter by lazy {
        TagsAdapter {
            onTagSelected(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_tags, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.tag_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sort_alphabet_asc -> {
                viewModel.getTags(sort = "name", order = "asc")
                true
            }
            R.id.sort_alphabet_desc -> {
                viewModel.getTags(sort = "name", order = "desc")
                true
            }
            R.id.sort_popularity -> {
                viewModel.getTags(sort = "popular", order = "desc")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun getViewModelClass(): Class<TagsViewModel> = TagsViewModel::class.java

    override fun onViewModelCreated() {
        setUpToolbar()
        initRV()
        viewModel.getTagsLiveData().observe(viewLifecycleOwner, tagsObserver)
    }

    private fun setUpToolbar() {
        (requireActivity() as AppCompatActivity).apply {
            title = getString(R.string.tags)
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            supportActionBar?.setDisplayShowHomeEnabled(false)
        }
    }

    private fun initRV() {
        rvTags.adapter = tagsAdapter
    }

    private fun onTagSelected(tagItem: TagItem) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, QuestionFragment.newInstance(tag = tagItem.name))
            .addToBackStack(null)
            .commit()
    }

    override fun onViewModelDestroyed() {
        viewModel.getTagsLiveData().removeObservers(this)
    }

    private val tagsObserver = Observer<Resource<TagsResponse>> {
        when (it.state) {
            Resource.State.SUCCESS -> {
                progress_circular.visibility = View.GONE
                it.baseData?.items?.let { tagsList -> tagsAdapter.loadList(tagsList) }
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