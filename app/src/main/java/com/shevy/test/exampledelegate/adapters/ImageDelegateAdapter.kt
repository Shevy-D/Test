package com.shevy.test.exampledelegate.adapters

import android.view.View
import com.shevy.test.databinding.ImageItemBinding
import com.shevy.test.exampledelegate.delegate.ViewBindingDelegateAdapter
import com.shevy.test.exampledelegate.model.ImageItem

class ImageDelegateAdapter(/*private val clickListener: View.OnClickListener*/) :
    ViewBindingDelegateAdapter<ImageItem, ImageItemBinding>(ImageItemBinding::inflate) {

    override fun ImageItemBinding.onBind(item: ImageItem) {
        tvTitle.text = item.title
        //imgBg.setOnClickListener(clickListener)
        imgBg.setImageResource(item.imageRes)
    }

    override fun isForViewType(item: Any): Boolean = item is ImageItem

    override fun ImageItem.getItemId(): Any = title
}