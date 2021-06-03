package com.mahmoud.videostreamingassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btn_vid_1:Button
    lateinit var btn_vid_2:Button
    lateinit var btn_vid_3:Button
    lateinit var btn_vid_4:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_vid_1 = findViewById(R.id.btn_1)
        btn_vid_2 = findViewById(R.id.btn_2)
        btn_vid_3 = findViewById(R.id.btn_3)
        btn_vid_4 = findViewById(R.id.btn_4)

        btn_vid_1.setOnClickListener {
            val intent = Intent(this , VideoActivity::class.java )
            intent.putExtra("index" , 1)
            startActivity(intent)
        }

        btn_vid_2.setOnClickListener {
            val intent = Intent(this , VideoActivity::class.java )
            intent.putExtra("index" , 2)
            startActivity(intent)
        }

        btn_vid_3.setOnClickListener {
            val intent = Intent(this , VideoActivity::class.java )
            intent.putExtra("index" , 3)
            startActivity(intent)
        }

        btn_vid_4.setOnClickListener {
            val intent = Intent(this , VideoActivity::class.java )
            intent.putExtra("index" , 4)
            startActivity(intent)
        }
    }
}