package com.shevy.test.exampledelegate.adapters

import com.shevy.test.databinding.ImageItemBinding
import com.shevy.test.exampledelegate.delegate.ViewBindingDelegateAdapter
import com.shevy.test.exampledelegate.model.ImageItem

class GenerateItemsDelegateAdapter(private val generateNewItems: () -> Unit) :
    ViewBindingDelegateAdapter<ImageItem, ImageItemBinding>(ImageItemBinding::inflate) {

    override fun ImageItemBinding.onBind(item: ImageItem) {
        tvTitle.text = item.title
        imgBg.setImageResource(item.imageRes)
        llRoot.setOnClickListener { generateNewItems() }
    }

    override fun isForViewType(item: Any): Boolean = item is ImageItem

    override fun ImageItem.getItemId(): Any = title
}