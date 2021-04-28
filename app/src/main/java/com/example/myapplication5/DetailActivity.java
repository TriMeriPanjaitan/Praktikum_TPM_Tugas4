package com.example.myapplication5;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    public static String EXTRA_DATA = "EXTRA_DATA";
    private Drama drama;

    ImageView ivImage;
    TextView tvTitle, tvDetail, tvEpisode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tv_nama);
        tvDetail = findViewById(R.id.tv_detail);
        tvEpisode = findViewById(R.id.tv_episode);
        ivImage = findViewById(R.id.iv_images);

        drama = getIntent().getParcelableExtra(EXTRA_DATA);

        Glide.with(this)
                .load(drama.getsImage())
                .apply(new RequestOptions().override(160,240))
                .into(ivImage);
        tvTitle.setText(drama.getsName());
        tvDetail.setText(drama.getsDetail());
        tvEpisode.setText(drama.getsEpisode());


    }
}

