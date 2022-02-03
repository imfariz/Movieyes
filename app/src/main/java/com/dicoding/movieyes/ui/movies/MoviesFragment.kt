package com.dicoding.movieyes.ui.movies

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movieyes.R
import com.dicoding.movieyes.data.source.local.entity.ShowEntity
import com.dicoding.movieyes.databinding.FragmentMoviesBinding
import com.dicoding.movieyes.ui.detail.DetailShowActivity
import com.dicoding.movieyes.utils.MoviesCallback
import com.dicoding.movieyes.utils.SortUtil
import com.dicoding.movieyes.viewmodel.ViewModelFactory
import com.dicoding.movieyes.vo.Resource
import com.dicoding.movieyes.vo.Status

class MoviesFragment : Fragment(), MoviesCallback {

    private var fragmentMovieBinding: FragmentMoviesBinding? = null
    private var viewModel: MovieViewModel? = null
    private var movieAdapter: MoviesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        fragmentMovieBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            movieAdapter = MoviesAdapter(this)

            viewModel?.getMovie(SortUtil.DESCENDING)?.observe(viewLifecycleOwner) {
                if (it != null) {
                    val movies = it
                    when (movies.status) {
                        Status.LOADING -> fragmentMovieBinding?.progressBar?.visibility =
                            View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentMovieBinding?.progressBar?.visibility = View.GONE
                            movieAdapter?.submitList(it.data)
                        }
                        Status.ERROR -> {
                            fragmentMovieBinding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

            with(fragmentMovieBinding?.rvMovie) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = movieAdapter
            }
        }
    }

    private val moviesObserver = Observer<Resource<PagedList<ShowEntity>>> { movies ->
        if (movies != null) {
            movieAdapter?.submitList(movies.data)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var sort = ""
        when (item.itemId) {
            R.id.action_asc -> sort = SortUtil.ASCENDING
            R.id.action_desc -> sort = SortUtil.DESCENDING
            R.id.action_random -> sort = SortUtil.RANDOM
        }
        viewModel?.getMovie(sort)?.observe(this, moviesObserver)

        item.isChecked = true
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        fragmentMovieBinding = null
        super.onDestroyView()
    }

    override fun move(id: Int, series: Boolean) {
        val intent = Intent(activity, DetailShowActivity::class.java)
        intent.putExtra(DetailShowActivity.EXTRA_SHOW.toString(), id)
        intent.putExtra(DetailShowActivity.EXTRA_STATUS.toString(), series)
        startActivity(intent)
    }
}