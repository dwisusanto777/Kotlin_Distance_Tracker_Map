package com.ds.distancetrackermap.ui.maps

import android.graphics.Camera
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.SphericalUtil
import java.text.DecimalFormat

object MapUtil {

    fun setCameraPosition(location:LatLng): CameraPosition{
        return  CameraPosition.Builder()
            .target(location)
            .zoom(18f)
            .build()
    }

    fun calculatedElapsedTime(startTime:Long, stopTime:Long): String{
        val elapsedTime = stopTime - startTime

        val second = (elapsedTime/1000).toInt()%60
        val minute = (elapsedTime/(1000*60)).toInt()%60
        val hours = (elapsedTime/(1000*60*60)).toInt()%24

        return "$hours:$minute:$second"
    }

    fun calculateTheDistance(locationList: MutableList<LatLng>): String{
        if(locationList.size>1){
            val meters = SphericalUtil.computeDistanceBetween(locationList.first(), locationList.last())
            val kilometer = meters/1000
            return DecimalFormat("#.##").format(kilometer)
        }
        return  "0.00"
    }

}