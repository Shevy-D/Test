package com.shevy.test

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shevy.test.databinding.ActivityMainBinding
import java.io.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }

        val fileName = binding.editFile
        val fileData = binding.editData

        binding.btnSave.setOnClickListener {
            val file: String = fileName.text.toString()
            val data: String = fileData.text.toString()
            if (file.trim() != "") {
                val fileOutputStream: FileOutputStream
                try {
                    fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
                    fileOutputStream.write(data.toByteArray())
                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                } catch (e: NumberFormatException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                Toast.makeText(applicationContext, "Data save", Toast.LENGTH_LONG).show()
                fileName.text.clear()
                fileData.text.clear()
            } else {
                Toast.makeText(applicationContext, "File name cannot be blank", Toast.LENGTH_LONG)
                    .show()
            }
        }

        binding.btnView.setOnClickListener {
            val filename = fileName.text.toString()
            if (filename.trim() != "") {
                var fileInputStream: FileInputStream? = null
                fileInputStream = openFileInput(filename)
                val inputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader = BufferedReader(inputStreamReader)
                val stringBuilder: StringBuilder = StringBuilder()
                var text: String? = null
                while (run {
                        text = bufferedReader.readLine()
                        text
                    } != null) {
                    stringBuilder.append(text)
                }
                //Displaying data on EditText
                fileData.setText(stringBuilder.toString()).toString()
            } else {
                Toast.makeText(
                    applicationContext,
                    "File name cannot be blank",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
        }

    }
}