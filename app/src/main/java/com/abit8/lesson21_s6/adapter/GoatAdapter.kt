package com.abit8.lesson21_s6.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.abit8.lesson21_s6.adapter.model.GoatModel
import com.abit8.lesson21_s6.databinding.ItemListBinding
import com.bumptech.glide.Glide

class GoatAdapter(
    private val goatList: ArrayList<GoatModel>,
    val addImage: (goatModel: GoatModel) -> Unit,
    val removeImage: (goatModel: GoatModel) -> Unit
) :
    Adapter<GoatAdapter.GoatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoatViewHolder {
        return GoatViewHolder(
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = goatList.size


    override fun onBindViewHolder(holder: GoatViewHolder, position: Int) {
        holder.bind(goatList[position])
        holder.itemView
    }

    inner class GoatViewHolder(
        private val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(goatModel: GoatModel) {
            itemView.setOnClickListener() {
                goatModel.isClickTrue = !goatModel.isClickTrue
                if (goatModel.isClickTrue) {
                    binding.ivGoat.alpha = 0.5f
                    addImage(goatModel)
                } else {
                    removeImage(goatModel)
                    binding.ivGoat.alpha = 1.0f
                }
            }
            Glide.with(binding.ivGoat).load(goatModel.goatImg).into(binding.ivGoat)
        }

    }
}