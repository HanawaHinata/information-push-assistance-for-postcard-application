package com.happybirthday.manager;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.view.*;
import android.widget.*;
import android.net.*;
import java.text.*;

public class dialogact extends Activity{
	private final Activity me = this;
	/** Called when the activity is first created. */
    @Override



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        Button maintoa1btn = (Button)findViewById(R.id.okbtn);
        Button maintoa2btn = (Button)findViewById(R.id.nobtn);
       

        maintoa1btn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					
					Intent intt = new Intent(me, downloadact.class);
					startActivity(intt);
					me.finish();
				}
			});

        maintoa2btn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					
					Intent intent8 = new Intent(Intent.ACTION_MAIN);
					intent8.addCategory(Intent.CATEGORY_HOME);
					startActivity(intent8);
					System.exit(0);
				}
			});


        }

	
	}
