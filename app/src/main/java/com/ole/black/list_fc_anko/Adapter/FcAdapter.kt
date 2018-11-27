package com.ole.black.list_fc_anko.Adapter

import android.support.v7.appcompat.R
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ole.black.list_fc_anko.Model.Item
import com.ole.black.list_fc_anko.UI.ItemUI
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.notification_template_lines_media.*
import kotlinx.android.synthetic.main.notification_template_lines_media.view.*
import org.jetbrains.anko.AnkoContext

class FcAdapter(private val items: MutableList<Item>, private val listener: (Item)->Unit)
    : RecyclerView.Adapter<FcAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
        ViewHolder{
        return ViewHolder(ItemUI().createView(AnkoContext.create(parent.context,parent)))
    }


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var imageView: ImageView
        var textView: TextView

        init {
            imageView=itemView.findViewById(ItemUI.gambarId)
            textView=itemView.findViewById(ItemUI.namaId)
        }

        fun bindItem (list:Item,listener: (Item) -> Unit){
            textView.text=list.name
            Glide.with(itemView.context).load(list.image).into(imageView)
            itemView.setOnClickListener {
                listener(list)
            }
        }
    }
//    LayoutContainer{
//        fun bindItem(items: Item, listener: (Item) -> Unit) {
//            itemView.text = items.nama
//            items.image.let { Picasso.get().load(it).into(R.id.image) }
//            containerView.setOnClickListener { listener(items) }
//        }
//    }
}
