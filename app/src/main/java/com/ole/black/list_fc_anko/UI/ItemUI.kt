package com.ole.black.list_fc_anko.UI

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.ole.black.list_fc_anko.R
import kotlinx.android.synthetic.main.abc_activity_chooser_view.view.*
import org.jetbrains.anko.*

class ItemUI:AnkoComponent<ViewGroup> {
    companion object {
        val namaId = 1
        val gambarId = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>)= with(ui) {
        linearLayout{
            orientation=LinearLayout.HORIZONTAL
            lparams(matchParent, wrapContent)
            padding=dip(10)

            imageView{
                id= gambarId
                imageResource= R.drawable.img_acm
            }.lparams(dip(50),dip(50))

            textView {
                id= namaId
                text="AC Milan FC"
            }.lparams(wrapContent, wrapContent){
                margin=dip(10)
                gravity=Gravity.CENTER_VERTICAL
            }
        }
    }
}