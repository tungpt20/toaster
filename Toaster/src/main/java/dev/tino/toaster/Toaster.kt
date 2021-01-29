package dev.tino.toaster

import android.content.Context
import android.view.Gravity
import android.widget.Toast

object Toaster {
    fun toastMessage(
            context: Context,
            message: String,
            gravity: Int? = null,
            xOffset: Int? = null,
            yOffset: Int? = null,
            isLongToast: Boolean = false
    ) {
        val toast = Toast.makeText(
                context,
                message,
                if (isLongToast) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
        )
        gravity?.let {
            toast.setGravity(it, 0, 0)
        }
        xOffset?.let {
            toast.setGravity(Gravity.BOTTOM, it, 0)
            gravity?.let { gravity ->
                toast.setGravity(gravity, it, 0)
            }
        }
        yOffset?.let { y ->
            toast.setGravity(Gravity.BOTTOM, 0, y)
            xOffset?.let { x ->
                toast.setGravity(Gravity.BOTTOM, x, y)
                gravity?.let { gravity ->
                    toast.setGravity(gravity, x, y)
                }
            }
        }
        toast.show()
    }
}