package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    EditText row1Collumn1EditText;
    EditText row1Collumn2EditText;
    EditText row2Collumn1EditText;
    EditText row2Collumn2EditText;
    Button sumButton;
    Button productButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_secondary);

        row1Collumn1EditText = (EditText) findViewById(R.id.row1_collumn1);
        row1Collumn2EditText = (EditText) findViewById(R.id.row1_collumn2);
        row2Collumn1EditText = (EditText) findViewById(R.id.row2_collumn1);
        row2Collumn2EditText = (EditText) findViewById(R.id.row2_collumn2);

        sumButton = (Button) findViewById(R.id.sum_button);
        productButton = (Button) findViewById(R.id.product_button);

        Intent intent = getIntent();
        String row1col1 = intent.getStringExtra("row1col1");
        String row1col2 = intent.getStringExtra("row1col2");
        String row2col1 = intent.getStringExtra("row2col1");
        String row2col2 = intent.getStringExtra("row2col2");

        if (row1col1 != null) {
            row1Collumn1EditText.setText(row1col1);
        }
        if (row1col2 != null) {
            row1Collumn2EditText.setText(row1col2);
        }

        if (row2col1 != null) {
            row2Collumn1EditText.setText(row2col1);
        }
        if (row2col2 != null) {
            row2Collumn2EditText.setText(row2col2);
        }

        sumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int row1col1Int = 0;
                int row1col2Int = 0;
                int row2col1Int = 0;
                int row2col2Int = 0;

                try {
                    row1col1Int = Integer.parseInt(row1col1);
                    row1col2Int = Integer.parseInt(row1col2);
                    row2col1Int = Integer.parseInt(row2col1);
                    row2col2Int = Integer.parseInt(row2col2);

                    int sum = row1col1Int + row1col2Int + row2col1Int + row2col2Int;
                    Toast toast = Toast.makeText(getApplicationContext(), "Sum: " + sum, Toast.LENGTH_SHORT);
                    toast.show();

                } catch (Exception e) {
                }
            }
        });

        productButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int row1col1Int = 0;
                int row1col2Int = 0;
                int row2col1Int = 0;
                int row2col2Int = 0;

                try {
                    row1col1Int = Integer.parseInt(row1col1);
                    row1col2Int = Integer.parseInt(row1col2);
                    row2col1Int = Integer.parseInt(row2col1);
                    row2col2Int = Integer.parseInt(row2col2);

                    int product = row1col1Int * row1col2Int * row2col1Int * row2col2Int;
                    Toast toast = Toast.makeText(getApplicationContext(), "Product: " + product, Toast.LENGTH_SHORT);
                    toast.show();

                } catch (Exception e) {
                }
            }
        });

    }
}