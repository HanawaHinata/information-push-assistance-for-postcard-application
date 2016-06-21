package com.happybirthday.manager;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.*;
import android.widget.*;
import android.view.View.*;

public class codeact extends Activity {
	private EditText text;
	private Builder builder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView (R.layout.code);
		Button button = (Button) findViewById(R.id.button);   //声明按钮
		text = (EditText) findViewById(R.id.codeText);        //声明文本框
		TextView nocode= (TextView) findViewById(R.id.nocode);//声明文本
		builder = new AlertDialog.Builder(this);              //声明对话框权限
		button.setOnClickListener(new View.OnClickListener() {
				private Intent intent;
				@Override
				public void onClick(View arg0) {
					String number = text.getText().toString();
					char ch[] = number.toCharArray();
					int sum=0;
					for(int i=0;i<ch.length;i++){
						sum += Integer.parseInt(ch[i] + "");
					}
					if(sum==36){
						
						Intent intent=new Intent();
						intent.setClass(codeact.this, MainActivity.class);
						startActivity(intent);
					             }
					else{
						
						builder.setTitle("输入错误");
						builder.setMessage("您所输入的身份码有误，请检查您输入的身份码，然后再试一次。");
						builder.create().show();
					    }
				
				}
			});
		nocode.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
				
					builder.setTitle("获取身份码");
					builder.setMessage("本软件的验证码封装于您从实体商店购买的软件存储介质(例如光盘、USB存储盘等)的外包装上，它由11位以内的阿拉伯数字组成。如果您是从其他地方获得的本软件，您应该立即卸载本软件。");
					builder.create().show();
				}
			});
	}
}
