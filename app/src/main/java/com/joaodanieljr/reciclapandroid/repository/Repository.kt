package com.joaodanieljr.reciclapandroid.repository

import com.joaodanieljr.reciclapandroid.db.DBHelper
import com.joaodanieljr.reciclapandroid.model.Materiais
import java.util.ArrayList

fun CriarRepository():List<Materiais>{
    return listOf(

        Materiais(1, "Caixa de Papelao",
            "Azul",
            "Celulose",
            "3 a 6 meses",
            "Material de facil reciclagem e com um bom valor de venda em industrias de reciclagem",
            "Generica"),

        Materiais(2, "Caixa de leite Parmalat",
            "Azul",
            "Celulose",
            "3 a 6 meses",
            "Material de facil reciclagem e com um bom valor de venda em industrias de reciclagem",
            "Parmalat LTDA"),

        Materiais(3, "Caixa de Sabão em Pó OMO",
            "Azul",
            "Celulose",
            "3 a 6 meses",
            "Material de facil reciclagem e com um bom valor de venda em industrias de reciclagem",
            "OMO"),

        Materiais(4, "Caixa de Pizza",
            "Azul",
            "Celulose",
            "3 a 6 meses",
            "Material de facil reciclagem e com um bom valor de venda em industrias de reciclagem",
            "Generica"),

        Materiais(5, "Garrafa Pet Coca cola",
            "Vermelha",
            "Plastico",
            "10 meses",
            "Material de facil reciclagem e com um bom valor de venda em industrias de reciclagem",
            "Coca-Cola"),

        Materiais(6, "Garrafa Pet Guarana Antartica",
            "Vermelha",
            "Plastico",
            "15 meses",
            "Material de facil reciclagem e com um bom valor de venda em industrias de reciclagem",
            "Antartica Ltda"),

        Materiais(7, "Garrafa Pet Bonafont",
            "Vermelha",
            "Plastico",
            "15 meses",
            "Material de facil reciclagem e com um bom valor de venda em industrias de reciclagem",
            "Bonafont Ltda")


    )
}



