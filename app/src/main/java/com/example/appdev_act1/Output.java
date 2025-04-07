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

    private TextView GenderOutput, OutputCivilStatus ,AdminOutput, CriminalOutput, ConvictionOutput, IndigenousOutput, DisabilityOutput, SoloParentOutput ;
    private Button btnCreateNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_output);
        nameOutput = findViewById(R.id.nameOutput);
        emailOutput = findViewById(R.id.emailOutput);
        GenderOutput = findViewById(R.id.GenderOutput);
        phoneOutput = findViewById(R.id.phoneOutput);
        heightOutput = findViewById(R.id.heightOutput);
        weightOutput = findViewById(R.id.weightOutput);
        OutputCivilStatus = findViewById(R.id.OutputCivilStatus);
        pagibigOutput = findViewById(R.id.pagibigOutput);
        tinOutput = findViewById(R.id.tinOutput);
        philhealthOutpt = findViewById(R.id.philhealthOutpt);
        gsisOutput = findViewById(R.id.gsisOutput);
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
        collegeBasicEducationOutput= findViewById(R.id.collegeBasicEducationOutput);
        graduateOutput = findViewById(R.id.graduateOutput);
        graduateBasicEducationOutput = findViewById(R.id.graduateBasicEducationOutput);
        AdminOutput = findViewById(R.id.AdminOutput);
        CriminalOutput = findViewById(R.id.CriminalOutput);
        ConvictionOutput = findViewById(R.id.ConvictionOutput);
        IndigenousOutput = findViewById(R.id.IndigenousOutput);
        DisabilityOutput = findViewById(R.id.DisabilityOutput);
        SoloParentOutput = findViewById(R.id.SoloParentOutput);

        Intent intent = getIntent();

        String firstName = intent.getStringExtra("key_first_name");
        String middleName = intent.getStringExtra("key_middle_name");
        String lastName = intent.getStringExtra("key_last_name");
        String email = intent.getStringExtra("key_email");
        String gender = intent.getStringExtra("key_gender");

        String phone = intent.getStringExtra("key_phone");
        String height = intent.getStringExtra("key_height");
        String weight = intent.getStringExtra("key_weight");
        String status = intent.getStringExtra("key_status");

        String pagibig = intent.getStringExtra("key_pagibig");
        String tin = intent.getStringExtra("key_tin");
        String philhealth = intent.getStringExtra("key_philhealth");
        String gsis = intent.getStringExtra("key_gsis");
        String fullName = intent.getStringExtra("key_full_name");
        String emergencyContactNumber = intent.getStringExtra("key_emergency_contact_number");
        String relationship = intent.getStringExtra("key_relationship");

        String elementary = intent.getStringExtra("key_elementary");
        String elementaryCourse = intent.getStringExtra("key_elementary_course");
        String secondary = intent.getStringExtra("key_secondary");
        String secondaryCourse = intent.getStringExtra("key_secondary_course");
        String vocational = intent.getStringExtra("key_vocational");
        String vocationalCourse = intent.getStringExtra("key_vocational_course");
        String college = intent.getStringExtra("key_college");
        String collegeCourse = intent.getStringExtra("key_college_course");
        String graduateStudies = intent.getStringExtra("key_graduate_studies");
        String graduateStudiesCourse = intent.getStringExtra("key_graduate_studies_course");

        String answerOne = intent.getStringExtra("key_answer_one");
        String answerTwo = intent.getStringExtra("key_answer_two");
        String answerThree = intent.getStringExtra("key_answer_three");
        String answerFourA = intent.getStringExtra("key_answer_four_a");
        String answerFourB = intent.getStringExtra("key_answer_four_b");
        String answerFourC = intent.getStringExtra("key_answer_four_c");


        nameOutput.setText(firstName +" "+ middleName +" "+ lastName);
        emailOutput.setText(email);
        GenderOutput.setText(gender);
        phoneOutput.setText(phone);
        heightOutput.setText(height);
        weightOutput.setText(weight);
        OutputCivilStatus.setText(status);
        pagibigOutput.setText(pagibig);
        tinOutput.setText(tin);
        philhealthOutpt.setText(philhealth);
        gsisOutput.setText(gsis);
        emergencynameOutput.setText(fullName);
        EmergencynameContact.setText(emergencyContactNumber);
        relationshipOutput.setText(relationship);

        elemetaryOutput.setText(elementary);
        elementaryBasicEducationOutput.setText(elementaryCourse);
        if (elementary.isBlank()) {
            elemetaryOutput.setText("");
            elementaryBasicEducationOutput.setText("");

        }
        secondaryOutput.setText(secondary);
        secondaryBasicEducationOutput.setText(secondaryCourse);
        if (secondary.isBlank()) {
            secondaryOutput.setText("");
            secondaryBasicEducationOutput.setText("");

        }
        vocationOutput.setText(vocational);
        vocationBasicEducationOutput.setText(vocationalCourse);
        if (vocational.isBlank()) {
            vocationOutput.setText("");
            vocationBasicEducationOutput.setText("");

        }
        collegeOutput.setText(college);
        collegeBasicEducationOutput.setText(collegeCourse);
        if (college.isBlank()) {
            collegeOutput.setText("");
            collegeBasicEducationOutput.setText("");

        }
        graduateOutput.setText(graduateStudies);
        graduateBasicEducationOutput.setText(graduateStudiesCourse);
        if (graduateStudies.isBlank()) {
            graduateOutput.setText("");
            graduateBasicEducationOutput.setText("");

        }

        if (!answerOne.isBlank()) AdminOutput.setText(answerOne);
        else AdminOutput.setText("");

        if (!answerTwo.isBlank()) CriminalOutput.setText(answerTwo);
        else CriminalOutput.setText("");

        if (!answerThree.isBlank()) ConvictionOutput.setText(answerThree);
        else ConvictionOutput.setText("");

        if (!answerFourA.isBlank()) IndigenousOutput.setText(answerFourA);
        else IndigenousOutput.setText("");

        if (!answerFourB.isBlank()) DisabilityOutput.setText(answerFourB);
        else DisabilityOutput.setText("");

        if (!answerFourC.isBlank()) SoloParentOutput.setText(answerFourC);
        else SoloParentOutput.setText("");

        btnCreateNew = findViewById(R.id.btnCreateNew);
        btnCreateNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Output.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}