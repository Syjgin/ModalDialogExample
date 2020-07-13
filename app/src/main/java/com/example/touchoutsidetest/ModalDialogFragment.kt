package com.example.touchoutsidetest

import android.graphics.Point
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment

class ModalDialogFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.modal_dialog, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(
            STYLE_NO_FRAME,
            R.style.BaseDialogFragment
        )
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val window = dialog.window
            if (window != null) {
                val attrs = window.attributes
                val display: Display = activity!!.windowManager!!.defaultDisplay
                val size = Point()
                display.getSize(size)
                val width: Int = size.x
                val height: Int = size.y - 300
                attrs.width = width
                attrs.height = height
                attrs.flags = attrs.flags or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                window.attributes = attrs
            }
        }
    }
}