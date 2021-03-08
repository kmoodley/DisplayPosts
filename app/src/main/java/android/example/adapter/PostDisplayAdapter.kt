package android.example.adapter

import android.content.Context
import android.example.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostDisplayAdapter(
    private val dataSet: ArrayList<String>,
    val context: Context
) :
    RecyclerView.Adapter<PostDisplayAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postTitleText: TextView = view.findViewById(R.id.rvTextViewPostTitle)
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
        holder?.postTitleText?.text = dataSet.get(position)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}