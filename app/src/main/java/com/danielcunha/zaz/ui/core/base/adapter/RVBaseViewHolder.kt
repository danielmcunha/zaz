package com.danielcunha.zaz.ui.core.base.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.danielcunha.zaz.BR

class RVBaseViewHolder<in T>(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindModel(model: T) {
        binding.setVariable(BR.viewHolder, model)
        binding.executePendingBindings()
    }
}