package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booking.Model.BookForm;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Book extends AppCompatActivity {

    EditText editText, editText2, editText3, editText4;

    RadioGroup ClassType;

    RadioButton ClassOption;

    String ClassT;

    RadioGroup TicketType;

    RadioButton TicketOption;

    String Ticket;

    Button CheckoutBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);



        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Book.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Departure));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        Spinner mySpinner1 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(Book.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Destination));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter1);

        ClassType = findViewById(R.id.ClassType);

        ClassType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ClassOption = ClassType.findViewById(i);

                switch (i){
                    case R.id.Metro:
                        ClassT = ClassOption.getText().toString();
                        break;
                    case R.id.MetroPlus:
                        ClassT = ClassOption.getText().toString();
                        break;

                        default:
                }
            }
        });

        TicketType = findViewById(R.id.rg_TicketType);

        TicketType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                TicketOption = TicketType.findViewById(i);

                switch (i){
                    case R.id.rbSingle:
                        Ticket = TicketOption.getText().toString();
                        break;
                    case R.id.rbWeekly:
                        Ticket = TicketOption.getText().toString();
                        break;
                    case R.id.rbMonthly:
                        Ticket = TicketOption.getText().toString();
                        break;

                        default:
                }
            }
        });

        CheckoutBtn = findViewById(R.id.CheckoutBtn);

        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_bookForm = database.getReference("BookForm");

        CheckoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(Book.this);
                mDialog.setMessage("Please Wait");
                mDialog.show();

                table_bookForm.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        mDialog.dismiss();

                        BookForm bookForm = new BookForm(editText.getText().toString(), editText2.getText().toString(), editText4.getText().toString(),ClassT,Ticket);
                        table_bookForm.child(editText3.getText().toString()).setValue(bookForm);
                        Toast.makeText(Book.this, "Booking Successful!", Toast.LENGTH_SHORT).show();
                        Intent creditCardIntent = new Intent(Book.this, CreditCardForm.class);
                        startActivity(creditCardIntent);
                        finish();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


        };
    }






