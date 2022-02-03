package com.dicoding.movieyes.ui.bookmarks.content.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movieyes.databinding.FragmentBookmarksMovieBinding
import com.dicoding.movieyes.ui.detail.DetailShowActivity
import com.dicoding.movieyes.utils.MoviesCallback
import com.dicoding.movieyes.viewmodel.ViewModelFactory

class BookmarksMovieFragment : Fragment(), MoviesCallback {

    private var fragmentBookmarksMovieBinding: FragmentBookmarksMovieBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding =
            FragmentBookmarksMovieBinding.inflate(layoutInflater, container, false)
        fragmentBookmarksMovieBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MoviesBookmarksViewModel::class.java]

            val movieAdapter = BookmarksMovieAdapter(this)
            fragmentBookmarksMovieBinding?.progressBar?.visibility = View.VISIBLE
            viewModel?.getMoviesBookmark()
                ?.observe(viewLifecycleOwner) { movie ->
                    if (movie.isNotEmpty()) {
                        fragmentBookmarksMovieBinding?.progressBar?.visibility =
                            View.GONE
                        fragmentBookmarksMovieBinding?.tvBmMovie?.visibility =
                            View.GONE
                        movieAdapter?.submitList(movie)
                    } else {
                        fragmentBookmarksMovieBinding?.progressBar?.visibility = View.GONE
                        fragmentBookmarksMovieBinding?.rvBookmarksMovie?.visibility = View.GONE
                        fragmentBookmarksMovieBinding?.tvBmMovie?.visibility = View.VISIBLE
                    }
                }

            with(fragmentBookmarksMovieBinding?.rvBookmarksMovie) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = movieAdapter
            }
        }
    }

    override fun onDestroyView() {
        fragmentBookmarksMovieBinding = null
        super.onDestroyView()
    }

    override fun move(id: Int, series: Boolean) {
        val intent = Intent(activity, DetailShowActivity::class.java)
        intent.putExtra(DetailShowActivity.EXTRA_SHOW.toString(), id)
        intent.putExtra(DetailShowActivity.EXTRA_STATUS.toString(), series)
        startActivity(intent)
    }
}