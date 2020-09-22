package com.joaodanieljr.reciclapandroid.model


data class Materiais (

   var id: Int = 0,
   var nome:String ?= "",
   var lixeira: String ?= "",
   var composicao:String ?= "",
   var decomposicao: String ?= "",
   var informacao: String ?= "",
   var empresa: String ?= "",
   var localReciclar:String ?= ""


)