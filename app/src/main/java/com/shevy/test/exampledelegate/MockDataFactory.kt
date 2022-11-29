package com.shevy.test.exampledelegate

import com.shevy.test.R
import com.shevy.test.exampledelegate.model.*
import java.util.*
import java.util.ArrayList

object MockDataFactory {
    private const val SIZE = 20

    fun prepareData(): List<Any> {
        val objects = ArrayList<Any>(SIZE)
        val random = Random()
        for (i in 0 until SIZE) {
            var item: Any
            val type = random.nextInt(3)
            item = if (type == 0) {
                TextItem("Title $i", "Description $i")
            } else if (type == 1) {
                ImageItem("Title $i", R.mipmap.ic_launcher_round)
            } else {
                CheckItem("You still love this lib", true)
            }
            objects.add(item)
        }
        return objects
    }
}