package sg.edu.np.mad.mad19ct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TimeActivity extends AppCompatActivity {
    TextView p1;
    TextView p2;
    TextView cur;
    boolean curP1;
    CountDownTimer cdt;
    int p1Timer;
    int p2Timer;

    ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        Intent i = getIntent();
        p1 = findViewById(R.id.txtP1Duration);
        p2 = findViewById(R.id.txtP2Duration);
        p1Timer = p2Timer = i.getIntExtra("duration",0);
        p1.setText(""+ p1Timer);
        p2.setText(""+ p2Timer);


        cur = p1;
        curP1 = true;
        startTimer(p1Timer);

        RecyclerView  rv = findViewById(R.id.rv);
        RemarksAdapter adapter = new RemarksAdapter(this, data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);

        Button btn = findViewById(R.id.btnNext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cdt != null)
                    cdt.cancel();

                //need to add to recyclerView

                //toggling
                if(curP1)
                {
                    //currently is player1, setting to player2
                    data.add("Player 1 left " + p1Timer + " sec");
                    cur = p2;
                    curP1 = false;
                }
                else
                {
                    data.add("Player 2 left " + p2Timer + " sec");
                    cur = p1;
                    curP1 = true;
                }

                adapter.notifyDataSetChanged();

                //after toggled, start the corresponding timer
                if(curP1)
                    startTimer(p1Timer);
                else
                    startTimer(p2Timer);
            }
        });


    }

    /**
     * starts cdt, shows toast
     * @param duration
     */
    void startTimer (int duration)
    {
        cdt = new CountDownTimer(duration*1000, 1000) {

            @Override
            public void onTick(long l) {
                //this is to update the UI
                cur.setText("" + l/1000);
                if(curP1)
                {
                    p1Timer = (int)(l/1000);
                }
                else
                {
                    p2Timer = (int)(l/1000);
                }
            }

            @Override
            public void onFinish() {
                if(curP1)
                    Toast.makeText(TimeActivity.this, "Player 1's Timer runs out", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(TimeActivity.this, "Player 2's Timer runs out", Toast.LENGTH_LONG).show();
            }
        };
        cdt.start();
    }
}