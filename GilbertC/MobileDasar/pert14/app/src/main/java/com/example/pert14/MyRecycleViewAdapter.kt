package com.example.pert14

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecycleViewAdapter (data : MutableList<Barang>) : RecyclerView.Adapter<MyRecycleViewAdapter.MyHolder>() {

    private var myData = data
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val NamaBarang = itemView.findViewById<TextView>(R.id.NamaBarang)
        val Status = itemView.findViewById<Switch>(R.id.Status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
       val inflate = LayoutInflater.from(parent.context)
           .inflate(R.layout.my_list_item_view,parent,false)
        return MyHolder(inflate)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.NamaBarang.setText(myData.get(position).NamaBarang)
        holder.Status.isChecked = myData.get(position).Status
    }

    override fun getItemCount(): Int = myData.size
}
