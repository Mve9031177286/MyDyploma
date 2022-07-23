package com.maximvs.mydiploma

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maximvs.mydiploma.data.entity.Art
import com.maximvs.mydiploma.databinding.ActivityMainBinding
import com.maximvs.mydiploma.databinding.RecyclerviewStartItemBinding

//в параметр передаю слушатель, чтобы потом обрабатывать нажатия из класса Activity
class ArtAdapter: RecyclerView.Adapter<ArtAdapter.ArtViewHolder>() {

    private val artList = mutableListOf<UsersData>()

    class ArtViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = RecyclerviewStartItemBinding.bind(item)
        fun bind(usersData: UsersData) = with(binding) {
            title.text = usersData.`data`.toString()
            titleName.text = usersData.info.toString()
            poster.setImageResource(usersData.config)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtViewHolder {
        return ArtViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_start_item, parent, false))
    }

    override fun onBindViewHolder(holder: ArtViewHolder, position: Int) {
        holder.bind(artList[position])
    }

    override fun getItemCount(): Int {
        return artList.size
    }

    fun addData(usersData: UsersData){
        artList.add(usersData)
        notifyDataSetChanged()
    }
}

private fun ImageView.setImageResource(config: Config) {

}


