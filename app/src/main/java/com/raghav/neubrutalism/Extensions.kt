package com.raghav.neubrutalism

import android.content.res.Resources

object Extensions {
    val Float.toPx get() = this * Resources.getSystem().displayMetrics.density

    val Float.toDp get() = this / Resources.getSystem().displayMetrics.density



    val Int.toPx get() = (this * Resources.getSystem().displayMetrics.density).toInt()

    val Int.toDp get() = (this / Resources.getSystem().displayMetrics.density).toInt()
}