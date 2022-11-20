package uz.sultandev.a2048.ui.dialog.setting

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import com.sultandev.a2048.R
import com.sultandev.a2048.databinding.DialogSettingBinding
import com.sultandev.a2048.ui.dialog.impl.SettingViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingDialog : DialogFragment(R.layout.dialog_setting) {

    private val binding: DialogSettingBinding by viewBinding(DialogSettingBinding::bind)
    private val viewModel: SettingViewModel by viewModels<SettingViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.backClick.observe(this, backClickObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.dialog?.window?.attributes?.windowAnimations = R.style.DialogFragmentAnimation

        binding.musicSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setMusicState(isChecked)
        }

        binding.iconBack.setOnClickListener {
            viewModel.onBackClick()
        }

        viewModel.musicStateLiveData.observe(viewLifecycleOwner, musicStateObserver)
    }

    private val musicStateObserver = Observer<Boolean> {
        binding.musicSwitch.isChecked = it
    }

    private val backClickObserver = Observer<Unit> {
        dismiss()
    }
}