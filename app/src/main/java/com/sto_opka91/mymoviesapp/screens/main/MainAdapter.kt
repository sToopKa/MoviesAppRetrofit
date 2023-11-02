package com.sto_opka91.mymoviesapp.screens.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sto_opka91.mymoviesapp.MAIN
import com.sto_opka91.mymoviesapp.R
import com.sto_opka91.mymoviesapp.databinding.ItemLayoutBinding
import com.sto_opka91.mymoviesapp.model.Film

class MainAdapter: RecyclerView.Adapter<MainAdapter.MyViewHolder>() {
    private var listMovies = emptyList<Film>()
    lateinit var mBinding: ItemLayoutBinding
    class MyViewHolder(view : View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        mBinding = ItemLayoutBinding.inflate(inflater,parent,false)
        return MyViewHolder(mBinding.root)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.apply {
        mBinding.tvTitleItem.text = listMovies[position].nameRu
        mBinding.tvDateItem.text = listMovies[position].year
            Glide.with(MAIN)
                .load(listMovies[position].posterUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(mBinding.ivItem)
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Film>)
    {
        listMovies = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MyViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            MainFragment.clickMovie(listMovies[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MyViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }
}