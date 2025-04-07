package com.example.appdev_act1;

import android.content.Intent;
import android.os.Bundle;
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

public class criminalActivity extends AppCompatActivity {
        private CheckBox chk_yes1, chk_no1, chk_yes2, chk_no2, chk_yes3, chk_no3, chk_yes_a, chk_no_a, chk_yes_b, chk_no_b, chk_yes_c, chk_no_c;
        private Button btnSubmit3;
        private EditText edittxt1, edittxt2, edittxt3, edittxtA, edittxtB, edittxtC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_criminal);

            edittxt1 = findViewById(R.id.edittxt1);
            edittxt2 = findViewById(R.id.edittxt2);
            edittxt3 = findViewById(R.id.edittxt3);
            edittxtA = findViewById(R.id.edittxtA);
            edittxtB = findViewById(R.id.edittxtB);
            edittxtC = findViewById(R.id.edittxtC);

        chk_yes1 = findViewById(R.id.chk_yes1);
        chk_yes1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            edittxt1.setEnabled(isChecked);
            chk_no1.setChecked(false);
            });
        chk_no1 = findViewById(R.id.chk_no1);
        chk_no1 = findViewById(R.id.chk_no1);
        chk_no1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            edittxt1.setEnabled(!isChecked);
            edittxt1.setText("");
            chk_yes1.setChecked(false);
            });

        chk_yes2 = findViewById(R.id.chk_yes2);
        chk_yes2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            edittxt2.setEnabled(isChecked);
            chk_no2.setChecked(false);
            });
        chk_no2 = findViewById(R.id.chk_no2);
        chk_no2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            edittxt2.setEnabled(!isChecked);
            edittxt2.setText("");
                chk_yes2.setChecked(false);
            });

        chk_yes3 = findViewById(R.id.chk_yes3);
        chk_yes3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            edittxt3.setEnabled(isChecked);
            chk_no3.setChecked(false);
            });
        chk_no3 = findViewById(R.id.chk_no3);
        chk_no3.setOnCheckedChangeListener((buttonView, isChecked) -> {
                edittxt3.setEnabled(!isChecked);
                edittxt3.setText("");
                chk_yes3.setChecked(false);
            });

            chk_yes_a = findViewById(R.id.chk_yes_a);
        chk_yes_a.setOnCheckedChangeListener((buttonView, isChecked) -> {
            edittxtA.setEnabled(isChecked);
                chk_no_a.setChecked(false);
            });
        chk_no_a = findViewById(R.id.chk_no_a);
        chk_no_a.setOnCheckedChangeListener((buttonView, isChecked) -> {
            edittxtA.setEnabled(!isChecked);
            edittxtA.setText("");
            chk_yes_a.setChecked(false);
            });

        chk_yes_b = findViewById(R.id.chk_yes_b);
        chk_yes_b.setOnCheckedChangeListener((buttonView, isChecked) -> {
                edittxtB.setEnabled(isChecked);
            chk_no_b.setChecked(false);
            });
        chk_no_b = findViewById(R.id.chk_no_b);
        chk_no_b.setOnCheckedChangeListener((buttonView, isChecked) -> {
                edittxtB.setEnabled(!isChecked);
                edittxtB.setText("");
                chk_yes_b.setChecked(false);
            });

        chk_yes_c = findViewById(R.id.chk_yes_c);
        chk_yes_c.setOnCheckedChangeListener((buttonView, isChecked) -> {
            edittxtC.setEnabled(isChecked);
                chk_no_c.setChecked(false);
            });
        chk_no_c = findViewById(R.id.chk_no_c);
        chk_no_c.setOnCheckedChangeListener((buttonView, isChecked) -> {
            edittxtC.setEnabled(!isChecked);
            edittxtC.setText("");
            chk_yes_c.setChecked(false);
            });

            btnSubmit3 = findViewById(R.id.btnSubmit3);
        btnSubmit3.setOnClickListener(new View.OnClickListener() {
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
        private void validateFields () {
            boolean hasError = false;

            String answerOne = edittxt1.getText().toString().trim();
            String answerTwo = edittxt2.getText().toString().trim();
            String answerThree = edittxt3.getText().toString().trim();
            String answerFourA = edittxtA.getText().toString().trim();
            String answerFourB = edittxtB.getText().toString().trim();
            String answerFourC = edittxtC.getText().toString().trim();

            boolean questionOneNo = chk_no1.isChecked();
            boolean questionTwoNo = chk_no2.isChecked();
            boolean questionThreeNo = chk_no3.isChecked();
            boolean questionFourANo = chk_no_a.isChecked();
            boolean questionFourBNo = chk_no_b.isChecked();
            boolean questionFourCNo = chk_no_c.isChecked();

            if (answerOne.isEmpty() && !questionOneNo) {
                hasError = true;
            }
            if (answerTwo.isEmpty() && !questionTwoNo) {
                hasError = true;
            }
            if (answerThree.isEmpty() && !questionThreeNo) {
                hasError = true;
            }
            if (answerFourA.isEmpty() && !questionFourANo) {
                hasError = true;
            }
            if (answerFourB.isEmpty() && !questionFourBNo) {
                hasError = true;
            }
            if (answerFourC.isEmpty() && !questionFourCNo) {
                hasError = true;
            }

            //hasError = false; //remove after testing
            if (hasError) {
                Toast.makeText(this, "Please fill in all required fields.", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, Output.class);
            intent.putExtra("key_answer_one", answerOne);
            intent.putExtra("key_answer_two", answerTwo);
            intent.putExtra("key_answer_three", answerThree);
            intent.putExtra("key_answer_four_a", answerFourA);
            intent.putExtra("key_answer_four_b", answerFourB);
            intent.putExtra("key_answer_four_c", answerFourC);

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

            intent.putExtra("key_elementary", previousIntent.getStringExtra("key_elementary"));
            intent.putExtra("key_elementary_course", previousIntent.getStringExtra("key_elementary_course"));
            intent.putExtra("key_secondary", previousIntent.getStringExtra("key_secondary"));
            intent.putExtra("key_secondary_course", previousIntent.getStringExtra("key_secondary_course"));
            intent.putExtra("key_vocational", previousIntent.getStringExtra("key_vocational"));
            intent.putExtra("key_vocational_course", previousIntent.getStringExtra("key_vocational_course"));
            intent.putExtra("key_college", previousIntent.getStringExtra("key_college"));
            intent.putExtra("key_college_course", previousIntent.getStringExtra("key_college_course"));
            intent.putExtra("key_graduate_studies", previousIntent.getStringExtra("key_graduate_studies"));
            intent.putExtra("key_graduate_studies_course", previousIntent.getStringExtra("key_graduate_studies_course"));

            startActivity(intent);

        }
    }