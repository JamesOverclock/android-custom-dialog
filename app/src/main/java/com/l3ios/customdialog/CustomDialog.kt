package com.l3ios.customdialog

import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.view_custom_dialog.*

class CustomDialog : DialogFragment() {

    var onOkClickListener: (() -> Unit)? = null
    var onCloseClickListener: (() -> Unit)? = null

    companion object {
        fun newInstance(): CustomDialog = CustomDialog().apply {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.view_custom_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog?.window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )

        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)

        btnOk.setOnClickListener {
            onOkClickListener?.invoke()
            dismiss()
        }

        btnCancel.setOnClickListener {
            onCloseClickListener?.invoke()
            dismiss()
        }
    }

}