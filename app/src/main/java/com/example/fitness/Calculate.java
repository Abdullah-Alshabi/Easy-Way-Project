package com.example.fitness;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class Calculate extends AppCompatActivity {
    private EditText weightInput, heightInput;
    private TextView txtResult;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);


        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        calculateButton = findViewById(R.id.calculateButton);
        txtResult = findViewById(R.id.txtResult);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightStr = weightInput.getText().toString();
                String heightStr = heightInput.getText().toString();

                if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
                    float weight = Float.parseFloat(weightStr);
                    float heightCm = Float.parseFloat(heightStr);

                    if (weight == 0 || heightCm == 0) {
                        txtResult.setText("Weight and height must be greater than 0.");
                    } else {
                        float heightMeters = heightCm / 100f;
                        float bmi = weight / (heightMeters * heightMeters);
                        txtResult.setText("Your BMI is: " + String.format("%.2f", bmi));
                    }
                } else {
                    txtResult.setText("Please enter both weight and height.");
                }
            }
        });

        ImageView backArrow = (ImageView)findViewById(R.id.back_arrow);
        backArrow.setOnClickListener(v -> onBackPressed());
    }
}