package com.example.codechallenge

import kotlin.random.Random

class Controller(){
    private var guntingBatuKertas:GuntingBatuKertas? = null
    private val player2 = arrayOf("gunting", "batu", "kertas")
    fun result():String{
        var result = ""
        if(guntingBatuKertas!!.getPlayer1() == guntingBatuKertas!!.getPlayer2()){
            result = "DRAW!"
        }
        else if((guntingBatuKertas!!.getPlayer1() == "kertas" && guntingBatuKertas!!.getPlayer2() == "batu") || (guntingBatuKertas!!.getPlayer1() == "batu" && guntingBatuKertas!!.getPlayer2() == "gunting") || (guntingBatuKertas!!.getPlayer1() == "gunting" && guntingBatuKertas!!.getPlayer2() == "kertas")){
            result = "Pemain 1 MENANG!"
        }
        else{
            result = "Pemain 2 MENANG!"
        }
        return result
    }

    fun setGuntingBatuKertas(guntingBatuKertas: GuntingBatuKertas){
        this.guntingBatuKertas = guntingBatuKertas
    }

    fun setPlayer1(player1:String){
        guntingBatuKertas?.setPlayer1(player1.toLowerCase())
    }

    fun setPlayer2() {
        guntingBatuKertas?.setPlayer2(player2.random())
    }

    fun getPlayer1():String{
        return guntingBatuKertas?.getPlayer1().toString()
    }

    fun getPlayer2():String{
        return guntingBatuKertas?.getPlayer2().toString()
    }

}