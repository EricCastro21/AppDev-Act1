package com.example.appdev_act1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

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
    private CheckBox chkElementary, chkSecondary, chkCollege, chkGraduate;
    private Button btnSubmit2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_education);

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

        chkElementary = findViewById(R.id.chkElementary);
        chkElementary.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Disable EditText if CheckBox is checked, enable otherwise
            edittxtElemetary.setEnabled(isChecked);
            edittxtElementaryBasicEducation.setEnabled(isChecked);
        });
        chkSecondary = findViewById(R.id.chkSecondary);
        chkSecondary.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Disable EditText if CheckBox is checked, enable otherwise
            edittxtSecondary.setEnabled(isChecked);
            edittxtSecondaryBasicEducation.setEnabled(isChecked);
            chkElementary.setChecked(true);
        });
        chkCollege = findViewById(R.id.chkCollege);
        chkCollege.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Disable EditText if CheckBox is checked, enable otherwise
            edittxtCollege.setEnabled(isChecked);
            edittxtCollegeBasicEducation.setEnabled(isChecked);
            chkElementary.setChecked(true);
            chkSecondary.setChecked(true);
        });
        chkGraduate = findViewById(R.id.chkGraduate);
        chkGraduate.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Disable EditText if CheckBox is checked, enable otherwise
            edittxtGraduate.setEnabled(isChecked);
            edittxtGraduateBasicEducation.setEnabled(isChecked);
            chkElementary.setChecked(true);
            chkSecondary.setChecked(true);
            chkCollege.setChecked(true);

        });

        btnSubmit2 = findViewById(R.id.btnSubmit2);
        btnSubmit2.setOnClickListener(new View.OnClickListener() {
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
        String elementary = edittxtElemetary.getText().toString().trim();
        String elementaryCourse = edittxtElementaryBasicEducation.getText().toString().trim();
        String secondary = edittxtSecondary.getText().toString().trim();
        String secondaryCourse = edittxtSecondaryBasicEducation.getText().toString().trim();
        String vocational = edittxtVocational.getText().toString().trim();
        String vocationalCourse = edittxtVocatoinalBasicEducation.getText().toString().trim();
        String college = edittxtCollege.getText().toString().trim();
        String collegeCourse = edittxtCollegeBasicEducation.getText().toString().trim();
        String graduateStudies = edittxtGraduate.getText().toString().trim();
        String graduateStudiesCourse = edittxtGraduateBasicEducation.getText().toString().trim();

        chkElementary = findViewById(R.id.chkElementary);
        chkSecondary = findViewById(R.id.chkSecondary);
        chkCollege = findViewById(R.id.chkCollege);
        chkGraduate = findViewById(R.id.chkGraduate);

        boolean hasError = false;

        if (chkElementary.isChecked() && elementary.isEmpty() && elementaryCourse.isEmpty()){
            hasError = true;
            if (!elementary.matches("^[a-zA-Z /-]+$")) {
                edittxtElemetary.setError("Must contain only letters, spaces, and valid characters");
                edittxtElementaryBasicEducation.setError("Must contain only letters, spaces, and valid characters");

            }
        }
        if (chkSecondary.isChecked() && secondary.isEmpty() && secondaryCourse.isEmpty()){
            hasError = true;
            if (!elementary.matches("^[a-zA-Z /-]+$")) {
                edittxtSecondary.setError("Must contain only letters, spaces, and valid characters");
                edittxtSecondaryBasicEducation.setError("Must contain only letters, spaces, and valid characters");

            }
        }
        if (chkCollege.isChecked() && college.isEmpty() && collegeCourse.isEmpty()){
            hasError = true;
            if (!elementary.matches("^[a-zA-Z /-]+$")) {
                edittxtCollege.setError("Must contain only letters, spaces, and valid characters");
                edittxtCollegeBasicEducation.setError("Must contain only letters, spaces, and valid characters");

            }
        }
        if (chkGraduate.isChecked() && graduateStudies.isEmpty() && graduateStudiesCourse.isEmpty()){
            hasError = true;
            if (!elementary.matches("^[a-zA-Z /-]+$")) {
                edittxtGraduate.setError("Must contain only letters, spaces, and valid characters");
                edittxtGraduateBasicEducation.setError("Must contain only letters, spaces, and valid characters");

            }
        }
        //hasError = false; //remove after testing
        if (hasError) {
            Toast.makeText(this, "Please fill in all required fields.", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Education.this, criminalActivity.class);

        intent.putExtra("key_elementary", elementary);
        intent.putExtra("key_elementary_course", elementaryCourse);
        intent.putExtra("key_secondary", secondary);
        intent.putExtra("key_secondary_course", secondaryCourse);
        intent.putExtra("key_vocational", vocational);
        intent.putExtra("key_vocational_course", vocationalCourse);
        intent.putExtra("key_college", college);
        intent.putExtra("key_college_course", collegeCourse);
        intent.putExtra("key_graduate_studies", graduateStudies);
        intent.putExtra("key_graduate_studies_course", graduateStudiesCourse);

        Intent previousIntent = getIntent();

        intent.putExtra("key_first_name", previousIntent.getStringExtra("key_first_name"));
        intent.putExtra("key_middle_name", previousIntent.getStringExtra("key_middle_name"));
        intent.putExtra("key_last_name", previousIntent.getStringExtra("key_last_name"));
        intent.putExtra("key_email", previousIntent.getStringExtra("key_email"));
        intent.putExtra("key_phone", previousIntent.getStringExtra("key_phone"));
        intent.putExtra("key_height", previousIntent.getStringExtra("key_height"));
        intent.putExtra("key_weight", previousIntent.getStringExtra("key_weight"));
        intent.putExtra("key_pagibig", previousIntent.getStringExtra("key_pagibig"));
        intent.putExtra("key_tin", previousIntent.getStringExtra("key_tin"));
        intent.putExtra("key_philhealth", previousIntent.getStringExtra("key_philhealth"));
        intent.putExtra("key_gsis", previousIntent.getStringExtra("key_gsis"));
        intent.putExtra("key_full_name", previousIntent.getStringExtra("key_full_name"));
        intent.putExtra("key_emergency_contact_number", previousIntent.getStringExtra("key_emergency_contact_number"));
        intent.putExtra("key_relationship", previousIntent.getStringExtra("key_relationship"));
        intent.putExtra("key_gender", previousIntent.getStringExtra("key_gender"));
        intent.putExtra("key_status", previousIntent.getStringExtra("key_status"));
        startActivity(intent);
    }

}