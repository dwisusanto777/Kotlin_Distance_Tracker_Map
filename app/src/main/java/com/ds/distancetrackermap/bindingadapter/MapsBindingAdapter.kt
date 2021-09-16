package com.ds.distancetrackermap.bindingadapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.BindingAdapter

class MapsBindingAdapter {

    companion object{
        @BindingAdapter("observeTracking")
        @JvmStatic
        fun observerTracking(view: View, started:Boolean){
            if(started==true && view is Button){
                view.visibility = View.VISIBLE
            }else if(started==true && view is TextView){
                view.visibility = View.INVISIBLE
            }
        }
    }

}