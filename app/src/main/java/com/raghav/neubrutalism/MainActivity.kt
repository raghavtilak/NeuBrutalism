package com.raghav.neubrutalism

import android.app.Dialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.raghav.neubrutalism.databinding.ActivityMainBinding
import com.raghav.neubrutalism.databinding.DialogLayoutBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.neubrutview.setOnClickListener {
            val binding = DialogLayoutBinding
                .inflate(this@MainActivity.layoutInflater, null, false)
            val backgroundShapeModel: ShapeAppearanceModel = ShapeAppearanceModel.builder()
                .setTopLeftCorner(CornerFamily.ROUNDED, binding.foreview.bg_radius.toFloat())
                .setTopRightCorner(CornerFamily.ROUNDED, binding.foreview.bg_radius.toFloat())
                .build()
            binding.view.background = MaterialShapeDrawable(backgroundShapeModel).apply {
                fillColor = ColorStateList.valueOf(Color.BLACK)
            }
            val dialog = AlertDialog.Builder(this,R.style.BrutDialog)
                .setView(binding.root)
                .show()
            binding.tryNowBtn.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}