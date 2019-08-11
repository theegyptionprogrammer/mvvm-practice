package com.example.zashiotka.fragments

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.zashiotka.R
import kotlinx.android.synthetic.main.view_create_zashiotka.*

class CreateActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        saveZashiotka()
    }

    private fun saveZashiotka(){
        saveitem.setOnClickListener {
            supportFragmentManager.findFragmentById(R.id.fragmentHolder)?.run {
                if (this is CreateActivityFragment){
                    this.saveZashiotka {success ->
                        if (success){
                            this@CreateActivity.supportFinishAfterTransition()
                        } else {
                            Toast.makeText(context , getString(R.string.error_save) , Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}