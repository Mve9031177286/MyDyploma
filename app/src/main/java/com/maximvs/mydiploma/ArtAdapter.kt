package com.maximvs.mydiploma

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maximvs.mydiploma.ApiConstants.BASE_URL_API
import com.maximvs.mydiploma.ApiConstants.URL_CONFIG
import com.maximvs.mydiploma.databinding.RecyclerviewStartItemBinding

//в параметр передаю слушатель, чтобы потом обрабатывать нажатия из класса Activity
class ArtAdapter(private val listener: Listener): RecyclerView.Adapter<ArtAdapter.ArtViewHolder>() {

    private var artList = mutableListOf<Data>()

    class ArtViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = RecyclerviewStartItemBinding.bind(item)


        fun bind(artist: Data, listener: Listener) = with(binding) {
            title.text = artist.title
            titleName.text = artist.artist_title
            artistDisplay.text = artist.artist_display
            dateDisplay.text = artist.date_display

            Glide
                .with(itemView.context) //передается контекст из айтемвью
                .load("$BASE_URL_API/${artist.image_id}$URL_CONFIG") //Указываем, что будем загружать
                .centerCrop() //Масштабируем с учетом пропорций и отрезаем все, что не влезло
                .placeholder(R.drawable.ic_round_loop_24)//Картинка, которая будет отображаться, пока картинка не загрузится
                .error(R.drawable.ic_round_mobiledata_off_24)//Картинка, которая будет показана в случае ошибки загрузки
                .into(poster) //Указываем, куда будем загружать

            poster.setOnClickListener {
                listener.onClick(artist)
            }
            moreRvStartItem.setOnClickListener {
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtViewHolder {
        return ArtViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_start_item, parent, false))
    }

    override fun onBindViewHolder(holder: ArtViewHolder, position: Int) {
        holder.bind(artList[position], listener)
    }

    override fun getItemCount(): Int {
        return artList.size
    }

    fun addData(artist: List<Data>){
        artList = artist.toMutableList()
        notifyDataSetChanged()
    }

    interface Listener {
        fun onClick (artist: Data)
    }
}

private fun ImageView.setImageResource(config: Config) {
}


