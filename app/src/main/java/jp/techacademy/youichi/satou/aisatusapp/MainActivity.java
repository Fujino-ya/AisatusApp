package jp.techacademy.youichi.satou.aisatusapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.button1){
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker view, int houerOfDay, int minute){
                        if(!(houerOfDay <= 1) && !(houerOfDay >=10)) {
                            mTextView.setText("「おはよう」");
                        } else if (!(houerOfDay <= 9) && !(houerOfDay >= 18)){
                            mTextView.setText("「こんにちは」");
                        } else {
                            mTextView.setText("「こんばんは」");
                        }
                    }
                },
                12,
                25,
                true);
        timePickerDialog.show();
    }
}
