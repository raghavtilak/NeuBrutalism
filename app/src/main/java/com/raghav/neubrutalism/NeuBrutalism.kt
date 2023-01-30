package com.raghav.neubrutalism

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView

class NeuBrutalism : RelativeLayout {

    var bg_marginTop = 6
    var bg_marginStart = 6
    var bg_radius = 3
    var fg_stroke = 3

    val fg = GradientDrawable()
    val bg = GradientDrawable()

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {

        val a = context.obtainStyledAttributes(
            attrs,
            R.styleable.NeuBrutalism, 0, 0
        )
        bg_marginTop = a.getDimensionPixelSize(R.styleable.NeuBrutalism_bg_marginTop, 6)
        bg_marginStart = a.getDimensionPixelSize(R.styleable.NeuBrutalism_bg_marginStart, 6)
        bg_radius = a.getDimensionPixelSize(R.styleable.NeuBrutalism_bg_radius, 3)
        fg_stroke = a.getDimensionPixelSize(R.styleable.NeuBrutalism_fg_stroke, 3)
        a.recycle()

    }

    init {

        inflate(context,R.layout.neubrutalismbutton,this)
        val textview = findViewById<TextView>(R.id.textview)
        val bgView = findViewById<View>(R.id.bgView)
        val layout = findViewById<RelativeLayout>(R.id.layout)

        layout.viewTreeObserver.addOnGlobalLayoutListener {

            val params = LayoutParams(textview.width, textview.height)
            params.setMargins(bg_marginStart, bg_marginTop, 0, 0)
            bgView.layoutParams = params

            bg.apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = bg_radius.toFloat()
                color = ColorStateList.valueOf(Color.BLACK)
            }
            bgView.background = bg

            fg.apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = bg_radius.toFloat()
                setStroke(fg_stroke, ColorStateList.valueOf(Color.BLACK))
                color = ColorStateList.valueOf(Color.WHITE)
            }
            textview.background = fg
        }
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
}