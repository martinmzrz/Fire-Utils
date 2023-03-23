package com.firefly.fireutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.firefly.logutils.logD
import com.firefly.viewutils.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pixels = this.dpsToPixels(24)

        val string = "24 dps are $pixels on this device"

        string.logD("DEMO")

        showToast(string)

        val constraintLayout = findViewById<ConstraintLayout>(R.id.main_constraint)

        ConstraintSet().apply {
            clone(constraintLayout)
        }.with(R.id.text_view)
            .clearAll()
            .connectEndToParentEnd()
            .connectBottomToParentBottom()
            .constraintSet
            .applyTo(constraintLayout)
    }
}