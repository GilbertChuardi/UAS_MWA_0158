package com.example.uts

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSubmitButton(view: View) {
        // pakai extra
        var pesanName = inpName.text.toString()
        var pesanClass = inpClass.text.toString()
        var pesanAge = inpAge.text.toString()

        var intentReplay = Intent(this, ReplayActivity::class.java)

        intentReplay.putExtra(EXTRA_MESSAGENAME, pesanName)
        intentReplay.putExtra(EXTRA_MESSAGECLASS, pesanClass)
        intentReplay.putExtra(EXTRA_NUMBERAGE, pesanAge)

        startActivity(intentReplay)
    }

    fun onCameraButton(view: View) {
        cameraPermission()
        var TakePic = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if(TakePic.resolveActivity(packageManager) != null){
            startActivityForResult(TakePic, 112)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 112 && resultCode == Activity.RESULT_OK && data != null) {
            var tumbnail = data.extras
            imageView.setImageBitmap(tumbnail?.get("data") as Bitmap)
        }
        
    }

    private fun cameraPermission() {
        var permissions = arrayOf(Manifest.permission.CAMERA)
        var needPermission : ArrayList<String> = ArrayList()
        for(i in permissions){
            if(ContextCompat.checkSelfPermission(this@MainActivity, i) != PackageManager.PERMISSION_GRANTED){
                needPermission.add(i)
            }
        }
        if(!needPermission.isEmpty()){
            ActivityCompat.requestPermissions(this,
                    needPermission.toArray(arrayOfNulls(needPermission.size)),
                    123)
        }
    }


}