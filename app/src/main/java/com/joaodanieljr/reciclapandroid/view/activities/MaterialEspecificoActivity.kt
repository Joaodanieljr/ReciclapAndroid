package com.joaodanieljr.reciclapandroid.view.activities

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Transformations.map
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.joaodanieljr.reciclapandroid.R
import kotlinx.android.synthetic.main.activity_material_especifico.*


class MaterialEspecificoActivity : AppCompatActivity(), OnMapReadyCallback {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_especifico)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)

        var nome:String
        var lixeira:String
        var composicao:String
        var decomposicao:String
        var informacao:String
        var empresa:String
        var local:String

        val extras = intent.extras


        nome = extras?.getString("nome").toString()
        lixeira = extras?.getString("lixeira").toString()
        composicao = extras?.getString("composicao").toString()
        decomposicao = extras?.getString("decomposicao").toString()
        informacao = extras?.getString("informacao").toString()
        empresa = extras?.getString("empresa").toString()
        local = extras?.getString("local").toString()


        textView_nome.setText(nome)
        textView_lixeira.setText(lixeira)
        textView_composicao.setText(composicao)
        textView_decomposicao.setText(decomposicao)
        textView_informacao.setText(informacao)
        textView_empresa.setText(empresa)

    }

    override fun onMapReady(googleMap: GoogleMap?) {
        val unidades = arrayOf(arrayOf("Ecoponto viaduto Antártica","Rua Robert Bosch, 242 \nSão Paulo-SP\n CEP:05003-020"),
            arrayOf("Ecoponto Vila Mariana","Rua Afonso Celso, 147 \nSão Paulo-SP\nCEP:04119-002"),
            arrayOf("Ecoponto Barra Funda","Rua Solon,\nSão Paulo-SP\nCEP:01135-020"))


        val ecoponto_viaduto_antartica = LatLng(-23.5278505, -46.6743723)
        val ecoponto_Berini = LatLng( -23.5966548, -46.6912900)
        val ecoponto_barrafunda = LatLng( -23.526779, -46.6508677)
        googleMap?.addMarker(MarkerOptions()
            .position(ecoponto_viaduto_antartica)
            .title(unidades[0][0])
            .snippet(unidades[0][1]).icon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))

        googleMap?.addMarker(MarkerOptions()
            .position(ecoponto_Berini)
            .title(unidades[1][0])
            .snippet(unidades[1][1])
            .icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))

        googleMap?.addMarker(MarkerOptions()
            .position(ecoponto_barrafunda)
            .title(unidades[2][0])
            .snippet(unidades[2][1])
            .icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))

        googleMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(ecoponto_barrafunda, 12.5F))

        googleMap?.setInfoWindowAdapter(object : GoogleMap.InfoWindowAdapter {
            override fun getInfoWindow(arg0: Marker): View? {
                return null
            }

            override fun getInfoContents(marker: Marker): View {
                val info = LinearLayout(applicationContext)
                info.orientation = LinearLayout.VERTICAL
                val title = TextView(applicationContext)
                title.setTextColor(Color.BLACK)
                title.gravity = Gravity.LEFT
                title.setTypeface(null, Typeface.BOLD)
                title.text = marker.title

                val snippet = TextView(applicationContext)
                snippet.setTextColor(Color.GRAY)
                snippet.text = marker.snippet
                info.addView(title)
                info.addView(snippet)
                return info

            }})

    }
}
