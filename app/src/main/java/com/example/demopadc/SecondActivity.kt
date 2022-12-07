package com.example.demopadc

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    private val IMAGE_REQUEST_CODE=100
    val IE_DATA_TO_RETURN= "DATA TO RETURN"

    companion object{
        private val IE_DATA_TO_SHOW = "data to show"
        fun newIntent(context: Context):Intent{
            return Intent(context,SecondActivity::class.java)
        }
        fun newIntent(context: Context,dataToShow: String):Intent{
            return Intent(context,SecondActivity::class.java).putExtra(IE_DATA_TO_SHOW,dataToShow)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Toast.makeText(this,"onCreate() invoked Second",Toast.LENGTH_SHORT).show()

        ivbtnselect.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type ="image/*"
            startActivityForResult(intent,IMAGE_REQUEST_CODE)

        }
        btnYoutube.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"))
            startActivity(intent)
        }
        btnback.setOnClickListener {
            val intent=Intent().putExtra(IE_DATA_TO_RETURN,"FINE THANK YOU.")
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode== IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data?.data!=null)
        {
            val image =data?.data
            ivSelectedImage.setImageURI(image)

        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"onStart invoked from Second",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"onResume invoked Second",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"onPause invoked Second",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"onStop invoked Second",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"onDestroy invoked Second", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"onRestart invoked Second", Toast.LENGTH_SHORT).show()
    }
}