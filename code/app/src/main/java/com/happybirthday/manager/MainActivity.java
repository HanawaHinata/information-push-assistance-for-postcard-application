package com.happybirthday.manager;
//自动跳转
import android.app.Activity;
import android.content.Intent;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.os.Handler;
public class MainActivity extends Activity {
	private final int SPLASH_DISPLAY_LENGHT = 5000; //延时5秒
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		new Handler().postDelayed(new Runnable() {
				public void run(){
					Intent mainIntent = new Intent(MainActivity.this,downloadact.class);
					MainActivity.this.startActivity(mainIntent);
					MainActivity.this.finish();
				}
			}, SPLASH_DISPLAY_LENGHT);
	}
}
