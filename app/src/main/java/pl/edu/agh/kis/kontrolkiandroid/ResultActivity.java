package pl.edu.agh.kis.kontrolkiandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class ResultActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String data = getIntent().getStringExtra("data");

        TextView textView= (TextView) findViewById(R.id.textView6);
        textView.setText(data);
    }

    public void returnToMain(View view) {
        context = getApplicationContext();
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);
    }
}
