package com.example.pertemuan7

import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager

class Camera(private val cameraManager : CameraManager)
{
    private val cameraId: String
    init {
        cameraId = setUpCameraId(manager = cameraManager)
    }
    fun setUpCameraId(manager: CameraManager): String {
        for (cameraId in manager.cameraIdList) {
            val characteristics = manager.getCameraCharacteristics(cameraId)
            // We don't use a front facing camera in this sample.
            val cameraDirection = characteristics.get(CameraCharacteristics.LENS_FACING)
            if (cameraDirection != null &&
                cameraDirection == CameraCharacteristics.LENS_FACING_FRONT) {
                continue
            }
            return cameraId
        }
        throw IllegalStateException("Could not set Camera Id")
    }
}