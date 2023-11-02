package com.sto_opka91.mymoviesapp.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sto_opka91.mymoviesapp.MAIN
import com.sto_opka91.mymoviesapp.R
import com.sto_opka91.mymoviesapp.databinding.FragmentDetailBinding
import com.sto_opka91.mymoviesapp.databinding.FragmentFavoriteBinding
import com.sto_opka91.mymoviesapp.model.Film
import com.sto_opka91.mymoviesapp.screens.favorite.FavoriteFragmentViewModel

class DetailFragment : Fragment() {
    private var mBinding: FragmentDetailBinding?= null
    private val binding get() = mBinding!!
    lateinit var currentMovie: Film
    private var isFavorite = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailBinding.inflate(layoutInflater, container,false)
        currentMovie = arguments?.getSerializable("movie") as Film
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init() {
        val viewModel = ViewModelProvider(this).get(DeatailViewModel::class.java)
        Glide.with(MAIN)
            .load(currentMovie.posterUrl)
            .fitCenter()
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.imgDetail)
        binding.apply {
            tvData.text = currentMovie.year
            tvDescription.text = currentMovie.rating
            tvTitle.text = currentMovie.nameRu
            imgDetailFavorite.setOnClickListener {
                if(!isFavorite){
                    viewModel.insertToTable(currentMovie){}
                    imgDetailFavorite.setImageResource(R.drawable.ic_favorite)
                    isFavorite = true
                }else{
                    viewModel.deleteFromTable(currentMovie){}
                    imgDetailFavorite.setImageResource(R.drawable.ic_non_favorite)
                    isFavorite = false
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding=null
    }
}