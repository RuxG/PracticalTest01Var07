package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    EditText row1Collumn1EditText;
    EditText row1Collumn2EditText;
    EditText row2Collumn1EditText;
    EditText row2Collumn2EditText;
    Button setButton;

    String row1col1 = "";
    String row1col2 = "";
    String row2col1 = "";
    String row2col2 = "";

    MyBroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        row1Collumn1EditText = (EditText) findViewById(R.id.row1_collumn1);
        row1Collumn2EditText = (EditText) findViewById(R.id.row1_collumn2);
        row2Collumn1EditText = (EditText) findViewById(R.id.row2_collumn1);
        row2Collumn2EditText = (EditText) findViewById(R.id.row2_collumn2);

        setButton = (Button) findViewById(R.id.set_button);

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                row1col1 = row1Collumn1EditText.getText().toString();
                row1col2 = row1Collumn2EditText.getText().toString();
                row2col1 = row2Collumn1EditText.getText().toString();
                row2col2 = row2Collumn2EditText.getText().toString();

                if (row1col1.compareTo("") != 0 && row1col2.compareTo("") != 0 &&
                        row2col1.compareTo("") != 0 && row2col2.compareTo("") != 0 ) {

                        int row1col1Int = 0;
                        int row1col2Int = 0;
                        int row2col1Int = 0;
                        int row2col2Int = 0;

                        try {
                            row1col1Int = Integer.parseInt(row1col1);
                            row1col2Int = Integer.parseInt(row1col2);
                            row2col1Int = Integer.parseInt(row2col1);
                            row2col2Int = Integer.parseInt(row2col2);

                            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
                            intent.putExtra("row1col1", row1col1);
                            intent.putExtra("row1col2", row1col2);
                            intent.putExtra("row2col1", row2col1);
                            intent.putExtra("row2col2", row2col2);
                            startActivity(intent);

                        } catch (NumberFormatException e) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Only numbers please!", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                }

            }
        });

        Intent serviceIntent = new Intent(this, PracticalTest01Var07Service.class);
        startService(serviceIntent);

        broadcastReceiver = new MyBroadcastReceiver();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        row1col1 = row1Collumn1EditText.getText().toString();
        outState.putString("row1col1", row1col1);

        row1col2 = row1Collumn2EditText.getText().toString();
        outState.putString("row1col2", row1col2);

        row2col1 = row2Collumn1EditText.getText().toString();
        outState.putString("row2col1", row2col1);

        row2col2 = row2Collumn2EditText.getText().toString();
        outState.putString("row2col2", row2col2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ro.pub.cs.systems.eim.practicaltest01var07");
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(broadcastReceiver);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, PracticalTest01Var07Service.class));
        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        row1col1 = savedInstanceState.getString("row1col1");
        if (row1col1 != null) {
            row1Collumn1EditText.setText(row1col1);
        }

        row1col2 = savedInstanceState.getString("row1col2");
        if (row1col2 != null) {
            row1Collumn2EditText.setText(row1col2);
        }

        row2col1 = savedInstanceState.getString("row2col1");
        if (row2col1 != null) {
            row2Collumn1EditText.setText(row2col1);
        }

        row2col2 = savedInstanceState.getString("row2col2");
        if (row2col2 != null) {
            row2Collumn2EditText.setText(row2col2);
        }
    }

    private class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            row1col1 = intent.getStringExtra("row1col1");
            row1col2 = intent.getStringExtra("row1col2");
            row2col1 = intent.getStringExtra("row2col1");
            row2col2 = intent.getStringExtra("row2col2");

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
        }
    }
}