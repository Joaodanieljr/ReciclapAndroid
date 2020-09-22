package com.joaodanieljr.reciclapandroid.view.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.joaodanieljr.reciclapandroid.R


class TelaInicial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

    }

    override fun onResume() {
        super.onResume()

        Handler(Looper.getMainLooper()).postDelayed({
            run() {
                val main = Intent(this, MainActivity::class.java);
                startActivity(main);
                finish();
            }
        }, 3000)

    }
}
