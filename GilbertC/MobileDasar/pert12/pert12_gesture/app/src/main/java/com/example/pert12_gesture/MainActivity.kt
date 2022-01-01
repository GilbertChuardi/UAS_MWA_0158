package com.example.pert12_gesture

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.app.ShareCompat
import androidx.core.view.GestureDetectorCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener
{
    lateinit var mDetector: GestureDetectorCompat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDetector = GestureDetectorCompat(this,this)
        mDetector.setOnDoubleTapListener(this)
    }
    fun myToast(text: String, timw: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, text, timw).show()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        mDetector.onTouchEvent(event)
        return true
    }

    override fun onDown(p0: MotionEvent?): Boolean {
        //Digunakan ketika kita melakukan tap down
        myToast("On Down")
        return true
    }

    override fun onShowPress(p0: MotionEvent?) {
        //Digunakan ketika kita down dan belum melakukan move atau up
    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        //Digunakan ketika menerima event up
        return false
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        //digunakan untuk handel scrolling,p2 dan p3 distance
        myToast("$p1 , $p2 distanxe x =$p2 diistance y = $p3")
        return true
    }

    override fun onLongPress(p0: MotionEvent?) {
        //digunakan untuk handel long press
        myToast("Long Press")
    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        //digunakan untuk handel scrolling,p2 dan p3 velocity
        return false
    }

    override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
        //konfirmasi single tap dilakukan
        return false
    }

    override fun onDoubleTap(p0: MotionEvent?): Boolean {
        //konfirmasi double tap dilakukan
        return false
    }

    override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {
        ////Handle double tap dilakukan
        myToast("Double Tap")
        return true
    }
}

