package sg.edu.np.mad.mad19ct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  EditText editText = findViewById(R.id.editTextDuration);
                  Intent i = new Intent(MainActivity.this, TimeActivity.class);
                  i.putExtra("duration", Integer.parseInt( editText.getText().toString() ) );
                  startActivity(i);
            }
        });
    }
}