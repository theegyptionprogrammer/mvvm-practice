package com.example.zashiotka.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.zashiotka.R
import com.example.zashiotka.database.IzashiotkaModle
import com.example.zashiotka.database.Zashiotka
import com.example.zashiotka.views.AddStudentView
import kotlinx.android.synthetic.main.view_add_student.*

class AddActivityFragment : Fragment()  {

    private lateinit var moduleView : IzashiotkaModle
    private lateinit var contentview : AddStudentView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_acitvity, container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save.setOnClickListener { saveZashiotka() }
    }


    fun saveZashiotka() {
        createZashiotka()?.let {
            moduleView.addZashiotka(it)
        }
    }

    fun createZashiotka() : Zashiotka? = if (!isZashiotkaEmpty()) {
        Zashiotka(
            nameStudent = studentNameET.editableText.toString(),
            idStudent = studentIdET.editableText.toString().toInt(),
            english = englishET.editableText.toString().toDouble(),
            informatics = informaticsET.editableText.toString().toDouble()
        )
    } else {
        null
    }

    private fun isZashiotkaEmpty() : Boolean {
        studentNameET.editableText.isNullOrEmpty()
        studentIdET.editableText.isNullOrEmpty()
        englishET.editableText.isNullOrEmpty()
        informaticsET.editableText.isNullOrEmpty()
        return true
    }

    companion object {
        fun newInstance() = AddActivityFragment()
    }
}