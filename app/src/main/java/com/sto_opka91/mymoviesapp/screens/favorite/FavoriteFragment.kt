package com.sto_opka91.mymoviesapp.screens.favorite

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.sto_opka91.mymoviesapp.MAIN
import com.sto_opka91.mymoviesapp.R
import com.sto_opka91.mymoviesapp.databinding.FragmentFavoriteBinding
import com.sto_opka91.mymoviesapp.databinding.FragmentMainBinding
import com.sto_opka91.mymoviesapp.model.Film
import com.sto_opka91.mymoviesapp.screens.main.MainAdapter
import com.sto_opka91.mymoviesapp.screens.main.MainFragmentViewModel


class FavoriteFragment : Fragment() {
    private var mBinding: FragmentFavoriteBinding?= null
    private val binding get() = mBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy{
        FavoriteAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFavoriteBinding.inflate(layoutInflater, container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(FavoriteFragmentViewModel::class.java)
        recyclerView = binding.rvFavorite
        recyclerView.adapter = adapter
        viewModel.getAllMovies().observe(viewLifecycleOwner, {list ->
            adapter.setListFavorite(list.asReversed())
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding=null
    }
    companion object{
        fun clickMovie(model: Film){
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
            try {
                MAIN.navController.navigate(R.id.action_favoriteFragment_to_detailFragment  , bundle)
            } catch (e: Exception) {
                Log.e("myLog", "${e.message}")
            }
        }
    }
}