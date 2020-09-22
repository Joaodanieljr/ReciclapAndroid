package com.joaodanieljr.reciclapandroid.view.activities


import android.content.Intent
import android.icu.lang.UCharacter
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout.VERTICAL
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.joaodanieljr.reciclapandroid.R
import com.joaodanieljr.reciclapandroid.db.DBHelper
import com.joaodanieljr.reciclapandroid.model.Materiais
import com.joaodanieljr.reciclapandroid.repository.CriarRepository
import com.joaodanieljr.reciclapandroid.view.adapter.MateriaisAdapter
import com.joaodanieljr.reciclapandroid.view.adapter.MaterialListClickListener
import kotlinx.android.synthetic.main.activity_lista_materiais.*
import kotlinx.android.synthetic.main.activity_main.*


class ListMateriais : AppCompatActivity(), MaterialListClickListener {


    private lateinit var db:DBHelper
    private var listaMateriais:List<Materiais> = ArrayList<Materiais>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_materiais)


        var a = DividerItemDecoration (this ,VERTICAL)
        recyclerView_ListaMateriais.addItemDecoration(a)


        db = DBHelper(this)

        val repository = CriarRepository()
            for (material in repository) {
                db.addMaterial(material)
            }

        val extras = intent.extras
        if (extras != null) {
            val value = extras.getString("key")
            refreshData(value)

            val tipoMaterial = extras.getString("tipoMaterial")
            supportActionBar?.setTitle(tipoMaterial)

        }

    }

    private fun refreshData(where: String?){
        listaMateriais = db.selecionarLista(where)
        val viewAdapter = MateriaisAdapter(listaMateriais,this)

        val viewManager = LinearLayoutManager(this)
        recyclerView_ListaMateriais.apply {
            setHasFixedSize(false)
            layoutManager = viewManager
            adapter = viewAdapter

        }
    }

    override fun onItemClick(item: Materiais, position: Int) {
        var intent:Intent = Intent(this, MaterialEspecificoActivity::class.java)
        intent.putExtra("nome", item.nome)
        intent.putExtra("lixeira", item.lixeira)
        intent.putExtra("composicao", item.composicao)
        intent.putExtra("decomposicao", item.decomposicao)
        intent.putExtra("informacao", item.informacao)
        intent.putExtra("empresa", item.empresa)
        intent.putExtra("local", item.localReciclar)


        startActivity(intent)
    }


}
