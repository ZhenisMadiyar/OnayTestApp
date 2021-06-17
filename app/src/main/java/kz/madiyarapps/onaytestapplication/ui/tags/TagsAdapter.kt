package kz.beemobile.homebank.ui.product_credit.adapters

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_tag.view.*
import kz.beemobile.homebank.ui.product_credit.adapters.TagsAdapter.*
import kz.madiyarapps.onaytestapplication.R
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse.*

class TagsAdapter(private val onTagSelected: (TagItem) -> Unit) : RecyclerView.Adapter<TagViewHolder>() {

    private val tagList = ArrayList<TagItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tag, parent, false)
        return TagViewHolder(view)
    }

    fun loadList(tagList: List<TagItem>) {
        this.tagList.clear()
        this.tagList.addAll(tagList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return tagList.size
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        val item = tagList[position]
        holder.bind(item)
    }

    inner class TagViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: TagItem) {
            itemView.tag_name.text = item.name
            if (item.name == "android") itemView.tag_name.setTypeface(null, Typeface.BOLD)
            else itemView.tag_name.setTypeface(null, Typeface.NORMAL)
            itemView.setOnClickListener {
                onTagSelected(item)
            }
        }
    }
}