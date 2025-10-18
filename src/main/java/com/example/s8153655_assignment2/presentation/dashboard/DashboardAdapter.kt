package com.example.s8153655assignment2.presentation.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.s8153655_assignment2.data.model.Entity


class DashboardAdapter(private val onClick: (Entity) -> Unit)
    : ListAdapter<Entity, DashboardAdapter.VH>(Diff()) {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val t1: TextView = itemView.findViewById(android.R.id.text1)
        val t2: TextView = itemView.findViewById(android.R.id.text2)
    }

    class Diff : DiffUtil.ItemCallback<Entity>() {
        override fun areItemsTheSame(oldItem: Entity, newItem: Entity) =
            oldItem.property1 == newItem.property1
        override fun areContentsTheSame(oldItem: Entity, newItem: Entity) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = getItem(position)
        holder.t1.text = item.property1
        holder.t2.text = item.property2
        holder.itemView.setOnClickListener { onClick(item) }
    }
}
