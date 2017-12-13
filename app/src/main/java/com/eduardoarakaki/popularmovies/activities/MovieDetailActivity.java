package com.eduardoarakaki.popularmovies.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.eduardoarakaki.popularmovies.Movie;
import com.eduardoarakaki.popularmovies.R;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity.hasExtra("movieDetail")) {
            Movie.MovieDetail movieDetail = intentThatStartedThisActivity.getParcelableExtra("movieDetail");
            Log.d("TESTE", movieDetail.toString());
        }
    }
}
