package com.example.myfilms.app.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.myfilms.R
import com.example.myfilms.app.home.HomeViewModel
import com.example.myfilms.databinding.FragmentDialogMovieDetalisBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber


class MovieDetailsDialogFragment : DialogFragment() {

    /**
     * Associated viewModel
     */
    private val movieDetailsViewModel: HomeViewModel by sharedViewModel()

    /**
     * Binding of the view
     */
    lateinit var binding: FragmentDialogMovieDetalisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("rer")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_dialog_movie_detalis,
            container,
            false
        )
        binding.viewModel = movieDetailsViewModel

        return binding.root
    }

}

