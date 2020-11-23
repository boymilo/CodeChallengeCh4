package com.example.codechallenge

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.view.isVisible as viewIsVisible

class MainActivity : AppCompatActivity() {
    val controller = Controller()
    var guntingBatuKertas = GuntingBatuKertas()

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_main);
        controller.setGuntingBatuKertas(guntingBatuKertas)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivBatu.setOnClickListener {
            controller.setPlayer1("batu")
            controller.setPlayer2()
            play()
        }

        ivGunting.setOnClickListener {
            controller.setPlayer1("gunting")
            controller.setPlayer2()
            play()
        }

        ivKertas.setOnClickListener {
            controller.setPlayer1("kertas")
            controller.setPlayer2()
            play()
        }

        ivNewGame.setOnClickListener{
            reset()
        }
    }


    fun play(){
        when(guntingBatuKertas.getPlayer2()){
            "gunting"-> ivGuntingCom.setBackgroundResource(R.drawable.ic_backgroud_clik)
            "batu" -> ivBatuCom.setBackgroundResource(R.drawable.ic_backgroud_clik)
            "kertas" -> ivKertasCom.setBackgroundResource(R.drawable.ic_backgroud_clik)
        }

        when(guntingBatuKertas.getPlayer1()){
            "gunting"-> ivGunting.setBackgroundResource(R.drawable.ic_backgroud_clik)
            "batu" -> ivBatu.setBackgroundResource(R.drawable.ic_backgroud_clik)
            "kertas" -> ivKertas.setBackgroundResource(R.drawable.ic_backgroud_clik)
        }
        tvResult.setText(controller.result())
        if(controller.result() == "DRAW!"){
            tvDraw.setVisibility(View.VISIBLE)
        }
        else{
            tvResult.setVisibility(View.VISIBLE)
        }
        tvVS.setVisibility(View.INVISIBLE)

        ivGunting.isClickable = false
        ivBatu.isClickable = false
        ivKertas.isClickable = false

        Log.e("Main Activity","Player 1 :${controller.getPlayer1()}")
        Log.e("Main Activity","Player 2 :${controller.getPlayer2()}")
        Log.e("Main Activity","Result :${controller.result()}")

    }

    fun reset(){
        when(guntingBatuKertas.getPlayer2()){
            "gunting" -> ivGuntingCom.setBackgroundResource(R.drawable.ic_background)
            "batu" -> ivBatuCom.setBackgroundResource(R.drawable.ic_background)
            "kertas" -> ivKertasCom.setBackgroundResource(R.drawable.ic_background)
        }

        when(guntingBatuKertas.getPlayer1()){
            "gunting" -> ivGunting.setBackgroundResource(R.drawable.ic_background)
            "batu" -> ivBatu.setBackgroundResource(R.drawable.ic_background)
            "kertas" -> ivKertas.setBackgroundResource(R.drawable.ic_background)
        }

        tvVS.setVisibility(View.VISIBLE)
        tvResult.setVisibility(View.INVISIBLE)
        tvDraw.setVisibility(View.INVISIBLE)

        ivGunting.isClickable = true
        ivBatu.isClickable = true
        ivKertas.isClickable = true
    }
}