package com.levylin.dividerlinearlayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val count = 10
        val height = 100
        for (i in 0..count) {
            val textView = TextView(this)
            textView.text = "第${i}项"
            textView.gravity = Gravity.CENTER
            val lp = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height)
            test_dll.addView(textView, lp)
        }

        random_gone_btn.setOnClickListener {
            val list = getRandomArray(count)
            for (i in 0 until test_dll.childCount) {
                test_dll.getChildAt(i).visibility = View.VISIBLE
            }
            list.forEach {
                test_dll.getChildAt(it).visibility = View.GONE
            }
        }
    }

    private fun getRandomArray(count: Int): ArrayList<Int> {
        val list = LinkedList<Int>()
        for (i in 0..count) {
            list.add(i)
        }
        val randomCount = (Math.random() * count).toInt()
        val result = arrayListOf<Int>()
        for (i in 0 until randomCount) {
            var p = (Math.random() * (count - i + 1)).toInt()
            if (p > count - 1) {
                p = count - 1
            }
            result.add(list.removeAt(p))
        }
        return result
    }
}
