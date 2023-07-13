package sg.edu.rp.c346.id21027127.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);

    }

    @Override
    protected void onPause() {
        super.onPause();

        // step 1a: get the user input from the EditText and store it in a variable
        String strName = etName.getText().toString();
        String strGPA = etGPA.getText().toString();
        float gpa = Float.valueOf(strGPA);
        // step 1b: obtain the SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        // step 1c: create a SharedPreferences  Editor by calling edit()
        SharedPreferences.Editor prefEdit = prefs.edit();
        // step 1d: set a key-value pair in the editor
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);
        // step 1e: call commit() to save the changes made to the SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // step 2a: obtain the SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        // step 3a: retrieve the saved data from SharedPreferences
        // with a default value if no matching data
        String name = prefs.getString("name", "No greetings name");
        float gpa = prefs.getFloat("gpa", 1);
        Toast toast = Toast.makeText(MainActivity.this, name + ", " + gpa, Toast.LENGTH_LONG);
        toast.show();
    }
}