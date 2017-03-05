package jp.subroh0508.kancollereportpad.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import android.view.WindowManager
import jp.subroh0508.kancollereportpad.R
import jp.subroh0508.kancollereportpad.extensions.setOverlaySettings
import jp.subroh0508.kancollereportpad.extensions.startService


/**
 * Created by subroh_0508 on 2016/12/31.
 */
class MainService : Service() {
    val button: ViewGroup by lazy { LayoutInflater.from(this).inflate(R.layout.button_expand, null) as ViewGroup }
    val windowManager: WindowManager by lazy { applicationContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager }
    var layoutParams: WindowManager.LayoutParams? = null
    lateinit var displaySize: Point
    var isExpand = false
    var isLongClick = false

    companion object {
        fun start(activity: AppCompatActivity) {
            activity.startService(MainService::class)
        }

        fun stop(activity: AppCompatActivity) {
            activity.stopService(Intent(activity, MainService::class.java))
        }
    }

    override fun onCreate() {
        super.onCreate()
        displaySize = Point().also { windowManager.defaultDisplay.getSize(it) }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        with (button) {
            setExpand()
            setMovealbleButton()
        }
        layoutParams = setOverlaySettings()

        windowManager.addView(button, layoutParams)

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun ViewGroup.setExpand() {
        setOnClickListener {
            if (isLongClick) return@setOnClickListener

            if (isExpand) {
                isExpand = false
                BoardService.stop(this@MainService)
            } else {
                isExpand = true
                BoardService.start(this@MainService, displaySize)
            }
        }
    }
    
    private fun ViewGroup.setMovealbleButton() {
        setOnLongClickListener { v ->
            isLongClick = true
            v.setBackgroundResource(R.color.cyan)
            false
        }

        setOnTouchListener { v, event ->
            if (!isLongClick) return@setOnTouchListener false

            displaySize = displaySize.also { windowManager.defaultDisplay.getSize(it) }

            val x = event.rawX.toInt()
            val y = event.rawY.toInt()

            when (event.action) {
                MotionEvent.ACTION_MOVE -> {
                    this@MainService.layoutParams?.let { param ->
                        param.x = x - (displaySize.x / 2)
                        param.y = y - (displaySize.y / 2)
                        windowManager.updateViewLayout(button, param)
                    }
                }
                MotionEvent.ACTION_UP -> {
                    v.setBackgroundResource(R.color.transparent)
                    isLongClick = false
                }
            }

            false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        windowManager.removeView(button)
    }
}