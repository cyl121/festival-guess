package com.example.festivalapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // 使用 findViewById 綁定按鈕
        val startGameButton: Button = findViewById(R.id.startGameButton)

        // 設置按鈕點擊事件
        startGameButton.setOnClickListener {
            // 跳轉到 MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}