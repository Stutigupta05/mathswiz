package com.shubhanshu.mathwizard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HSActivity extends AppCompatActivity {
TextView txteasy,txtmeadium,txthard;
    int SCORE,LEVEL;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hs);
        pref= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        txteasy=(TextView)findViewById(R.id.easy);
        txtmeadium=(TextView)findViewById(R.id.meadium);
        txthard=(TextView)findViewById(R.id.hard);
        SCORE = (pref.getInt("KEY_SCORE",0));
        LEVEL =(pref.getInt("KEY_LEVEL",0));
        SharedPreferences.Editor editor = pref.edit();
        if(LEVEL == 1)
        {txteasy.setText(""+SCORE);
            editor.putInt("KEY_SCORE",Integer.parseInt(txteasy.getText().toString()));
        }else if(LEVEL == 10 )
        {txtmeadium.setText(""+SCORE);
            editor.putInt("KEY_SCORE",Integer.parseInt(txtmeadium.getText().toString()));
        }else {
            txthard.setText(""+SCORE);
            editor.putInt("KEY_SCORE",Integer.parseInt(txthard.getText().toString()));
        }

        editor.commit();

    }
    @Override
    public void onBackPressed() {
        SharedPreferences.Editor editor = pref.edit();
        if(LEVEL == 1)
        {txteasy.setText(""+SCORE);
            editor.putInt("KEY_SCORE",Integer.parseInt(txteasy.getText().toString()));
        }else if(LEVEL == 10 )
        {txtmeadium.setText(""+SCORE);
            editor.putInt("KEY_SCORE",Integer.parseInt(txtmeadium.getText().toString()));
        }else {
            txthard.setText(""+SCORE);
            editor.putInt("KEY_SCORE",Integer.parseInt(txthard.getText().toString()));
        }
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

        editor.commit();

        super.onBackPressed();
    }
}
