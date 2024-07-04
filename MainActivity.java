import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText etMin, etMax;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMin = findViewById(R.id.etMin); // EditText for minimum value
        etMax = findViewById(R.id.etMax); // EditText for maximum value
        tvResult = findViewById(R.id.tvResult); // TextView to display result

        Button btnGenerate = findViewById(R.id.btnGenerate);
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumber();
            }
        });
    }

    private void generateRandomNumber() {
        try {
            int min = Integer.parseInt(etMin.getText().toString());
            int max = Integer.parseInt(etMax.getText().toString());

            if (min <= max) {
                Random random = new Random();
                int randomNumber = random.nextInt((max - min) + 1) + min;
                tvResult.setText(String.valueOf(randomNumber));
            } else {
                tvResult.setText("Invalid range. Min should be less than or equal to Max.");
            }
        } catch (NumberFormatException e) {
            tvResult.setText("Please enter valid numbers for Min and Max.");
        }
    }
}
