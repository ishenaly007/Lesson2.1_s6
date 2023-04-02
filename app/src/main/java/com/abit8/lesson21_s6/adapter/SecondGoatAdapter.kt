package com.abit8.lesson21_s6.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abit8.lesson21_s6.adapter.model.GoatModel
import com.abit8.lesson21_s6.databinding.ItemListBinding
import com.bumptech.glide.Glide

class SecondGoatAdapter(
    private val goatList: ArrayList<GoatModel>
) :
    RecyclerView.Adapter<SecondGoatAdapter.SecondGoatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondGoatViewHolder {
        return SecondGoatViewHolder(
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: SecondGoatAdapter.SecondGoatViewHolder, position: Int) {
        holder.bind(goatList[position])
        holder.itemView
    }

    override fun getItemCount() = goatList.size

    inner class SecondGoatViewHolder(
        private val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(goatModel: GoatModel) {

            Glide.with(binding.ivGoat).load(goatModel.goatImg).into(binding.ivGoat)
        }
    }
}