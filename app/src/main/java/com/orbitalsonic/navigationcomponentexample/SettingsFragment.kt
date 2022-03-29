package com.orbitalsonic.navigationcomponentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment


class SettingsFragment : Fragment() {

    private lateinit var etDefaultAmount:EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etDefaultAmount = view.findViewById(R.id.et_default_amount)
        etDefaultAmount.setText(SampleData.defaultAmount.value.toString())

        view.findViewById<Button>(R.id.btn_save_default_amount).setOnClickListener {
            val defaultAmount = etDefaultAmount.text.toString().toLong()
            SampleData.defaultAmount.value = defaultAmount

        }
       view.findViewById<Button>(R.id.btn_about_app).setOnClickListener {

        }

    }
}