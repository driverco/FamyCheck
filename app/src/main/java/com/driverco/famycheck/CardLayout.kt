package com.driverco.famycheck
import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class CardLayout : LinearLayout {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context,
        attrs,
        defStyleAttr) {
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        when {
            heightMeasureSpec < widthMeasureSpec -> {
                super.onMeasure(widthMeasureSpec, widthMeasureSpec)
            }
            widthMeasureSpec < heightMeasureSpec -> {
                super.onMeasure(heightMeasureSpec, heightMeasureSpec)
            }
            else -> {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            }
        }
    }
}