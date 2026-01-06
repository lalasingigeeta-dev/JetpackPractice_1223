package com.example.counterapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel

import com.example.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    lateinit var increment: Button
    lateinit var count: TextView
    private val myViewModel: CounterModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
        increment=findViewById<Button>(R.id.increment)
        count=findViewById<TextView>(R.id.count)
        myViewModel.counter.observe(this){
            count.text=it.toString()
        }
        increment.setOnClickListener {
            myViewModel.increment()
        }

    }
}

