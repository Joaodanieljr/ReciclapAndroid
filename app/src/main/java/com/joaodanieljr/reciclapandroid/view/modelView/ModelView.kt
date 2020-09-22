package com.joaodanieljr.reciclapandroid.view.modelView

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.joaodanieljr.reciclapandroid.view.activities.ListMateriais

class ModelView: ViewModel() {


    fun ClickButton(extra1:String, extra2: String, context:Context){
        val i = Intent(context, ListMateriais::class.java)
        i.putExtra("key", extra1)
        i.putExtra("tipoMaterial", extra2)
        context.startActivity(i)
    }
}