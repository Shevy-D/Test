package com.shevy.test.exampledelegate.adapters

import com.shevy.test.databinding.TextItemBinding
import com.shevy.test.exampledelegate.delegate.ViewBindingDelegateAdapter
import com.shevy.test.exampledelegate.model.TextItem

class TextDelegateAdapter : ViewBindingDelegateAdapter<TextItem, TextItemBinding>(TextItemBinding::inflate) {

    override fun TextItemBinding.onBind(item: TextItem) {
        tvTitle.text = item.title
        tvDescription.text = item.description
    }

    override fun isForViewType(item: Any) = item is TextItem

    override fun TextItem.getItemId(): Any = title
}