package com.example.testgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.testgame.sharedPreferences.AppPreferences
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var tvScore: TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val btnNewGame = findViewById<Button>(R.id.btn_new_game)
        val btnResetScore = findViewById<Button>(R.id.btn_reset_score)
        val btnExit = findViewById<Button>(R.id.btn_exit)
        val tvHighScore = findViewById<TextView>(R.id.high_score)
        tvScore = findViewById<TextView>(R.id.score)

        btnNewGame.setOnClickListener(this::handleNewGame)
        btnResetScore.setOnClickListener(this::handleResetScore)
        btnExit.setOnClickListener(this::handleExitEvent)

//        tvScore.setText(AppPreferences(this).getHighScore())
    }

    private fun handleNewGame(view: View){
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    private fun handleResetScore(view: View){
        val preferences = AppPreferences(this)
        preferences.clearHighScore()
        tvScore?.text = (preferences.getHighScore().toString())
        Toast.makeText(this, R.string.rest_score_success, Toast.LENGTH_SHORT).show()
//        Snackbar.make(view, "Score successfully reset", Snackbar.LENGTH_SHORT).show()
    }

    private fun handleExitEvent(view: View){
        System.exit(0)
    }
}