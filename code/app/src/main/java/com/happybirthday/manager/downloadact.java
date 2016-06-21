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
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.Menu;
import android.widget.*;
import android.content.*;
import android.net.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.*;
import android.widget.*;
import android.net.*;
import java.text.*;
import java.io.*;

public class downloadact extends Activity {
	public static final String ROOT_DIR = "/mnt/sdcard/数据包";
	private final String TAG="前端下载页面";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView (R.layout.download);							   //定位布局文件
		Button button = (Button) findViewById(R.id.openFailbtn);   //声明按钮

		mopo();
		showDownLoadDialog();


		button.setOnClickListener(new View.OnClickListener() {
				private Intent intent;
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(Intent.ACTION_VIEW);  
					intent.setDataAndType(Uri.parse("file://" + "/sdcard/数据包/update.apk"), "application/vnd.android.package-archive");  
					startActivity(intent);  
					Toast toast = Toast.makeText(downloadact.this, "安装程序已被成功触发！", Toast.LENGTH_SHORT); 
					toast.show();
				}
			});


	}




	/**
     * 检测储存卡是否安装
     */
    private boolean mopo() {
		String status = Environment.getExternalStorageState();
		if (status.equals(Environment.MEDIA_MOUNTED)) {
			file();
			return true;
		} else {
			new AlertDialog.Builder(downloadact.this).setTitle("提示:")
				.setMessage("非常抱歉！\n您不能正常使用本软件，可能是以下原因所导致。\n⒈未检测到你手机里的存储卡设备。\n⒉软件经过其他人所修改导致安装文件时出错。\n\n按确定退出本软件！ ").setIcon(R.drawable.icon)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						finish();
					}

				}).show();
		}

		return false;
	}



	/**
     * 创建文件夹
     */
	private void file() {
		File destDir = new File(ROOT_DIR);
		if (!destDir.exists()) {
			destDir.mkdirs();
		}
	}


	private void showDownLoadDialog(){
		new AlertDialog.Builder(this).setTitle("下载确认")


			.setMessage("“生日贺卡信息推送辅助程序”正在请求存储卡读写权限以及网络连接权限，是否授权？\n请注意，授予未知应用连接网络权限后，您必须确保您的网络不受流量限制。\n另外，下载过程中请不要关闭对话框。如果不小心关闭了，请返回后重新下载数据包。\n预计大小：216M")
			.setPositiveButton("是", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d(TAG, "onClick 1 = "+which);
					doDownLoadWork();
				}
			})
			.setNegativeButton("否", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d(TAG, "onClick 2 = "+which);
				}
			})


			.show();
	}

	public void showUnzipDialog(){
		new AlertDialog.Builder(this).setTitle("授权管理")
			//AlertDialog.setCanceledOnTouchOutside(false);
			.setMessage("“生日贺卡信息推送辅助程序”正在请求存储卡文件删改权限。\n附加说明:程序需要授予该权限以解压数据包。另外，解压执行过程中请不要关闭对话框。如果不小心关闭了，请返回后重新解压数据包。")
			.setPositiveButton("是", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d(TAG, "onClick 1 = "+which);
					doZipExtractorWork();
				}
			})
			.setNegativeButton("否", new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.d(TAG, "onClick 2 = "+which);
				}
			})
			.show();
	}


	public void doZipExtractorWork(){
		ZipExtractorTask task = new ZipExtractorTask("/mnt/sdcard/数据包/4BXde1&type=Postcard_build_24182.zip", "/mnt/sdcard/数据包/", this, true);
		task.execute();
		//return true;
	}


	private void doDownLoadWork(){
		DownLoaderTask task = new DownLoaderTask("http://pan.diemoe.net/d/4BXde1&type=Postcard_build_24182.zip", "/mnt/sdcard/数据包/", this);
		task.execute();
	}	
}
