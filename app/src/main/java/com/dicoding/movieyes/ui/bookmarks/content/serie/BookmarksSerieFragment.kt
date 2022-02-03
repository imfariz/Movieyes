package com.dicoding.movieyes.ui.bookmarks.content.serie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movieyes.databinding.FragmentBookmarksSerieBinding
import com.dicoding.movieyes.ui.detail.DetailShowActivity
import com.dicoding.movieyes.utils.MoviesCallback
import com.dicoding.movieyes.viewmodel.ViewModelFactory

class BookmarksSerieFragment : Fragment(), MoviesCallback {

    private var fragmentBookmarksSerieBinding: FragmentBookmarksSerieBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding =
            FragmentBookmarksSerieBinding.inflate(layoutInflater, container, false)
        fragmentBookmarksSerieBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowBookmarksViewModel::class.java]

            val serieAdapter = BookmarksSerieAdapter(this)
            fragmentBookmarksSerieBinding?.progressBar?.visibility = View.VISIBLE
            viewModel?.getTvShowBookmark()
                ?.observe(viewLifecycleOwner) { series ->
                    if (series.isNotEmpty()) {
                        fragmentBookmarksSerieBinding?.progressBar?.visibility = View.GONE
                        fragmentBookmarksSerieBinding?.tvBmSerie?.visibility = View.GONE
                        serieAdapter?.submitList(series)
                    } else {
                        fragmentBookmarksSerieBinding?.rvBookmarksSerie?.visibility = View.GONE
                        fragmentBookmarksSerieBinding?.progressBar?.visibility = View.GONE
                        fragmentBookmarksSerieBinding?.tvBmSerie?.visibility = View.VISIBLE
                    }
                }

            with(fragmentBookmarksSerieBinding?.rvBookmarksSerie) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = serieAdapter
            }
        }
    }

    override fun onDestroyView() {
        fragmentBookmarksSerieBinding = null
        super.onDestroyView()
    }

    override fun move(id: Int, series: Boolean) {
        val intent = Intent(activity, DetailShowActivity::class.java)
        intent.putExtra(DetailShowActivity.EXTRA_SHOW.toString(), id)
        intent.putExtra(DetailShowActivity.EXTRA_STATUS.toString(), series)
        startActivity(intent)
    }
}