package com.example.zashiotka.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.zashiotka.R
import kotlinx.android.synthetic.main.view_create_zashiotka.*

class CreateActivity: AppCompatActivity() , CreateActivityFragment.OnFragmentInteractionListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        replaceFragment(CreateActivityFragment.newInstance())
        saveitem.setOnClickListener { saveZashiotka() }
    }

    private fun saveZashiotka(){
        saveitem.setOnClickListener {
            supportFragmentManager.findFragmentById(R.id.fragmentHolder)?.run {
                if (this is CreateActivityFragment){
                    this.saveZashiotka {success ->
                        if (success){
                            this@CreateActivity.supportFinishAfterTransition()
                        } else {
                            Toast.makeText(this@CreateActivity , getString(R.string.error_save) , Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentHolder , fragment)
            .commit()
    }

    override fun onFragmentInteraction() {

    }

}