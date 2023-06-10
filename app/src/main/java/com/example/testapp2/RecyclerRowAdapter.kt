package com.example.testapp2

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp2.room.DataView

class RecyclerRowAdapter(private val rvData: List<DataView>,
                         private val context: Context,
                         private val m_listener: ClickListener): RecyclerView.Adapter<RecyclerRowAdapter.RecyclerRowViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerRowViewHolder {

        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return RecyclerRowViewHolder(itemView, m_listener)
    }

    override fun onBindViewHolder(holder: RecyclerRowViewHolder, position: Int) {
        holder.title.text = rvData.get(position).title

        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return rvData.size
    }

    class RecyclerRowViewHolder(itemView: View, private val listener: ClickListener) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title_row)

        val root: LinearLayout = itemView.findViewById(R.id.root)

        fun bind(listIndex: Int) {
            Log.d("AAA", "Bind is work")
            val position: Int = listIndex
            root.setOnClickListener(View.OnClickListener { view: View? ->
                listener.onClick(
                    position
                )
            })
        }
    }


}

