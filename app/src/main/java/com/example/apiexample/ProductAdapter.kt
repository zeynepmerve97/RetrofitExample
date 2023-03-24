package com.example.apiexample

import android.content.Context
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apiexample.databinding.RowProductItemBinding
import com.example.apiexample.network.response.ProductList

class ProductAdapter(
    val productList: ProductList,
    val context: Context
): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {



    class ProductViewHolder(val binding: RowProductItemBinding): RecyclerView.ViewHolder(binding.root){


    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.binding.txtId.text = product.id.toString()
        holder.binding.txtTitle.text = product.title
        holder.binding.txtPrice.text = product.price.toString()
        holder.binding.txtDesc.text = product.description
        holder.binding.txtCategory.text = product.category
        holder.binding.imgActor.let {  Glide.with(context).load(product.image).centerCrop().into(it) }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RowProductItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.row_product_item,parent, false)
        return ProductViewHolder(binding)
    }
}