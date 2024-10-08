import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private StringBuilder input = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        input.append(button.getText().toString());
        updateResult();
    }

    private void updateResult() {
        resultTextView.setText(input.toString());
    }

    public void onClearButtonClick(View view) {
        input.setLength(0);
        updateResult();
    }

    public void onCalculateButtonClick(View view) {
        try {
            double result

another code:
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/resultTextView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:layout_marginBottom="16dp"
        android:gravity="end"
        android:textSize="24sp" />

    <!-- Buttons for digits and operations -->

</RelativeLayout>
