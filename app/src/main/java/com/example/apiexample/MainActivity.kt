package com.example.apiexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiexample.databinding.ActivityMainBinding
import com.example.apiexample.network.ProductApi.productService
import com.example.apiexample.network.response.ProductList
import com.example.movie_list_mvvm.utils.dataBinding
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by dataBinding(R.layout.activity_main)
    var productAdapter: ProductAdapter? = null
    lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()



    }




    private fun init(){
        productService.getProduct().enqueue(object : Callback<ProductList>{
            override fun onResponse(call: Call<ProductList>, response: Response<ProductList>) {

                if (response.isSuccessful){
                    Log.d("TAG", "SERVİCE SUCCESS")
                    response.body()?.let {

                        adapterLogic(it)
                    }
                } else {
                    Log.d("TAG","service failed")
                }
            }

            override fun onFailure(call: Call<ProductList>, t: Throwable) {
                Log.d("TAG","service failed ${t.message}")
            }

        })

    }

    private fun adapterLogic(productList: ProductList){
        rv = binding.rvProduct
        productAdapter = ProductAdapter(productList,this@MainActivity)
        rv.adapter= productAdapter
        rv.layoutManager=  LinearLayoutManager(this@MainActivity)

    }





}






