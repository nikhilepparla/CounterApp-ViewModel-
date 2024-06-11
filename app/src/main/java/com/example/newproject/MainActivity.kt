package com.example.newproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var myViewModel: MyViewModel
    private var TAG: String = "Nikhil"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        setContentView(viewBinding.root)
        myViewModel.counter.observe(this, Observer { count ->
            viewBinding.textviewCounter.text = count.toString()
        })
        viewBinding.buttonC.setOnClickListener {
            myViewModel.incrementCounter()
        }
    }
}