package com.example.slamet.popularmoviesstage1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView nameOfMovie, plotSynopsis, userRating, releaseDate;
    ImageView imageView;
    String thumbnail, movieName,synopsis, rating, dateOfRelease;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        imageView = (ImageView) findViewById(R.id.thumbnail_image_header);
        nameOfMovie = (TextView) findViewById(R.id.title);
        plotSynopsis = (TextView) findViewById(R.id.plotsynopsis);
        userRating = (TextView) findViewById(R.id.userrating);
        releaseDate = (TextView) findViewById(R.id.releasedate);

        Intent intentThatStartedThisActivity = getIntent();
        if(intentThatStartedThisActivity.hasExtra("original_title")){

            thumbnail = getIntent().getExtras().getString("poster_path");
            movieName = getIntent().getExtras().getString("original_title");
            synopsis = getIntent().getExtras().getString("overview");
            rating = getIntent().getExtras().getString("vote_average");
            dateOfRelease = getIntent().getExtras().getString("release_date");

            Picasso.with(this)
                    .load(thumbnail)
                    .placeholder(R.drawable.loading)
                    .into(imageView);


            nameOfMovie.setText(movieName);
            plotSynopsis.setText(synopsis);
            userRating.setText(rating);
            releaseDate.setText(dateOfRelease);

        } else {
            Toast.makeText(this, "No API Data", Toast.LENGTH_SHORT).show();
        }
    }

}
