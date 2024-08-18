package com.example.retrofit_api_response

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ProductAdapter(private val productList: ArrayList<Product>) :
        RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
    class ProductViewHolder(itemView: View) :ViewHolder(itemView) {
        var txtId : TextView = itemView.findViewById(R.id.txtId)
        var txtTitle :TextView = itemView.findViewById(R.id.txtTitle)
        var txtCategory: TextView = itemView.findViewById(R.id.txtCategory)
        var txtPrice : TextView = itemView.findViewById(R.id.txtPrice)
        var txtDescription : TextView = itemView.findViewById(R.id.txtDescription)
        var txtRatingCount : TextView = itemView.findViewById(R.id.txtRatingCount)
        var txtRatingRate : TextView = itemView.findViewById(R.id.txtRatingRate)
        var txtImage : ImageView =itemView.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ProductViewHolder(view)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        holder.txtId.text = productList[position].id.toString()
       holder.txtTitle.text = productList[position].title
        holder.txtPrice.text = productList[position].price.toString()
        holder.txtDescription.text = productList[position].description.toString()
        holder.txtCategory.text = productList[position].category.toString()
        holder.txtRatingCount.text = productList[position].rating.count.toString()
        holder.txtRatingRate.text =  productList[position].rating.rate.toString()

    }

    override fun getItemCount(): Int {
        return productList.size
    }
}