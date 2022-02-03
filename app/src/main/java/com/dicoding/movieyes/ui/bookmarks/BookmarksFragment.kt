package com.dicoding.movieyes.ui.bookmarks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dicoding.movieyes.databinding.FragmentBookmarksBinding

class BookmarksFragment : Fragment() {
    private var fragmentBookmarksBinding: FragmentBookmarksBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentBookmarksBinding.inflate(inflater, container, false)
        fragmentBookmarksBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        val adapter = BookmarksPagerAdapter(childFragmentManager, requireActivity())
        fragmentBookmarksBinding?.viewPager?.adapter = adapter
        fragmentBookmarksBinding?.tabs?.setupWithViewPager(fragmentBookmarksBinding?.viewPager)
    }

    override fun onDestroyView() {
        fragmentBookmarksBinding = null
        super.onDestroyView()
    }
}