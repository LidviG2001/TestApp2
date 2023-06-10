package com.example.testapp2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp2.room.DataView

class RecyclerAdapter(
    private val rvData: List<DataView>,
    private val context: Context,
    private val m_listener: ClickListener): RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {

        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return RecyclerViewHolder(itemView, m_listener)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.title.text = rvData.get(position).title
        holder.detail.text = rvData.get(position).detail


       holder.image.setImageResource(rvData.get(position).imageId!!)

        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return rvData.size
    }

    class RecyclerViewHolder(itemView: View, private val listener: ClickListener) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title_tv)
        val detail: TextView = itemView.findViewById(R.id.detail_tv)

        val image: ImageView = itemView.findViewById(R.id.image)

        val root: LinearLayout = itemView.findViewById(R.id.root)

        fun bind(listIndex: Int) {
            val position: Int = listIndex
            root.setOnClickListener(View.OnClickListener { view: View? ->
                listener.onClick(
                    position
                )
            })
        }
    }


}

interface ClickListener {
    fun onClick(index: Int)
}