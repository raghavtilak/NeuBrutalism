package com.raghav.neubrutalism

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.RelativeLayout

class NeuBrutalism(context: Context, attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    var bg_marginTop = 6
    var bg_marginStart = 6
    var bg_radius = 3
    var fg_stroke = 3

    val fg = GradientDrawable()
    val bg = GradientDrawable()

    var layout : RelativeLayout
    var bgView : View


    init {
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

        inflate(context, R.layout.neubrutalismbutton, this)
        layout = findViewById(R.id.layout)
        bgView = findViewById(R.id.bgView)

        layout.viewTreeObserver.addOnGlobalLayoutListener {

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
        }
    }

    override fun addView(child: View, index: Int, p: ViewGroup.LayoutParams) {

        if (child.id != R.id.layout) {

            child.viewTreeObserver.addOnGlobalLayoutListener(object :
                ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    child.background = fg

                    val params = LayoutParams(child.width, child.height)
                    params.setMargins(bg_marginStart, bg_marginTop, 0, 0)
                    findViewById<View>(R.id.bgView).layoutParams = params
                    child.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }
            })
        }
        super.addView(child, index, p)
    }
}