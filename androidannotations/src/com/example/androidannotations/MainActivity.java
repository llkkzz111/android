package com.example.androidannotations;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//http://www.csdn123.com/html/topnews201408/29/729.htm
//https://github.com/excilys/androidannotations/wiki/AvailableAnnotations
@EActivity(R.layout.main)
public class MainActivity extends Activity{

	@ViewById(R.id.text)
	TextView text;
	@ViewById(R.id.username)
	EditText username;
	@ViewById(R.id.password)
	EditText password;
	@ViewById(R.id.but_id)
	Button  but_id;
	
	@Click(R.id.but_id)
	void login(){
		Toast.makeText(MainActivity.this,	"登录成功	", Toast.LENGTH_LONG).show();
		text.setText(username.getText().toString()+""+password.getText().toString());
	}
	
}
