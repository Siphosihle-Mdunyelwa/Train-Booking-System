package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private CardView fareCard, bookingCard, profileCard, feedbackCard, viewProfileCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // defines Cards
        fareCard = (CardView) findViewById(R.id.fare_card);
        bookingCard = (CardView) findViewById(R.id.booking_card);
        profileCard = (CardView) findViewById(R.id.profile_card);
        feedbackCard = (CardView) findViewById(R.id.feedback_card);
        viewProfileCard = (CardView) findViewById(R.id.profileview_card);


        // Add Click listener to cards
        fareCard.setOnClickListener(this);
        bookingCard.setOnClickListener(this);
        profileCard.setOnClickListener(this);
        feedbackCard.setOnClickListener(this);
        viewProfileCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()) {
            case R.id.fare_card : i = new Intent(this, Fares.class); startActivity(i); break;
            case R.id.booking_card : i = new Intent(this, Book.class); startActivity(i); break;
            case R.id.profile_card : i = new Intent(this, Profile.class); startActivity(i); break;
            case R.id.feedback_card : i = new Intent(this, FeedbackForm.class); startActivity(i); break;
            case R.id.profileview_card : i = new Intent(this, ViewProfile.class); startActivity(i); break;
            default:break;
        }

    }
}
