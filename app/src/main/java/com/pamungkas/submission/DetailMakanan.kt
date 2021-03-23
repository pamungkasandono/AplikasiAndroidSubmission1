package com.pamungkas.submission

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.text.NumberFormat


class DetailMakanan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_makanan)

        var btnBack = findViewById<ImageView>(R.id.btn_back_detail)
        btnBack.setOnClickListener {
            finish()
        }

        var name = findViewById<TextView>(R.id.tv_nama_makanan)
        var price = findViewById<TextView>(R.id.tv_harga_makanan)
        var detail = findViewById<TextView>(R.id.tv_detail_makanan)
        var photo = findViewById<ImageView>(R.id.iv_makanan)

        val formatter: NumberFormat = DecimalFormat("#,###")
//        val myNumber = price
//        val formattedNumber: String = formatter.format(myNumber)

        name.text = intent.getStringExtra("Name")
        price.text = "Rp. ${formatter.format(intent.getIntExtra("Price", 0)).toString()}"
        detail.text = intent.getStringExtra("Detail")
        photo.setImageResource(intent.getIntExtra("Photo", 0))
        Log.d("Detail", intent.getStringExtra("Photo").toString())
//        photo.setImageResource()

        val btnOrder = findViewById<Button>(R.id.btn_order)
        val btnShare = findViewById<Button>(R.id.btn_share)
        val nomer_wa = "6282136880796"
        btnOrder.setOnClickListener {
            try {
                val uriIntent = Intent(Intent.ACTION_VIEW,
                        Uri.parse("whatsapp://send?phone=$nomer_wa&text=Hai saya mau pesan:\n*${intent.getStringExtra("Name")}*"))
                startActivity(uriIntent)
            } catch (e: Exception) {
                //whatsapp app not install
//                Toast.makeText(this, "Error\n" + e.toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Aplikasi WhatsApp tidak ditemukan!", Toast.LENGTH_LONG).show();
            }
        }
        btnShare.setOnClickListener {
            try {
                Intent().apply{
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Ayo pesan makanan dengan aplikasi Order Food!")
                    type = "text/plain"
                    startActivity(this)
                }
            } catch (e: Exception) {
                //whatsapp app not install
//                Toast.makeText(this, "Error\n" + e.toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Aplikasi tidak ditemukan!", Toast.LENGTH_LONG).show();
            }
        }
    }
}