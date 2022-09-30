package com.maximvs.mydiploma

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

class MyItemAnimator(private val context: Context) : DefaultItemAnimator () { // в конструкторе есть контекст, можно считать анимации
    val animAdd = AnimationUtils.loadAnimation(context, R.anim.layout_animation)

    override fun onAddStarting(item: RecyclerView.ViewHolder?) {
        item?.itemView?.startAnimation(animAdd)
    }

    override fun getAddDuration(): Long {
        return animAdd.duration
    }
}