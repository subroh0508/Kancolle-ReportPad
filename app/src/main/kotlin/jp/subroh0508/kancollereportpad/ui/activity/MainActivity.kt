package jp.subroh0508.kancollereportpad.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import jp.subroh0508.kancollereportpad.R
import jp.subroh0508.kancollereportpad.service.MainService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if (button.text.toString() == "start service") {
                MainService.start(this)
                button.text = "stop service"
            } else {
                MainService.stop(this)
                button.text = "start service"
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }
}
