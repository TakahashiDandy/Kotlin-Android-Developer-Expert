package com.alexandrite.hellokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class DetailActivity : AppCompatActivity() {

    lateinit var nameTextView: TextView
    lateinit var imageDetail : ImageView
    lateinit var detailTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        verticalLayout {

            padding = dip(16)

            imageDetail = imageView().lparams(width=dip(100),height = dip(100)){
                gravity = Gravity.CENTER_HORIZONTAL
            }
            nameTextView = textView{
                textSize = sp(15).toFloat()
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }.lparams(width= matchParent){
                gravity = Gravity.CENTER_HORIZONTAL
                bottomMargin = dip(10)
            }
            detailTextView = textView()
        }

        //mengambil data dari strings array
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.club_desc)

        //membaca intent yang dikirimkan
        val intent = intent
        val id = intent.getIntExtra("id",0)

        //loaddata dari array berdasarkan index inputan
        nameTextView.text = name.get(id)
        imageDetail.setImageResource(image.getResourceId(id,0))
        detailTextView.text = desc.get(id)


    }
}
