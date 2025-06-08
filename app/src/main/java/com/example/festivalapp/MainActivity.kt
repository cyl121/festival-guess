package com.example.festivalapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var guessInput: EditText
    private lateinit var guessButton: Button
    private lateinit var resultText: TextView
    private lateinit var backToHomeButton: Button // 新增返回首頁按鈕

    // 使用 Pair 來關聯圖片資源和節日名稱
    private val festivalData = mutableListOf(
        Pair(R.drawable.christmas, "聖誕節"), // 圖片檔名為 christmas.png
        Pair(R.drawable.halloween, "萬聖節"), // 圖片檔名為 halloween.png
        Pair(R.drawable.midautumn, "中秋節"),  // 圖片檔名為 midautumn.png
        Pair(R.drawable.dragon_boat, "端午節"),
        Pair(R.drawable.spring_festival, "春節"),
        Pair(R.drawable.egg, "端午節"),
        Pair(R.drawable.zongzi, "端午節"),
        Pair(R.drawable.ghost, "萬聖節"),
        Pair(R.drawable.gift, "聖誕節"),
        Pair(R.drawable.santa, "聖誕節"),
        Pair(R.drawable.snowman, "聖誕節"),
        Pair(R.drawable.sock, "聖誕節")
    )

    private var currentFestivalIndex = 0
    private var score = 0 // 記錄分數
    private var isGameOver = false // 遊戲是否結束

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 初始化視圖
        imageView = findViewById(R.id.imageView)
        guessInput = findViewById(R.id.guessInput)
        guessButton = findViewById(R.id.guessButton)
        resultText = findViewById(R.id.resultText)
        backToHomeButton = findViewById(R.id.backToHomeButton) // 初始化返回首頁按鈕

        // 設置返回首頁按鈕的點擊事件
        backToHomeButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // 結束當前 Activity
        }

        // 重置遊戲狀態
        resetGame()

        // 隨機顯示一張圖片
        showRandomImage()

        // 設置猜測按鈕的點擊事件
        guessButton.setOnClickListener {
            if (!isGameOver) {
                checkGuess()
            }
        }
    }

    private fun resetGame() {
        // 重置圖片和節日名稱列表
        resetFestivalList()
        // 重置分數和遊戲狀態
        score = 0
        isGameOver = false
        resultText.text = ""
        guessInput.text.clear()
    }

    private fun showRandomImage() {
        if (festivalData.isEmpty()) {
            // 如果所有圖片都已顯示過，結束遊戲
            endGame()
            return
        }

        val random = Random()
        currentFestivalIndex = random.nextInt(festivalData.size)
        imageView.setImageResource(festivalData[currentFestivalIndex].first)
    }

    private fun checkGuess() {
        val userGuess = guessInput.text.toString()
        val correctAnswer = festivalData[currentFestivalIndex].second

        if (userGuess.equals(correctAnswer, ignoreCase = true)) {
            resultText.text = "恭喜！猜對了！"
            score++ // 答對加一分
        } else {
            resultText.text = "猜錯了，正確答案是：$correctAnswer"
            // 延遲 3 秒後跳轉到計分畫面
            Handler(Looper.getMainLooper()).postDelayed({
                endGame()
            }, 3000) // 延遲 3 秒
            return
        }

        // 移除已顯示的圖片和節日名稱
        festivalData.removeAt(currentFestivalIndex)

        // 清空輸入框
        guessInput.text.clear()

        // 顯示下一張圖片
        showRandomImage()
    }

    private fun endGame() {
        isGameOver = true

        // 跳轉到 ResultActivity 並傳遞分數
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("SCORE", score)
        startActivity(intent)
        finish() // 結束當前 Activity
    }

    private fun resetFestivalList() {
        // 重置圖片和節日名稱列表
        festivalData.clear()
        festivalData.addAll(listOf(
            Pair(R.drawable.christmas, "聖誕節"), // 圖片檔名為 christmas.png
            Pair(R.drawable.halloween, "萬聖節"), // 圖片檔名為 halloween.png
            Pair(R.drawable.midautumn, "中秋節"),  // 圖片檔名為 midautumn.png
            Pair(R.drawable.dragon_boat, "端午節"),
            Pair(R.drawable.spring_festival, "春節"),
            Pair(R.drawable.egg, "端午節"),
            Pair(R.drawable.zongzi, "端午節"),
            Pair(R.drawable.ghost, "萬聖節"),
            Pair(R.drawable.gift, "聖誕節"),
            Pair(R.drawable.santa, "聖誕節"),
            Pair(R.drawable.snowman, "聖誕節"),
            Pair(R.drawable.sock, "聖誕節")
        ))
    }
}