package kz.beemobile.homebank.ui.product_credit.adapters

import android.graphics.Typeface
import android.media.session.MediaSession
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_question.view.*
import kotlinx.android.synthetic.main.item_tag.view.*
import kz.beemobile.homebank.ui.product_credit.adapters.QuestionAdapter.*
import kz.madiyarapps.onaytestapplication.R
import kz.madiyarapps.onaytestapplication.domain.response.QuestionResponse
import kz.madiyarapps.onaytestapplication.domain.response.QuestionResponse.*
import kz.madiyarapps.onaytestapplication.domain.response.TagsResponse.*

class QuestionAdapter(private val onQuestionSelected: (QuestionItem) -> Unit) : RecyclerView.Adapter<QuestionViewHolder>() {

    private val questionList = ArrayList<QuestionItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return QuestionViewHolder(view)
    }

    fun loadList(questionList: List<QuestionItem>) {
        this.questionList.clear()
        this.questionList.addAll(questionList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val item = questionList[position]
        holder.bind(item)
    }

    inner class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: QuestionItem) {
            itemView.question_text.text = item.title
            itemView.question_answer_count.text = itemView.context.getString(R.string.answer_count, item.answerCount)
            itemView.setOnClickListener {
                onQuestionSelected(item)
            }
        }
    }
}