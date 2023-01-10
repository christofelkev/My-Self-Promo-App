package org.chrivin.selfpromoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPreview.setOnClickListener {
            onPreviewClick()
        }
        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer")
        val spinnerAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        spinnerJobTitle.adapter = spinnerAdapter
    }

    private fun onPreviewClick() {
        val message = Message(
            editTextContactName.text.toString(),
            editTextContactNumber.text.toString(),
            editTextMyDisplayName.text.toString(),
            checkBoxJunior.isChecked,
            spinnerJobTitle.selectedItem?.toString(),
            checkBoxImmediateStart.isChecked,
            editTextStartDate.text.toString()
        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)
        startActivity(previewActivityIntent)
    }
}