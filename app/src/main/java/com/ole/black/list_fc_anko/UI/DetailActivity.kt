package com.ole.black.list_fc_anko.UI

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.ole.black.list_fc_anko.Model.Item
import org.jetbrains.anko.*


class DetailActivity : AppCompatActivity() {

    companion object {
        val keteranganID = 3
        val POSITIONEXTRA = "position_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        val list = intent.getParcelableExtra<Item>(POSITIONEXTRA)

        DetailActivityUI(list).setContentView(this)

    }

    internal class DetailActivityUI(var list: Item) : AnkoComponent<DetailActivity> {

        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui){
            var position = 0
            linearLayout {
                orientation = LinearLayout.VERTICAL
                lparams(matchParent, matchParent)

                imageView(){
                    Glide.with(this).load(list.image).into(this)
                    id = ItemUI.gambarId
                    padding = dip(10)

                    this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(dip(80), dip(80))

                textView{
                    id = ItemUI.namaId
                    text = list.name
                    textSize = sp(10).toFloat()
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(10)
                }

                textView{
                    id = keteranganID
                    text = list.detail
                    gravity = Gravity.CENTER_HORIZONTAL
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    padding = dip(10)
                }

            }
        }

    }
}

