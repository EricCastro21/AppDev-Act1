package com.example.appdev_act1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Education extends AppCompatActivity {

    // Declare EditText fields for Educational Background
    private EditText edittxtElemetary, edittxtElementaryBasicEducation, edittxtSecondary, edittxtSecondaryBasicEducation;
    private EditText edittxtVocational, edittxtVocatoinalBasicEducation, edittxtCollege, edittxtCollegeBasicEducation;
    private EditText edittxtGraduate, edittxtGraduateBasicEducation;
    private Button btnSubmit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_education); // Set the layout for educBackground
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        initializeViews();

        // Set click listener for the "Finish" button to pass data and go to the display activity.
        btnSubmit2.setOnClickListener(v -> {
            // Create an Intent to start the Display activity
            Intent intent = new Intent(Education.this, Output.class);

            // Pass the educational background data
            intent.putExtra("nameElem", edittxtElemetary.getText().toString().trim());
            intent.putExtra("courseElem", edittxtElementaryBasicEducation.getText().toString().trim());
            intent.putExtra("nameSecondary", edittxtSecondary.getText().toString().trim());
            intent.putExtra("courseSecondary", edittxtSecondaryBasicEducation.getText().toString().trim());
            intent.putExtra("nameVocational", edittxtVocational.getText().toString().trim());
            intent.putExtra("courseVocational", edittxtVocatoinalBasicEducation.getText().toString().trim());
            intent.putExtra("nameCollege", edittxtCollege.getText().toString().trim());
            intent.putExtra("courseCollege", edittxtCollegeBasicEducation.getText().toString().trim());
            intent.putExtra("nameGrad", edittxtGraduate.getText().toString().trim());
            intent.putExtra("courseGrad", edittxtGraduateBasicEducation.getText().toString().trim());

            // Pass the personal information data from the previous activity (MainActivity)
            intent.putExtra("firstName", getIntent().getStringExtra("firstName"));
            intent.putExtra("middleName", getIntent().getStringExtra("middleName"));
            intent.putExtra("lastName", getIntent().getStringExtra("lastName"));
            intent.putExtra("email", getIntent().getStringExtra("email"));
            intent.putExtra("phone", getIntent().getStringExtra("phone"));
            intent.putExtra("height", getIntent().getStringExtra("height"));
            intent.putExtra("weight", getIntent().getStringExtra("weight"));
            intent.putExtra("pagibig", getIntent().getStringExtra("pagibig"));
            intent.putExtra("tin", getIntent().getStringExtra("tin"));
            intent.putExtra("gsis", getIntent().getStringExtra("gsis"));
            intent.putExtra("philhealth", getIntent().getStringExtra("philhealth"));
            intent.putExtra("emergencyName", getIntent().getStringExtra("emergencyName"));
            intent.putExtra("emergencyContact", getIntent().getStringExtra("emergencyContact"));
            intent.putExtra("relationship", getIntent().getStringExtra("relationship"));

            // Start the Display activity
            startActivity(intent);
        });
    }

    // Method to initialize the EditText fields
    private void initializeViews() {
        edittxtElemetary = findViewById(R.id.edittxtElemetary);
        edittxtElementaryBasicEducation = findViewById(R.id.edittxtElementaryBasicEducation);
        edittxtSecondary = findViewById(R.id.edittxtSecondary);
        edittxtSecondaryBasicEducation = findViewById(R.id.edittxtSecondaryBasicEducation);
        edittxtVocational = findViewById(R.id.edittxtVocational);
        edittxtVocatoinalBasicEducation = findViewById(R.id.edittxtVocatoinalBasicEducation);
        edittxtCollege = findViewById(R.id.edittxtCollege);
        edittxtCollegeBasicEducation = findViewById(R.id.edittxtCollegeBasicEducation);
        edittxtGraduate = findViewById(R.id.edittxtGraduate);
        edittxtGraduateBasicEducation = findViewById(R.id.edittxtGraduateBasicEducation);
        btnSubmit2 = findViewById(R.id.btnSubmit2);
        btnSubmit2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                initializeViews();
                Intent intent = new Intent(Education.this, Output.class);
                startActivity(intent);
            }
        });
    }
}