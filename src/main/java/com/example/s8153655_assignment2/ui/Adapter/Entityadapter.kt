package com.example.s8153655_assignment2.ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.s8153655_assignment2.R
import com.example.s8153655_assignment2.data.model.Entity

class EntityAdapter(
    private val onItemClick: (Entity) -> Unit
) : ListAdapter<Entity, EntityAdapter.EntityViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Entity>() {
            override fun areItemsTheSame(oldItem: Entity, newItem: Entity): Boolean {
                // If there were stable IDs, compare them. For now, compare content
                return oldItem.property1 == newItem.property1 && oldItem.property2 == newItem.property2
            }

            override fun areContentsTheSame(oldItem: Entity, newItem: Entity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.entity_item, parent, false)
        return EntityViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class EntityViewHolder(
        itemView: View,
        private val onItemClick: (Entity) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val tvProperty1: TextView = itemView.findViewById(R.id.tvProp1)
        private val tvProperty2: TextView = itemView.findViewById(R.id.tvProp2)

        fun bind(entity: Entity) {
            tvProperty1.text = "Property 1: ${entity.property1}"
            tvProperty2.text = "Property 2: ${entity.property2}"
            itemView.setOnClickListener { onItemClick(entity) }
        }
    }
}