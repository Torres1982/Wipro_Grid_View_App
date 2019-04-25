package com.wipro.day4gridapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FootballerActivity extends Activity {
    int position = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.footballer_view);

        Button mainActivityButton = findViewById(R.id.button_main_grid);
        Button prevPictureButton = findViewById(R.id.button_previous_picture);
        Button nextPictureButton = findViewById(R.id.button_next_picture);
        final ImageView imageView = findViewById(R.id.footballer_image_view);
        Intent intent = getIntent();

        // Selected image id
        position = intent.getExtras().getInt("id");
        final FootballersAdapter footballersAdapter = new FootballersAdapter(getApplicationContext());
        imageView.setImageResource(footballersAdapter.arrayOfImages[position]);

        mainActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMainActivityIntent = new Intent(FootballerActivity.this, MainActivity.class);
                startActivity(goToMainActivityIntent);
            }
        });

        nextPictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                imageView.setImageResource(footballersAdapter.arrayOfImages[position]);

                if (position == 10) position = -1;
            }
        });

        prevPictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                imageView.setImageResource(footballersAdapter.arrayOfImages[position]);

                if (position == 0) position = 11;
            }
        });
    }
}
