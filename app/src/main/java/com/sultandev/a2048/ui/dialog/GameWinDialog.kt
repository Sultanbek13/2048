package com.sultandev.a2048.ui.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.sultandev.a2048.databinding.DialogWinnerBinding

class GameWinDialog(ctx: Context) : Dialog(ctx) {

    private lateinit var binding: DialogWinnerBinding

    private var retryListener: (() -> Unit)? = null
    private var finishListener: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogWinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCancelable(false)
        binding.apply {
            btnNo.setOnClickListener { finishListener?.invoke() }
            btnYes.setOnClickListener { retryListener?.invoke() }
        }
    }

    fun setRetryListener(t: () -> Unit) {
        retryListener = t
    }

    fun setFinishListener(t: () -> Unit) {
        finishListener = t
    }

}