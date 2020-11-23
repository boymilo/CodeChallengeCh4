package com.example.codechallenge

data class GuntingBatuKertas (private var player1:String? = null, private var player2:String? = null){
    fun getPlayer1(): String?{
        return player1
    }

    fun setPlayer1(player1: String?){
        this.player1 = player1
    }

    fun getPlayer2(): String?{
        return player2
    }

    fun setPlayer2(player2: String) {
        this.player2 = player2
    }
}