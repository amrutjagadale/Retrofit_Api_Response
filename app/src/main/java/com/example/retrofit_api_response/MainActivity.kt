package com.example.retrofit_api_response

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_api_response.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productService = ProductService.getInstance()

        CoroutineScope(Dispatchers.IO).launch {
            val response = productService.fetchProducts()
            withContext(Dispatchers.Main){
                setUpRecyclerView(response)

                Log.e("tag",response.toString())
                for (eachProduct in response){
                    Log.e("tag",eachProduct.toString())
                }
            }
        }

    }

    private fun setUpRecyclerView(products: ArrayList<Product>) {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        var myAdapter = ProductAdapter(this, products)
        binding.recyclerView.adapter = myAdapter

    }
}