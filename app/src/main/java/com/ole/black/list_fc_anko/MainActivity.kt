package com.ole.black.list_fc_anko

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.ole.black.list_fc_anko.Adapter.FcAdapter
import com.ole.black.list_fc_anko.Model.Item
import com.ole.black.list_fc_anko.UI.DetailActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(){
    var FcItems : MutableList<Item> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()

        verticalLayout {
            lparams(matchParent, matchParent)
            orientation = LinearLayout.VERTICAL

            recyclerView {
                lparams(matchParent, matchParent)
                layoutManager = LinearLayoutManager(context)
                adapter = FcAdapter(FcItems){
                    startActivity<DetailActivity>(DetailActivity.POSITIONEXTRA to it)
                    val toast = Toast.makeText(context, it.name, Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
        }
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.nama_klub)
        val image = resources.obtainTypedArray(R.array.gambar_klub)
        val detail = resources.getStringArray(R.array.detail_klub)

        FcItems.clear()

        for (i in name.indices){
            FcItems.add(Item(name[i], image.getResourceId(i,0), detail[i] ))
        }
        Log.e("info", FcItems.size.toString())

        image.recycle()

    }

}