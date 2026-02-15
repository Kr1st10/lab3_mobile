package com.example.lab3mobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3mobile.R
import com.example.lab3mobile.model.Tip

class TipsAdapter(
    private val tips: List<Tip>,
    private val onClick: (Tip) -> Unit
) : RecyclerView.Adapter<TipsAdapter.TipViewHolder>() {

    class TipViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDay: TextView = view.findViewById(R.id.tvDay)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val ivImage: ImageView = view.findViewById(R.id.ivTipImage)
        val tvDesc: TextView = view.findViewById(R.id.tvShortDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]
        val resources = holder.itemView.context.resources

        holder.tvDay.text = resources.getString(R.string.day_label, tip.id)
        holder.tvTitle.setText(tip.titleRes)
        holder.tvDesc.setText(tip.shortDescRes)
        holder.ivImage.setImageResource(tip.imageRes)

        holder.itemView.setOnClickListener { onClick(tip) }
    }

    override fun getItemCount() = tips.size
}