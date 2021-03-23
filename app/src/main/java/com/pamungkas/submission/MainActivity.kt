package com.pamungkas.submission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), AdapterMakanan.ItemClickListener {
    private lateinit var rvMakanan: RecyclerView
    private var list: ArrayList<Makanan> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvTitle = findViewById<TextView>(R.id.tv_title_makanan)
        tvTitle.setSelected(true);

        rvMakanan = findViewById(R.id.rv_menu)
        rvMakanan.setHasFixedSize(true)

        list.addAll(DataMakanan.listData)
        showMenuMakanan()

        val btnAboutme = findViewById<ImageView>(R.id.btn_aboutme)
        btnAboutme.setOnClickListener {
            val pindahKeAboutme = Intent(this@MainActivity, Aboutme::class.java)
            startActivity(pindahKeAboutme)
        }
//        val adapterMakanan = AdapterMakanan(list, this)
//        Log.d("cek3", adapterMakanan.listener.toString())
    }

    private fun showMenuMakanan() {
        rvMakanan.layoutManager = LinearLayoutManager(this)
        val adapterMakanan = AdapterMakanan(list,this)
        rvMakanan.adapter = adapterMakanan
    }

    override fun onItemClicked(makanan: View?, makanan1: Makanan) {
        Log.d("bismillah", makanan1.toString())
        Intent(this@MainActivity, DetailMakanan::class.java).apply {
            putExtra("Name", makanan1.Name)
            putExtra("Price", makanan1.Price)
            putExtra("Detail", makanan1.Detail)
            putExtra("Photo", makanan1.Photo)
            startActivity(this)
        }
    }
}

