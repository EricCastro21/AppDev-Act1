package com.example.appdev_act1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declare EditText fields for Personal Information
    private EditText edittxtFirstName, edittxtMiddleName, edittxtLastName;
    private EditText edittxtEmail, edittxtPhone;
    private EditText edittxtHeight, edittxtPagibig, edittxtTin, edittxtGsis, edittxtWeight, edittxtPhilhealth
            ;

    // Declare EditText fields for Emergency Contact
    private EditText edittxtEmergencyContactName, edittxtEmergencyContactNumber, edittxtRelationship;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // Set the layout for MainActivity
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        initializeViews();

        // Set click listener for the "Next" button to validate and proceed
        btnSubmit.setOnClickListener(v -> validateAndProcessForm());
    }

    // Method to initialize all the EditText fields and the Next button
    private void initializeViews() {
        // Personal Information
        edittxtFirstName = findViewById(R.id.edittxtFirstName);
        edittxtMiddleName = findViewById(R.id.edittxtMiddleName);
        edittxtLastName = findViewById(R.id.edittxtLastName);
        edittxtEmail = findViewById(R.id.edittxtEmail);
        edittxtPhone = findViewById(R.id.edittxtPhone);
        edittxtHeight = findViewById(R.id.edittxtHeight);
        edittxtPagibig = findViewById(R.id.edittxtPagibig);
        edittxtTin = findViewById(R.id.edittxtTin);
        edittxtGsis = findViewById(R.id.edittxtGsis);
        edittxtWeight = findViewById(R.id.edittxtWeight);
        edittxtPhilhealth = findViewById(R.id.edittxtPhilhealth);

        // Emergency Contact
        edittxtEmergencyContactName = findViewById(R.id.edittxtEmergencyContactName);
        edittxtEmergencyContactNumber = findViewById(R.id.edittxtEmergencyContactNumber);
        edittxtRelationship = findViewById(R.id.edittxtRelationship);

        // Button
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                validateAndProcessForm();
                Intent intent = new Intent(MainActivity.this, Education.class);
                startActivity(intent);
            }
        });
    }

    // Method to validate the form fields and start the next activity
    private void validateAndProcessForm() {
        // Validate Personal Information fields
        if (isFieldEmpty(edittxtFirstName, "First Name")) return;
        if (isFieldEmpty(edittxtMiddleName, "Middle Name")) return;
        if (isFieldEmpty(edittxtLastName, "Last Name")) return;
        if (isFieldEmpty(edittxtEmail, "Email")) return;
        if (isFieldEmpty(edittxtPhone, "Phone")) return;
        if (isFieldEmpty(edittxtHeight, "Height")) return;
        if (isFieldEmpty(edittxtWeight, "Weight")) return;

        // Validate Emergency Contact fields
        if (isFieldEmpty(edittxtEmergencyContactName, "Emergency Contact Name")) return;
        if (isFieldEmpty(edittxtEmergencyContactNumber, "Emergency Contact Number")) return;
        if (isFieldEmpty(edittxtRelationship, "Relationship")) return;

        // Display a success message
        Toast.makeText(this, "Form submitted successfully!", Toast.LENGTH_SHORT).show();

        // Create an Intent to start the educBackground activity
        Intent intent = new Intent(MainActivity.this, Education.class);

        // Pass the data from the EditText fields to the Intent
        intent.putExtra("firstName", edittxtFirstName.getText().toString().trim());
        intent.putExtra("middleName", edittxtMiddleName.getText().toString().trim());
        intent.putExtra("lastName", edittxtLastName.getText().toString().trim());
        intent.putExtra("email", edittxtEmail.getText().toString().trim());
        intent.putExtra("phone", edittxtPhone.getText().toString().trim());
        intent.putExtra("height", edittxtHeight.getText().toString().trim());
        intent.putExtra("pagibig", edittxtPagibig.getText().toString().trim());
        intent.putExtra("tin", edittxtTin.getText().toString().trim());
        intent.putExtra("gsis", edittxtGsis.getText().toString().trim());
        intent.putExtra("weight", edittxtWeight.getText().toString().trim());
        intent.putExtra("philhealth", edittxtPhilhealth.getText().toString().trim());
        intent.putExtra("emergencyName", edittxtEmergencyContactName.getText().toString().trim());
        intent.putExtra("emergencyContact", edittxtEmergencyContactNumber.getText().toString().trim());
        intent.putExtra("relationship", edittxtRelationship.getText().toString().trim());

        // Start the educBackground activity
        startActivity(intent);
    }

    // Helper method to check if an EditText field is empty
    private boolean isFieldEmpty(EditText editText, String fieldName) {
        String text = editText.getText().toString().trim();
        if (text.isEmpty()) {
            Toast.makeText(this, fieldName + " is required", Toast.LENGTH_SHORT).show();
            editText.requestFocus();
            return true;
        }
        return false;
    }
}