package com.john.coroutine_scope_exception

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.john.coroutine_scope_exception.databinding.ActivityMainBinding
import com.john.coroutine_scope_exception.model.MainBrain
import com.john.coroutine_scope_exception.view.MainView
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    //View
    private lateinit var mMainView: MainView
    //Model
    private val mainBrain = MainBrain()
    //ViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setContentView(mMainView.getRootView())
        setupView()
        initEvent()

    }

    override fun onStop() {
        super.onStop()
        mainBrain.release()
    }

    private fun initView() {
        mMainView = MainView(this)
    }

    private fun setupView() {
        mMainView.initView()
    }

    private fun initEvent() {
        mMainView.initEvent {
            mainBrain.processCallbackEvent(it)
        }
    }
}