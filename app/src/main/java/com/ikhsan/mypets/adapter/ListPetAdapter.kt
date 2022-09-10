package com.ikhsan.mypets.adapter

import android.view.*
import android.widget.*
import com.ikhsan.mypets.dataModel.Pet
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ikhsan.mypets.R

class ListPetAdapter(private val listPet: ArrayList<Pet>) : RecyclerView.Adapter<ListPetAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_pet_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_pet_list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val pet = listPet[position]
        Glide.with(holder.itemView.context)
            .load(pet.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = pet.name
        holder.tvDetail.text = pet.description
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listPet[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Pet)
    }

    override fun getItemCount(): Int {
        return listPet.size
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
}