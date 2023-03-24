package com.example.movie_list_mvvm.utils


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


fun <DB : ViewDataBinding> AppCompatActivity.dataBinding(@LayoutRes layout: Int): Lazy<DB>{
    return lazy(LazyThreadSafetyMode.NONE ) {DataBindingUtil.setContentView<DB>(this,layout)}
}

fun <DB: ViewDataBinding> RecyclerView.Adapter<*>.dataBindingAdapter(@LayoutRes layout: Int, inflater: LayoutInflater, parent: ViewGroup):Lazy<DB>{
    return lazy(LazyThreadSafetyMode.NONE){
        DataBindingUtil.inflate(inflater,layout,parent,false)
    }
}