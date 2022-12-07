package com.example.demopadc

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.activity_first.view.*
import kotlinx.android.synthetic.main.activity_second.*

class FirstActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        Toast.makeText(this,"onCreate invoked", Toast.LENGTH_SHORT).show()


        btnclickme.setOnClickListener {
//            Toast.makeText(this,"Toast Invoked",Toast.LENGTH_SHORT).show()
//            startActivity(Intent(SecondActivity.newIntent(this)))
//            startActivity(Intent(SecondActivity.newIntent(this,"How are You?")))
            startActivityForResult(SecondActivity.newIntent(this,"How are You?"),100)
        }
//        btnclick.setOnLongClickListener(
//            object :View.OnLongClickListener {
//                override fun onLongClick(v: View?): Boolean {
//                    tvstate.text= "Being clicked too long"
//                    return false
//
//                }
//
//            }
//        )
//        btnclick.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                tvstate.text="too soon"
//
//            }
//        })


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==100 && resultCode == Activity.RESULT_OK && data !=null){
            val dataReturn = data.getStringExtra("DATA TO RETURN")
            textview.text = dataReturn
        }
    }




    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"onStart invoked",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"onResume invoked",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"onPause invoked",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"onStop invoked",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"onDestroy invoked", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"onRestart invoked", Toast.LENGTH_SHORT).show()
    }
}