package com.example.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_hero.view.*

// membuat customAdapter
class HeroAdapter internal constructor(private val context: Context) : BaseAdapter(){

    // set data yang dikirim dari activity dan digunakan sebagai sumber data untuk dimasukkan ke dalam ViewHolder.
    internal var heroes = arrayListOf<Hero>()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    override fun getItem(i: Int): Any = heroes[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getCount(): Int =  heroes.size

    private inner class ViewHolder constructor(view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription : TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)

        internal fun bind (hero: Hero) {
            txtName.text = hero.name
            txtDescription.text = hero.description
            imgPhoto.setImageResource(hero.photo)
        }
    }

}