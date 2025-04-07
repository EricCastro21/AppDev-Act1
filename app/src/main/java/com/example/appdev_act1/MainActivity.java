package com.example.appdev_act1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    // Declare EditText fields for Personal Information
    private EditText edittxtFirstName, edittxtMiddleName, edittxtLastName;
    private EditText edittxtEmail, edittxtPhone;
    private EditText edittxtHeight, edittxtPagibig, edittxtTin, edittxtGsis, edittxtWeight, edittxtPhilhealth;
    private RadioGroup rgGender, rgCivilStatus;
    private RadioButton rbMale, rbFemale, rbLGBTQ;
    private RadioButton rbSingle, rbMerried, rbSeperated, rbWidowed, rbOthers;

    // Declare EditText fields for Emergency Contact
    private EditText edittxtEmergencyContactName, edittxtEmergencyContactNumber, edittxtRelationship;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // Set the layout for MainActivity


            edittxtFirstName = findViewById(R.id.edittxtFirstName);
            edittxtMiddleName = findViewById(R.id.edittxtMiddleName);
            edittxtLastName = findViewById(R.id.edittxtLastName);
            edittxtEmail = findViewById(R.id.edittxtEmail);
            edittxtPhone = findViewById(R.id.edittxtPhone);
            edittxtHeight = findViewById(R.id.edittxtHeight);
            edittxtWeight = findViewById(R.id.edittxtWeight);

            rgGender = findViewById(R.id.rgGender);
            rbMale = findViewById(R.id.rbMale);
            rbFemale = findViewById(R.id.rbFemale);
            rbLGBTQ = findViewById(R.id.rbLGBTQ);

            rgCivilStatus = findViewById(R.id.rgCivilStatus);
            rbSingle = findViewById(R.id.rbSingle);
            rbMerried = findViewById(R.id.rbMerried);
            rbSeperated = findViewById(R.id.rbSeperated);
            rbWidowed = findViewById(R.id.rbWidowed);
            rbOthers = findViewById(R.id.rbOthers);

            edittxtPagibig = findViewById(R.id.edittxtPagibig);
            edittxtPhilhealth = findViewById(R.id.edittxtPhilhealth);
            edittxtTin = findViewById(R.id.edittxtTin);
            edittxtGsis = findViewById(R.id.edittxtGsis);

            edittxtEmergencyContactName = findViewById(R.id.edittxtEmergencyContactName);
            edittxtEmergencyContactNumber = findViewById(R.id.edittxtEmergencyContactNumber);
            edittxtRelationship = findViewById(R.id.edittxtRelationship);

            Button btnSubmit = findViewById(R.id.btnSubmit);
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    validateFields();
                }
            });

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        private void validateFields() {
            // Get the text from all EditText fields, trimming whitespace
            String firstName = edittxtFirstName.getText().toString().trim();
            String middleName = edittxtMiddleName.getText().toString().trim();
            String lastName = edittxtLastName.getText().toString().trim();
            String email = edittxtEmail.getText().toString().trim();
            String phone = edittxtPhone.getText().toString().trim();
            String height = edittxtHeight.getText().toString().trim();
            String weight = edittxtWeight.getText().toString().trim();

            int selectedGender =  rgGender.getCheckedRadioButtonId();
            String gender = "";
            if (selectedGender != -1) {
                RadioButton selectedRadioButton = findViewById(selectedGender);
                gender = selectedRadioButton.getText().toString();
            }

            int selectedStatus = rgCivilStatus.getCheckedRadioButtonId();
            String status = "";
            if (selectedStatus != -1) {
                RadioButton selectedRadioButton = findViewById(selectedStatus);
                status = selectedRadioButton.getText().toString();
            }

            String pagibig = edittxtPagibig.getText().toString().trim();
            String tin = edittxtTin.getText().toString().trim();
            String philhealth = edittxtPhilhealth.getText().toString().trim();
            String gsis = edittxtGsis.getText().toString().trim();

            String fullName = edittxtEmergencyContactName.getText().toString().trim();
            String emergencyContactNumber = edittxtEmergencyContactNumber.getText().toString().trim();
            String relationship = edittxtRelationship.getText().toString().trim();

            boolean hasError = false;
            if (!firstName.matches("^[a-zA-Z ]+$")) {
                edittxtFirstName.setError("Name must contain only letters and spaces");
                hasError = true;
            }
            if (!middleName.matches("^[a-zA-Z ]+$")) {
                edittxtMiddleName.setError("Name must contain only letters and spaces");
                hasError = true;
            }
            if (!lastName.matches("^[a-zA-Z ]+$")) {
                edittxtLastName.setError("Name must contain only letters and spaces");
                hasError = true;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                edittxtEmail.setError("Invalid email address");
                hasError = true;
            }
            if (!Pattern.matches("\\d{11}", phone)) {
                edittxtPhone.setError("Phone number must be 11 digits");
                hasError = true;
            }
            if (!fullName.matches("^[a-zA-Z ]+$")) {
                edittxtEmergencyContactName.setError("Name must contain only letters and spaces");
                hasError = true;
            }
            if (!Pattern.matches("\\d{11}", emergencyContactNumber)) {
                edittxtEmergencyContactNumber.setError("Emergency contact number must be 11 digits");
                hasError = true;
            }
            if (!relationship.matches("^[a-zA-Z ]+$")) {
                edittxtRelationship.setError("Must contain only letters and spaces");
                hasError = true;
            }
            if (firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty() ||
                    email.isEmpty() || phone.isEmpty() || height.isEmpty() ||
                    weight.isEmpty() || fullName.isEmpty() || emergencyContactNumber.isEmpty() ||
                    relationship.isEmpty() || gender.isEmpty() || status.isEmpty()) {

                Toast.makeText(this, "Please fill in all required fields.", Toast.LENGTH_SHORT).show();
                hasError = true; //make this true after testing
            }
            //hasError = false; //remove after testing
            if (hasError) {
                return;
            }
            // All fields are filled in and valid, do something here (e.g., submit the form)
            Toast.makeText(this, "Processing...", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, Education.class);

            intent.putExtra("key_first_name", firstName);
            intent.putExtra("key_middle_name", middleName);
            intent.putExtra("key_last_name", lastName);
            intent.putExtra("key_email", email);

            intent.putExtra("key_gender", gender);

            intent.putExtra("key_phone", phone);
            intent.putExtra("key_height", height);
            intent.putExtra("key_weight", weight);

            intent.putExtra("key_status", status);

            intent.putExtra("key_pagibig", pagibig);
            intent.putExtra("key_tin", tin);
            intent.putExtra("key_philhealth", philhealth);
            intent.putExtra("key_gsis", gsis);

            intent.putExtra("key_full_name", fullName);
            intent.putExtra("key_emergency_contact_number", emergencyContactNumber);
            intent.putExtra("key_relationship", relationship);

            startActivity(intent);
        }
    }
