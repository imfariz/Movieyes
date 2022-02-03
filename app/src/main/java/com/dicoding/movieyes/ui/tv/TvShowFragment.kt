package com.dicoding.movieyes.ui.tv

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
import com.dicoding.movieyes.databinding.FragmentTvShowBinding
import com.dicoding.movieyes.ui.detail.DetailShowActivity
import com.dicoding.movieyes.utils.MoviesCallback
import com.dicoding.movieyes.utils.SortUtil
import com.dicoding.movieyes.viewmodel.ViewModelFactory
import com.dicoding.movieyes.vo.Resource
import com.dicoding.movieyes.vo.Status

class TvShowFragment : Fragment(), MoviesCallback {

    private var viewModel: TvShowViewModel? = null
    private var seriesAdapter: TvShowAdapter? = null
    private var fragmentTvShowBinding: FragmentTvShowBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTvShowBinding.inflate(inflater, container, false)
        fragmentTvShowBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            seriesAdapter = TvShowAdapter(this)

            viewModel?.getSeries(SortUtil.DESCENDING)?.observe(viewLifecycleOwner) {
                if (it != null) {
                    val series = it
                    when (series.status) {
                        Status.LOADING -> fragmentTvShowBinding?.progressBar?.visibility =
                            View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentTvShowBinding?.progressBar?.visibility = View.GONE
                            seriesAdapter?.submitList(it.data)
                        }
                        Status.ERROR -> {
                            fragmentTvShowBinding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

            with(fragmentTvShowBinding?.rvSeries) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = seriesAdapter
            }
        }
    }

    private val seriesObserver = Observer<Resource<PagedList<ShowEntity>>> { series ->
        if (series != null) {
            seriesAdapter?.submitList(series.data)
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
        viewModel?.getSeries(sort)?.observe(this, seriesObserver)

        item.isChecked = true
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        fragmentTvShowBinding = null
        super.onDestroyView()
    }

    override fun move(id: Int, series: Boolean) {
        val intent = Intent(activity, DetailShowActivity::class.java)
        intent.putExtra(DetailShowActivity.EXTRA_SHOW.toString(), id)
        intent.putExtra(DetailShowActivity.EXTRA_STATUS.toString(), series)
        startActivity(intent)
    }
}