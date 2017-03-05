package jp.subroh0508.kancollereportpad.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.os.IBinder
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import jp.subroh0508.kancollereportpad.R
import jp.subroh0508.kancollereportpad.extensions.setOverlaySettings

/**
 * Created by subroh_0508 on 2016/12/31.
 */
class BoardService : Service() {
    val viewGroup: ViewGroup by lazy { LayoutInflater.from(this).inflate(R.layout.layout_board_service, null) as ViewGroup }
    val windowManager: WindowManager by lazy { applicationContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager }

    companion object {
        val DISPLAY_SIZE = "display_size"

        fun start(service: Service, displaySize: Point) {
            val intent = Intent(service, BoardService::class.java)
            intent.putExtra(DISPLAY_SIZE, displaySize)
            service.startService(intent)
        }

        fun stop(service: Service) {
            service.stopService(Intent(service, BoardService::class.java))
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        windowManager.addView(viewGroup, setOverlaySettings(intent?.getParcelableExtra(DISPLAY_SIZE), 10 to 10, 10 to 80))

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
        windowManager.removeView(viewGroup)
    }
}