package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.booking.Model.Feedback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FeedbackForm extends AppCompatActivity {

    EditText FeedbackName, FeedbackNumber, FeedbackNote;
    Button SubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        FeedbackName = findViewById(R.id.FeedbackName);
        FeedbackNumber = findViewById(R.id.FeedbackNumber);
        FeedbackNote = findViewById(R.id.FeedbackNote);

        SubmitButton = findViewById(R.id.SubmitButton);

        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_feedback = database.getReference("Feedback");

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(FeedbackForm.this);
                mDialog.setMessage("Please Wait");
                mDialog.show();

                table_feedback.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        mDialog.dismiss();
                        Feedback feedback = new Feedback(FeedbackName.getText().toString(), FeedbackNote.getText().toString());
                        table_feedback.child(FeedbackNumber.getText().toString()).setValue(feedback);
                        Toast.makeText(FeedbackForm.this, "Feedback Sent Successfully!",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
