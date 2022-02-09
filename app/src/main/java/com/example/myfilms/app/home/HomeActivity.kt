package com.example.myfilms.app.home

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfilms.R
import com.example.myfilms.app.adapter.MovieAdapter
import com.example.myfilms.databinding.ActivityHomeBinding
import com.example.myfilms.model.MoviesApiResponseEntity
import com.example.myfilms.services.MovieApiClient
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URLEncoder


class HomeActivity : AppCompatActivity() {

    /**
     * Injected ViewModel
     */
    private val homeActivityViewModel: HomeViewModel by viewModel()

    private val movieApiClient: MovieApiClient by inject()

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set databinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.viewModel = homeActivityViewModel

        val window: Window = this@HomeActivity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this@HomeActivity, R.color.custom_orange)
    }

    override fun onResume() {
        super.onResume()

        binding.moviesSearch.doAfterTextChanged {
            if(binding.moviesSearch.text.isNotEmpty()){
                binding.searchLbl.visibility = View.INVISIBLE
                this.searchMovies(it.toString())
            }else{
                resetResultUI()
            }
        }
    }

    fun searchMovies(searchedQuery: String){
        movieApiClient.getApiService().serachMovie(query = URLEncoder.encode(searchedQuery, "utf-8"))
            .enqueue(object : Callback<MoviesApiResponseEntity> {
                override fun onFailure(call: Call<MoviesApiResponseEntity>, t: Throwable) {
                    // Error logging in
                    Toast.makeText(
                        this@HomeActivity,
                        t.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onResponse(call: Call<MoviesApiResponseEntity>, response: Response<MoviesApiResponseEntity>) {
                    val moviesResponse = response.body()
                    if (moviesResponse?.movies != null) {
                        setupResultUI()
                        with(binding.recyclerView) {
                            layoutManager = LinearLayoutManager(this@HomeActivity)
                            adapter = MovieAdapter(moviesResponse.movies, context)
                        }
                    } else {
                        Toast.makeText(
                            this@HomeActivity,
                            R.string.no_data_displayed,
                            Toast.LENGTH_SHORT
                        ).show()
                        resetResultUI()
                    }
                }
            })
    }

    /*
     * Set UI for search and display data
     */
    fun setupResultUI(){
        binding.relativeMain.setBackgroundColor(Color.WHITE)
        binding.noResultImage.visibility = View.INVISIBLE
        binding.noResultLbl.visibility = View.INVISIBLE
        binding.recyclerView.visibility = View.VISIBLE
    }

    /*
     * Reset UI when there is no data to display
     */
    fun resetResultUI(){
        binding.searchLbl.visibility = View.VISIBLE
        binding.relativeMain.setBackgroundColor(Color.BLACK)
        binding.noResultImage.visibility = View.VISIBLE
        binding.noResultLbl.visibility = View.VISIBLE
        binding.recyclerView.adapter = MovieAdapter(emptyList(), this@HomeActivity)
        binding.recyclerView.visibility = View.INVISIBLE
    }

}