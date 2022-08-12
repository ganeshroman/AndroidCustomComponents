package com.example.customcomponents

import android.os.Bundle
import com.example.customcomponents.ui.base.BaseActivity

/**
 * @param @nullable  Temp    Explanation
 * @author Ganesh
 * <p>
 * This will be Main Activity.
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}