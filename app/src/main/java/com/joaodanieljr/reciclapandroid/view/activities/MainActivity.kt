package com.joaodanieljr.reciclapandroid.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.joaodanieljr.reciclapandroid.R
import com.joaodanieljr.reciclapandroid.view.modelView.ModelView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val modelview:ModelView = ModelView()

        imageButton_metal.setOnClickListener {
            modelview.ClickButton("Amarela","Metais", this)
        }

        imageButton_papel.setOnClickListener {
            modelview.ClickButton("Azul","Papeis", this)
        }

        imageButton_organico.setOnClickListener {
            modelview.ClickButton("Marrom","Organicos", this)
        }

        imageButton_eletronico.setOnClickListener {
            modelview.ClickButton("Laranja","Eletronicos", this)
        }

        imageButton_bateria.setOnClickListener {
            modelview.ClickButton("Roxas","Baterias", this)
        }

        imageButton_naoReciclavel.setOnClickListener {
            modelview.ClickButton("Cinza","Não reciclaveis", this)
        }


        imageButton_plastico.setOnClickListener {
            modelview.ClickButton("Vermelha","Plasticos", this)
        }

        imageButton_oleo.setOnClickListener {
            modelview.ClickButton("Oleo","Liquidos", this)
        }

        imageButton_madeira.setOnClickListener {
            modelview.ClickButton("preta","Madeiras", this)
        }
    }

}