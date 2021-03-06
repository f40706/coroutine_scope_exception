package com.john.coroutine_scope_exception.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.john.coroutine_scope_exception.databinding.ActivityMainBinding
import com.john.coroutine_scope_exception.type.BtnTagEnum

class MainView(
    mActivity: AppCompatActivity,
    viewGroup: ViewGroup? = null,
    attachToParent: Boolean = false
): BaseView() {
    private val mBinding = ActivityMainBinding.inflate(LayoutInflater.from(mActivity), viewGroup, attachToParent)
    private var mListener: ((String) -> Unit)? = null
    override fun getRootView() = mBinding.root

    fun initView() {
        mBinding.btnTest.tag = BtnTagEnum.Btn1.name
    }

    fun initEvent(listener: (String) -> Unit) {
        this.mListener = listener
        mBinding.btnTest.setOnClickListener { view ->
            mListener?.also { it(view.tag.toString()) }
        }
    }
}