package com.example.xposedlogin;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 登陆login
 * @author dream
 *
 */
public class LoginActivity extends Activity implements OnClickListener {

	
		private EditText username;
		private EditText password;
		private Button login_id;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.login_layout);
			
			username = (EditText)findViewById(R.id.username);
			password = (EditText)findViewById(R.id.password);
			login_id = (Button)findViewById(R.id.login_id);
			username.setOnClickListener(this);
			password.setOnClickListener(this);
			login_id.setOnClickListener(this);
		}
		
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.login_id:
				login(username.getText().toString(), password.getText().toString());
				break;
		

			default:
				break;
			}
		}
		
		/**
		 * 登陆
		 * @param username
		 * @param password
		 */
		public void login(String username,String password){
//			Toast.makeText(this, "username"+username+"password"+password, Toast.LENGTH_LONG).show();
//			if(username == null || password == null){
////				Toast.makeText(this, "登陆失败", Toast.LENGTH_LONG).show();
//				throw new NullPointerException("密码和用户不能为空");
//				
//			}else{
				if(username.equals("james") && password.equals("123456")){
//					Toast.makeText(this, "登陆成功", Toast.LENGTH_LONG).show();
					checkLogin(true);
				}else{
//					Toast.makeText(this, "登陆失败", Toast.LENGTH_LONG).show();
					checkLogin(false);
				}
				
//			}
			
		}
		
		public void checkLogin(boolean isLogin){
			if(isLogin){
				Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
				
			}else{
				Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_LONG).show();
			}
		}
}
