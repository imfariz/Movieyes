package com.dicoding.movieyes.ui.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movieyes.R
import com.dicoding.movieyes.data.source.local.entity.ShowEntity
import com.dicoding.movieyes.databinding.ItemsMovieBinding
import com.dicoding.movieyes.utils.MoviesCallback

class TvShowAdapter(private val callback: MoviesCallback) :
    PagedListAdapter<ShowEntity, TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsSeriesBinding =
            ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsSeriesBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val series = getItem(position)
        if (series != null) {
            holder.bind(series)
        }
    }

    inner class TvShowViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(series: ShowEntity) {
            with(binding) {
                tvItemTitle.text = series.title
                tvItemDate.text = series.release
                itemView.setOnClickListener { callback.move(series.showId, true) }
                Glide.with(itemView.context)
                    .load(series.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(rvMoviePoster)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ShowEntity>() {
            override fun areItemsTheSame(oldItem: ShowEntity, newItem: ShowEntity): Boolean {
                return oldItem.showId == newItem.showId
            }

            override fun areContentsTheSame(oldItem: ShowEntity, newItem: ShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}