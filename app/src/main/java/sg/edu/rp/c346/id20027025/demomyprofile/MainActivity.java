package sg.edu.rp.c346.id20027025.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etTextName);
        etGPA = findViewById(R.id.etTextGPA);

    }
    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String name = prefs.getString("name", "John Doe");
        float gpa = prefs.getFloat("gpa", 4.0f);
        etName.setText(name);
        etGPA.setText(gpa + "");
    }

    @Override
    protected void onPause() {
        super.onPause();

        String name = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("name", name);
        prefEdit.putFloat("gpa", gpa);

        prefEdit.commit();
    }
}