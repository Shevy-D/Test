package com.shevy.test.exampledelegate.adapters

import android.util.Log
import com.shevy.test.databinding.CheckItemBinding
import com.shevy.test.exampledelegate.delegate.ViewBindingDelegateAdapter
import com.shevy.test.exampledelegate.model.CheckItem

class CheckDelegateAdapter : ViewBindingDelegateAdapter<CheckItem, CheckItemBinding>(CheckItemBinding::inflate) {

    override fun CheckItemBinding.onBind(item: CheckItem) = with(checkBox) {
        text = item.title
        isChecked = item.isChecked
        setOnCheckedChangeListener { _, isChecked ->
            item.isChecked = isChecked
        }
    }

    override fun isForViewType(item: Any): Boolean = item is CheckItem

    override fun CheckItem.getItemId(): Any = title

    override fun CheckItemBinding.onRecycled() {
        checkBox.setOnCheckedChangeListener(null)
    }

    override fun CheckItemBinding.onAttachedToWindow() {
        Log.d(CheckDelegateAdapter::class.java.simpleName, "onAttachedToWindow")
    }

    override fun CheckItemBinding.onDetachedFromWindow() {
        Log.d(CheckDelegateAdapter::class.java.simpleName, "onDetachedFromWindow")
    }
}