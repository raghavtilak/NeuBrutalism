package com.raghav.neubrutalism

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.RelativeLayout

class NeuBrutalismView(context: Context, attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    var bg_marginTop = 6
    var bg_marginStart = 6
    var bg_radius = 3
    var fg_strokeWidth = 3
    var bg_shadowColor = Color.BLACK
        set(value) {
            field = value
            applyBackground()
        }
    var fg_color = Color.WHITE
    var fg_strokeColor = Color.BLACK


    private val fg = GradientDrawable()
    private val bg = GradientDrawable()

    private var layout: RelativeLayout
    private var bgView: View?

    private var onClick: () -> Unit = {}

    init {
        val a = context.obtainStyledAttributes(
            attrs,
            R.styleable.NeuBrutalismView, 0, 0
        )
        bg_marginTop = a.getDimensionPixelSize(R.styleable.NeuBrutalismView_bg_marginTop, 6)
        bg_marginStart = a.getDimensionPixelSize(R.styleable.NeuBrutalismView_bg_marginStart, 6)
        bg_radius = a.getDimensionPixelSize(R.styleable.NeuBrutalismView_bg_radius, 3)
        fg_strokeWidth = a.getDimensionPixelSize(R.styleable.NeuBrutalismView_fg_strokeWidth, 3)
        bg_shadowColor = a.getColor(R.styleable.NeuBrutalismView_bg_shadowColor, Color.BLACK)
        fg_color = a.getColor(R.styleable.NeuBrutalismView_fg_color, Color.WHITE)
        fg_strokeColor = a.getColor(R.styleable.NeuBrutalismView_fg_strokeColor, Color.BLACK)
        a.recycle()
    }

    init {

        inflate(context, R.layout.neubrutalismview, this)
        layout = findViewById(R.id.layout)
        bgView = findViewById(R.id.bgView)

        layout.viewTreeObserver.addOnGlobalLayoutListener {

            applyBackground()
            fg.apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = bg_radius.toFloat()
                setStroke(fg_strokeWidth, ColorStateList.valueOf(fg_strokeColor))
                color = ColorStateList.valueOf(fg_color)
            }
        }
    }

    private fun applyBackground() {
        bg.apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = bg_radius.toFloat()
            color = ColorStateList.valueOf(bg_shadowColor)
        }
        bgView?.background = bg
    }

    @SuppressLint("ClickableViewAccessibility")
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

            child.setOnTouchListener { _, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        child.translationX = bg_marginStart.toFloat()
                        child.translationY = bg_marginTop.toFloat()
                    }
                    MotionEvent.ACTION_UP -> {
                        child.translationX = 0f
                        child.translationY = 0f
                        onClick.invoke()
                    }
                }
                true
            }
        }
        super.addView(child, index, p)
    }

    public fun setOnClickListener(onClick: () -> Unit) {
        this.onClick = onClick
    }


}