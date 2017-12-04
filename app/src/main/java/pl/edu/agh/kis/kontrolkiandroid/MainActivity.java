package pl.edu.agh.kis.kontrolkiandroid;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.text.Layout;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_main);
                if (isChecked) {
                    linearLayout.setBackgroundColor(Color.argb(255, 255, 255, 255));
                    //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    linearLayout.setBackgroundColor(Color.argb(155, 255, 215, 0));//105,128,135
                    //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.wojewodztwa_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.wojewodztwa_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

    public void writeData(View view) {
        // Do something in response to button click
        EditText editText1= (EditText) findViewById(R.id.editText1);
        EditText editText2= (EditText) findViewById(R.id.editText2);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());

        Spinner spinner = (Spinner) findViewById(R.id.wojewodztwa_spinner);

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        String czyStudent;
        if(checkBox.isChecked()) {
            czyStudent = "tak";
        }else {
            czyStudent = "nie";
        }

        if(editText1.getText().toString().trim().equals("")) {
            editText1.setError( "Imię jest wymagane!" );
        }else if(editText2.getText().toString().trim().equals("")){
            editText2.setError( "Nazwisko jest wymagane!" );
        }else {

            String data = "Imię: " + editText1.getText() + "\nNazwisko: " + editText2.getText()
                    + "\nPłeć: " + radioButton.getText()
                    + "\nStudent: " + czyStudent
                    + "\nWojewództwo: " + spinner.getSelectedItem().toString();

            //wyswietlenie danych w tym samym activity na dole
            //TextView textView= (TextView) findViewById(R.id.textView5);
            //textView.setText(data);

            context = getApplicationContext();
            Intent intent = new Intent(context, ResultActivity.class);
            intent.putExtra("data", data);
            startActivity(intent);
        }
    }
}
