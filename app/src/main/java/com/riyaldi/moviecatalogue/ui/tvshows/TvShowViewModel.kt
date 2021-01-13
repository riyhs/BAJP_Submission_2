package com.riyaldi.moviecatalogue.ui.tvshows

import androidx.lifecycle.ViewModel
import com.riyaldi.moviecatalogue.utils.DataDummy

class TvShowViewModel: ViewModel() {
    fun getTvShows() = DataDummy.getTvShows()
}