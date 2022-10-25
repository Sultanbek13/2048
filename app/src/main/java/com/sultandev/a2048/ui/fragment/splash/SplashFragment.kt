package com.sultandev.a2048.ui.fragment.splash

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sultandev.a2048.R
import com.sultandev.a2048.ui.fragment.splash.impl.SplashViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment: Fragment(R.layout.fragment_splash) {

    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.showSplashLiveData.observe(this, showSplashObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.showSplash()

    }

    private val showSplashObserver = Observer<Unit> {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMenuFragment())
    }

    private fun setAnimationPilot(view: View) {
        view.translationX
        val rotation = ObjectAnimator.ofFloat(view, "rotation", 0f, 100f)
        val translationX = ObjectAnimator.ofFloat(view, "translationX", view.x, view.x - 3000f)
        val translationY = ObjectAnimator.ofFloat(view, "translationY", view.y, view.x - 2800f)

        AnimatorSet().apply {
            play(rotation).with(translationX).with(translationY)
            duration = 2000
            start()
        }
    }
}