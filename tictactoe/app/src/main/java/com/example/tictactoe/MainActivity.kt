package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.Random
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var b1:Button
    lateinit var b2:Button
    lateinit var b3:Button
    lateinit var b4:Button
    lateinit var b5:Button
    lateinit var b6:Button
    lateinit var b7:Button
    lateinit var b8:Button
    lateinit var b9:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1 = findViewById(R.id.bu1)
        b2 = findViewById(R.id.bu2)
        b3 = findViewById(R.id.bu3)
        b4 = findViewById(R.id.bu4)
        b5 = findViewById(R.id.bu5)
        b6 = findViewById(R.id.bu6)
        b7 = findViewById(R.id.bu7)
        b8 = findViewById(R.id.bu8)
        b9 = findViewById(R.id.bu9)
    }

    fun buclick(view: View) {

        val buSelected = view as Button

        var btID = 0
        when(buSelected.id){
            R.id.bu1 -> btID = 1
            R.id.bu2 -> btID = 2
            R.id.bu3 -> btID = 3
            R.id.bu4 -> btID = 4
            R.id.bu5 -> btID = 5
            R.id.bu6 -> btID = 6
            R.id.bu7 -> btID = 7
            R.id.bu8 -> btID = 8
            R.id.bu9 -> btID = 9
        }

//        Log.d("buclick:",btID.toString())

        playgame(btID,buSelected)
    }

    var activeplayer = 1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playgame(btID:Int,buSelected:Button){

        if(activeplayer == 1){
            buSelected.text = "X"
            buSelected.setBackgroundResource(R.color.green)
            player1.add(btID)
            activeplayer = 2
//            autoPlay()
//            restartgame()
        }else{
            buSelected.text = "O"
            buSelected.setBackgroundResource(R.color.red)
            player2.add(btID)
            activeplayer = 1
//            restartgame()
        }

        buSelected.isEnabled = false

        checkwinner()


    }

    fun checkwinner(){

        var winner = 10

        //check rows
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }


        //check columns
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //cross check
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }

        //declare a result
        if (winner == 1){
            player1winscount = player1winscount + 1
            Toast.makeText(this,"Player 1 win the game..",Toast.LENGTH_LONG).show()
            restartgame()
        }
        else if(winner == 2){
            player2winscount = player2winscount + 2
            Toast.makeText(this,"Player 2 win the game..",Toast.LENGTH_LONG).show()
            restartgame()
        }
    }

//    fun autoPlay(){
//
//        var emptycells = ArrayList<Int>()
//
//        for (btID in 1..9){
//            if(!(player1.contains(btID) ||player2.contains(btID))){
//                emptycells.add(btID)
//            }
//        }
//
//        if (emptycells.size == 0){
//            restartgame()
//        }
//
//
//        val r = Random()
//        val rnIndex = r.nextInt(emptycells.size)
//        val btID = emptycells[rnIndex]
//        var buSelected:Button?
//        buSelected= when(btID){
//            1 -> b1
//            2 -> b2
//            3 -> b3
//            4 -> b4
//            5 -> b5
//            6 -> b6
//            7 -> b7
//            8 -> b8
//            9 -> b9
//            else ->{b1}
//        }
//        playgame(btID, buSelected)
//    }

    var player1winscount = 0
    var player2winscount = 0
    fun restartgame(){
        activeplayer = 1
        player1.clear()
        player2.clear()

        for (btID in 1..9){
            var buSelected:Button = when(btID){
                1 -> b1
                2 -> b2
                3 -> b3
                4 -> b4
                5 -> b5
                6 -> b6
                7 -> b7
                8 -> b8
                9 -> b9
                else ->{b1}
            }
            buSelected.text = ""
            buSelected.setBackgroundResource(R.color.white)
            buSelected.isEnabled = true
        }

        Toast.makeText(this,"Player 1:  $player1winscount,   Player 2:  $player2winscount ",Toast.LENGTH_SHORT).show()
    }

}