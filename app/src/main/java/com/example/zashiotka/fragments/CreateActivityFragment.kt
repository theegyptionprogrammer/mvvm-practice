package com.example.zashiotka.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zashiotka.R
import com.example.zashiotka.mvvm_components.ApplicationScope
import com.example.zashiotka.mvvm_components.IZashiotkaModule
import com.example.zashiotka.roomDB.Zashiotka
import kotlinx.android.synthetic.main.view_create_zashiotka.*
import toothpick.Toothpick
import javax.inject.Inject

class CreateActivityFragment : Fragment() {

    @Inject
    lateinit var module : IZashiotkaModule

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toothpick.inject(this , ApplicationScope.scope)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_acitvity , container , false)
    }

    fun saveZashiotka(callback: (Boolean)->Unit){
        createZashiotka()?.let {
            module.insert(it){
                callback.invoke(true)
            }
        }?: callback.invoke(false)
    }

    private fun createZashiotka() : Zashiotka? = if (!nullFieldChecker()){
        Zashiotka(
            studentId = studentIdET.editableText.toString().toInt(),
            studentName = studentNameET.editableText.toString(),
            englishSubject = englishET.editableText.toString().toDouble(),
            informaticsSubject = informaticsET.editableText.toString().toDouble()
        )
    } else {
        null
    }

    private fun nullFieldChecker() :Boolean {
        studentNameET.editableText.isNullOrEmpty()
        studentIdET.editableText.isNullOrEmpty()
        englishET.editableText.isNullOrEmpty()
        informaticsET.editableText.isNullOrEmpty()
        return true
    }


    companion object{
        fun newInstance() = CreateActivityFragment()
    }
}