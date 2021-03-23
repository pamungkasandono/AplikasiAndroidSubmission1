package com.pamungkas.submission

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AdapterMakanan(private val listMakanan: ArrayList<Makanan>, val mItemClickListener:ItemClickListener): RecyclerView.Adapter<AdapterMakanan.MakananViewHolder>() {
//    var listener: RecyclerViewClickListener? = null

    interface ItemClickListener {
        fun onItemClicked(makanan: View?, makanan1: Makanan)
    }

    inner class MakananViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvMenuName = itemView.findViewById<TextView>(R.id.tv_menu_name)
        var tvMenuDetail = itemView.findViewById<TextView>(R.id.tv_menu_detail)
        var imgMenuPhoto = itemView.findViewById<ImageView>(R.id.img_menu_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakananViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MakananViewHolder(view)
    }

    override fun onBindViewHolder(holder: MakananViewHolder, position: Int) {
        val makanan = listMakanan[position]

        Glide.with(holder.itemView.context)
            .load(makanan.Photo)
            .apply(RequestOptions().override(107, 83))
            .into(holder.imgMenuPhoto)
        holder.tvMenuName.text = makanan.Name
        holder.tvMenuDetail.text = makanan.Detail

        holder.itemView.setOnClickListener {
            mItemClickListener.onItemClicked(it,makanan)
        }
    }


    override fun getItemCount(): Int {
        return listMakanan.size
    }
}