package com.shubhanshu.mathwizard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
TextView txtview;
    RadioGroup rdgroup;
    Random r = new Random();
    int min,max,i=1,j=4,x,score =0,ques = 10,i1,i2,result;
    RadioButton btr1,btr2,btr3,btr4;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        txtview=(TextView)findViewById(R.id.textView);
        rdgroup=(RadioGroup)findViewById(R.id.groupbutton);
        btr1=(RadioButton)findViewById(R.id.rbutton1);
        btr2=(RadioButton)findViewById(R.id.rbutton2);
        btr3=(RadioButton)findViewById(R.id.rbutton3);
        btr4=(RadioButton)findViewById(R.id.rbutton4);
        pref= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        getques();
        newques();
    }
    public void getques(){
        min = getIntent().getIntExtra("min", 0);
        max = getIntent().getIntExtra("max", 0);
        i1 = r.nextInt(max-min + 1)+ min;
        i2 = r.nextInt(max-min + 1)+ min;
        x= r.nextInt(j-i + 1)+ i;
        txtview.setText(i1+"*"+i2+"="+"?");
        result = i1*i2;
        btr1.setText(""+(r.nextInt(max-min + 1)+ min*r.nextInt(max-min + 1)+ min));
        btr2.setText(""+(r.nextInt(max-min + 1)+ min*r.nextInt(max-min + 1)+ min));
        btr3.setText(""+(r.nextInt(max-min + 1)+ min*r.nextInt(max-min + 1)+ min));
        btr4.setText(""+(r.nextInt(max-min + 1)+ min*r.nextInt(max-min + 1)+ min));
        txtview.setText(i1+"*"+i2+"="+"?");
        switch(x)
        {
            case 1: btr1.setText(""+result);
                break;
            case 2: btr2.setText(""+result);
                break;
            case 3: btr3.setText(""+result);
                break;
            case 4: btr4.setText(""+result);
                break;
            default:
                break;
        }
    }
    public void newques()
    {
        rdgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId)
            {btr1.setChecked(false);
                btr2.setChecked(false);
                btr3.setChecked(false);
                btr4.setChecked(false);
                String answer = ((RadioButton)findViewById(checkedId)).getText().toString();
                if(answer.equals(String.valueOf(result)))
                {
                    score = score + 5;
                    Toast.makeText(GameActivity.this, "CORRECT OPTION",Toast.LENGTH_SHORT).show();
                }else
                {
                    score = score - 1;
                    Toast.makeText(GameActivity.this, "INCORRET OPTION",Toast.LENGTH_SHORT).show();
                }
                if(ques == 0)
                {
                    Toast.makeText(GameActivity.this, "ques complete",Toast.LENGTH_LONG).show();
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("KEY_SCORE",score);
                    editor.putInt("KEY_LEVEL",min);
                    editor.commit();
                    Intent intent = new Intent(getApplicationContext(), HSActivity.class);
                    startActivity(intent);
                }else
                {
                    getques();
                    ques--;
                }
            }

    });
    }
}
