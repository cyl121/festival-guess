package com.example.festivalapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // 取得傳遞過來的分數
        val score = intent.getIntExtra("SCORE", 0)

        // 顯示分數
        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        scoreTextView.text = "你答對的題數是：$score"

        // 設置「再玩一次」按鈕的點擊事件
        val playAgainButton = findViewById<Button>(R.id.playAgainButton)
        playAgainButton.setOnClickListener {
            // 跳轉回 MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // 結束當前 Activity
        }
    }
}