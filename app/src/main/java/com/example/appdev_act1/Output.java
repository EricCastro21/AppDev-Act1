package com.example.appdev_act1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Output extends AppCompatActivity {

    // Declare TextView fields to display the data
    private TextView nameOutput, emailOutput, phoneOutput, heightOutput, weightOutput;
    private TextView pagibigOutput, tinOutput, gsisOutput, philhealthOutpt;
    private TextView emergencynameOutput, EmergencynameContact, relationshipOutput;
    private TextView elemetaryOutput, elementaryBasicEducationOutput, secondaryOutput, secondaryBasicEducationOutput,
            vocationOutput, vocationBasicEducationOutput, collegeOutput
            , collegeBasicEducationOutput,
            graduateOutput, graduateBasicEducationOutput;
    private Button btnCreateNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_output); // Set the layout for Display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        initializeViews();

        // Display the data received from the previous activities
        displayData();
    }

    // Method to initialize the TextView fields
    private void initializeViews() {
        nameOutput = findViewById(R.id.nameOutput);
        emailOutput = findViewById(R.id.emailOutput);
        phoneOutput = findViewById(R.id.phoneOutput);
        heightOutput = findViewById(R.id.heightOutput);
        weightOutput = findViewById(R.id.weightOutput);
        pagibigOutput = findViewById(R.id.pagibigOutput);
        tinOutput = findViewById(R.id.tinOutput);
        gsisOutput = findViewById(R.id.gsisOutput);
        philhealthOutpt = findViewById(R.id.philhealthOutpt);
        emergencynameOutput = findViewById(R.id.emergencynameOutput);
        EmergencynameContact = findViewById(R.id.EmergencynameContact);
        relationshipOutput = findViewById(R.id.relationshipOutput);
        elemetaryOutput = findViewById(R.id.elemetaryOutput);
        elementaryBasicEducationOutput = findViewById(R.id.elementaryBasicEducationOutput);
        secondaryOutput = findViewById(R.id.secondaryOutput);
        secondaryBasicEducationOutput = findViewById(R.id.secondaryBasicEducationOutput);
        vocationOutput = findViewById(R.id.vocationOutput);
        vocationBasicEducationOutput = findViewById(R.id.vocationBasicEducationOutput);
        collegeOutput = findViewById(R.id.collegeOutput);
        collegeBasicEducationOutput = findViewById(R.id.collegeBasicEducationOutput);
        graduateOutput = findViewById(R.id.graduateOutput);
        graduateBasicEducationOutput = findViewById(R.id.graduateBasicEducationOutput);

        //Button
        btnCreateNew = findViewById(R.id.btnCreateNew);
        btnCreateNew.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                displayData();
                Intent intent = new Intent(Output.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    // Method to display the data from the Intent
    private void displayData() {
        Intent intent = getIntent();

        // Retrieve personal information and display it
        String firstName = intent.getStringExtra("firstName");
        String middleName = intent.getStringExtra("middleName");
        String lastName = intent.getStringExtra("lastName");
        String fullName = (firstName != null ? firstName : "") + " " +
                (middleName != null ? middleName : "") + " " +
                (lastName != null ? lastName : "");
        nameOutput.setText(fullName.trim()); // Remove "Name: "

        emailOutput.setText(intent.getStringExtra("email") != null ? intent.getStringExtra("email") : ""); // Remove "Email: "
        phoneOutput.setText(intent.getStringExtra("phone") != null ? intent.getStringExtra("phone") : ""); // Remove "Phone: "
        heightOutput.setText(intent.getStringExtra("height") != null ? intent.getStringExtra("height") : ""); // Remove "Height: "
        weightOutput.setText(intent.getStringExtra("weight") != null ? intent.getStringExtra("weight") : ""); // Remove "Weight: "
        pagibigOutput.setText(intent.getStringExtra("pagibig") != null ? intent.getStringExtra("pagibig") : ""); // Remove "Pagibig: "
        tinOutput.setText(intent.getStringExtra("tin") != null ? intent.getStringExtra("tin") : ""); // Remove "TIN: "
        gsisOutput.setText(intent.getStringExtra("gsis") != null ? intent.getStringExtra("gsis") : ""); // Remove "GSIS: "
        philhealthOutpt.setText(intent.getStringExtra("philhealth") != null ? intent.getStringExtra("philhealth") : ""); // Remove "Philhealth: "
        emergencynameOutput.setText(intent.getStringExtra("emergencyName") != null ? intent.getStringExtra("emergencyName") : ""); // Remove "Emergency Name: "
        EmergencynameContact.setText(intent.getStringExtra("emergencyContact") != null ? intent.getStringExtra("emergencyContact") : ""); // Remove "Emergency Contact: "
        relationshipOutput.setText(intent.getStringExtra("relationship") != null ? intent.getStringExtra("relationship") : ""); // Remove "Relationship: "

        // Retrieve educational background information and display it
        String nameElem = intent.getStringExtra("nameElem");
        String courseElem = intent.getStringExtra("courseElem");
        elemetaryOutput.setText(nameElem != null ? nameElem : ""); // Remove "Elementary Name: "
        elementaryBasicEducationOutput.setText(courseElem != null ? courseElem : ""); // Remove "Elementary Course: "

        String nameSecondary = intent.getStringExtra("nameSecondary");
        String courseSecondary = intent.getStringExtra("courseSecondary");
        secondaryOutput.setText(nameSecondary != null ? nameSecondary : ""); // Remove "Secondary Name: "
        secondaryBasicEducationOutput.setText(courseSecondary != null ? courseSecondary : ""); // Remove "Secondary Course: "

        String nameVocational = intent.getStringExtra("nameVocational");
        String courseVocational = intent.getStringExtra("courseVocational");
        vocationOutput.setText(nameVocational != null ? nameVocational : ""); // Remove "Vocational Name: "
        vocationBasicEducationOutput.setText(courseVocational != null ? courseVocational : ""); // Remove "Vocational Course: "

        String nameCollege = intent.getStringExtra("nameCollege");
        String courseCollege = intent.getStringExtra("courseCollege");
        collegeOutput.setText(nameCollege != null ? nameCollege : ""); // Remove "College Name: "
        collegeBasicEducationOutput.setText(courseCollege != null ? courseCollege : ""); // Remove "College Course: "

        String nameGrad = intent.getStringExtra("nameGrad");
        String courseGrad = intent.getStringExtra("courseGrad");
        graduateOutput.setText(nameGrad != null ? nameGrad : ""); // Remove "Graduate Name: "
        graduateBasicEducationOutput.setText(courseGrad != null ? courseGrad : ""); // Remove "Graduate Course: "
    }
}