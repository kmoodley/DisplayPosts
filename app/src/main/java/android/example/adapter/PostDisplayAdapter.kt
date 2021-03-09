package android.example.adapter

import android.content.Context
import android.example.R
import android.example.model.PostModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

class PostDisplayAdapter(
    private val dataSet: List<PostModel>,
    val context: Context
) :
    RecyclerView.Adapter<PostDisplayAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val postTitleText: TextView = view.findViewById(R.id.rvTextViewPostTitle)
        val postRowSubItem: LinearLayout = view.findViewById(R.id.sub_item)

        fun bind(post: PostModel) {
            postTitleText.text = post.title
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.text_row_item,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //holder.postTitleText?.text = dataSet.get(position)
        var postItem: PostModel = dataSet.get(position)
        holder.bind(postItem)

        holder.itemView.setOnClickListener {
            var visible:Boolean = holder.postRowSubItem.isVisible
            holder.postRowSubItem.visibility = if (visible) View.GONE else View.VISIBLE
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}