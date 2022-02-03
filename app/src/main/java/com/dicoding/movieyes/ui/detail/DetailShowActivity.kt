package com.dicoding.movieyes.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movieyes.R
import com.dicoding.movieyes.data.source.local.entity.ShowEntity
import com.dicoding.movieyes.databinding.ActivityDetailShowBinding
import com.dicoding.movieyes.databinding.ContentDetailShowBinding
import com.dicoding.movieyes.viewmodel.ViewModelFactory
import com.dicoding.movieyes.vo.Status

class DetailShowActivity : AppCompatActivity() {

    private var activityDetailShowBinding: ActivityDetailShowBinding? = null
    private var detailContentBinding: ContentDetailShowBinding? = null

    private var viewModel: DetailShowViewModel? = null
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailShowBinding.inflate(layoutInflater)
        activityDetailShowBinding = binding
        detailContentBinding = activityDetailShowBinding?.detailContent

        setContentView(activityDetailShowBinding?.root)

        setSupportActionBar(activityDetailShowBinding?.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val showId = extras.getInt(EXTRA_SHOW.toString())
            val status = extras.getBoolean(EXTRA_STATUS.toString())
            viewModel?.setSelectedShow(showId)
            if (!status) {
                viewModel?.getMovie?.observe(this) {
                    if (it != null) {
                        when (it.status) {
                            Status.LOADING -> detailContentBinding?.progressBar?.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> {
                                detailContentBinding?.progressBar?.visibility = View.GONE
                                showsDetail(it.data!!)
                            }
                            Status.ERROR -> {
                                detailContentBinding?.progressBar?.visibility = View.GONE
                                Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            } else {
                viewModel?.getSerie?.observe(this) {
                    if (it != null) {
                        when (it.status) {
                            Status.LOADING -> detailContentBinding?.progressBar?.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> {
                                detailContentBinding?.progressBar?.visibility = View.GONE
                                showsDetail(it.data!!)
                            }
                            Status.ERROR -> {
                                detailContentBinding?.progressBar?.visibility = View.GONE
                                Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        val extras = intent.extras
        this.menu = menu
        if (extras != null) {
            val status = extras.getBoolean(EXTRA_STATUS.toString())
            if (!status) {
                viewModel?.getMovie?.observe(this) { movie ->
                    if (movie != null) {
                        when (movie.status) {
                            Status.LOADING -> detailContentBinding?.progressBar?.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> if (movie.data != null) {
                                detailContentBinding?.progressBar?.visibility = View.GONE
                                val state = movie.data.bookmarked
                                setBookmarkState(state)
                            }
                            Status.ERROR -> {
                                detailContentBinding?.progressBar?.visibility = View.GONE
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }
            } else {
                viewModel?.getSerie?.observe(this) { serie ->
                    if (serie != null) {
                        when (serie.status) {
                            Status.LOADING -> detailContentBinding?.progressBar?.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> if (serie.data != null) {
                                detailContentBinding?.progressBar?.visibility = View.GONE
                                val state = serie.data.bookmarked
                                setBookmarkState(state)
                            }
                            Status.ERROR -> {
                                detailContentBinding?.progressBar?.visibility = View.GONE
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }
            }
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_bookmark) {
            val extras = intent.extras
            if (extras != null) {
                val status = extras.getBoolean(EXTRA_STATUS.toString())
                if (!status) {
                    viewModel?.setMovieBookmark()
                } else {
                    viewModel?.setSerieBookmark()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showsDetail(showEntity: ShowEntity) {
        detailContentBinding?.showTitle?.text = showEntity.title
        detailContentBinding?.score?.text = showEntity.score.toString()
        detailContentBinding?.release?.text = showEntity.release

        if (showEntity.overview != "") {
            detailContentBinding?.overview?.text = showEntity.overview
        } else {
            detailContentBinding?.overview?.text = " - "
        }

        Glide.with(this)
            .load(showEntity.imagePath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding!!.showPoster)
    }

    private fun setBookmarkState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_bookmark)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmarked_white)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark_white)
        }
    }

    companion object {
        var EXTRA_SHOW = 1234
        var EXTRA_STATUS = false
    }
}