package com.example.ratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RatingBar ratingBar;
    TextView text_gr, text_rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingBar = findViewById(R.id.edtRating);
        text_gr = findViewById(R.id.edtText_gr);
        text_rating = findViewById(R.id.edtRatingText);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                //String r=text_rating.getText().toString().trim();
                float rate=ratingBar.getRating();
                if (rating > 3) {
                    String good=getString(R.string.Bad);
                    text_rating.setText(good+ "  " + rate);
                } else if (rating == 3) {
                    String average=getString(R.string.Average);
                    text_rating.setText(average + "  " + rate);
                } else if (rating < 3) {
                    String bad=getString(R.string.Bad);
                    text_rating.setText(bad + "  " + rate);
                }
                Toast.makeText(MainActivity.this, "" + rating, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
