# 🎉 Festival Guessing App

這是一款簡單有趣的 Android App，讓使用者透過圖片來猜節日名稱，並記錄答對的題數。

## 📱 App 功能簡介

- **首頁導覽**：進入遊戲的主選單畫面。
- **節日猜謎**：顯示一張與節日相關的圖片，使用者需輸入節日名稱進行猜測。
- **即時反饋**：猜對會顯示「答對了」，並換下一題；猜錯則提示重新輸入。
- **成績顯示**：遊戲結束後跳轉至結果頁面，顯示總共答對的題數。
- **再玩一次**：可重新開始遊戲。

## 📂 專案結構

```
festivalapp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/festivalapp/
│   │   │   │   ├── HomeActivity.kt         # 首頁（導覽畫面）
│   │   │   │   ├── MainActivity.kt         # 節日猜謎邏輯主程式
│   │   │   │   └── ResultActivity.kt       # 顯示結果與再玩一次按鈕
│   │   │   └── res/layout/
│   │   │       ├── activity_home.xml
│   │   │       ├── activity_main.xml
│   │   │       └── activity_result.xml
│   ├── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
└── gradle.properties
```

## 🎮 使用方法

1. 打開 App，進入首頁 `HomeActivity`。
2. 點擊「開始遊戲」按鈕，進入猜謎畫面 `MainActivity`。
3. 輸入對應的節日名稱，答對進入下一題。
4. 所有題目完成後跳轉到 `ResultActivity` 顯示成績。
5. 點選「再玩一次」可重新開始遊戲。

## 🖼️ 已支援的節日圖片（對應文字）包括：

- 聖誕節（`christmas`）
- 萬聖節（`halloween`）
- 中秋節（`midautumn`）
- 端午節（`dragon_boat`）
- 春節（`spring_festival`）

## ✅ 技術棧

- Kotlin
- Android SDK
- Activity 導向設計
- `Intent` 傳遞資料
- `ImageView`, `EditText`, `TextView`, `Button` 控制元件
- 基本資源管理與 UI 互動邏輯

## 🛠️ 建置與執行

```bash
# 使用 Android Studio 開啟專案後即可執行
# 如未安裝，請先下載 Android Studio 並載入本專案資料夾
```

## 🙌 作者

此 App 為練習 Android 基礎 UI 與 Activity 導向設計的範例作品。
