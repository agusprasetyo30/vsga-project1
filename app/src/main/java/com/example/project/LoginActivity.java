package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
	private EditText etUsername, etPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		setTitle("Login");
		
		etUsername = findViewById(R.id.et_username);
		etPassword = findViewById(R.id.et_password);
	}
	
	public void clickSignUp(View view) {
			Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
			startActivity(intent);
	}
	
	public void clickLogin(View view) {
		//  jika username & password kosong
		if (TextUtils.isEmpty(etUsername.getText().toString().trim()) &&
			TextUtils.isEmpty(etPassword.getText().toString().trim())) {
			Toast.makeText(LoginActivity.this, "Username/Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
			etUsername.requestFocus();
		} else if (TextUtils.isEmpty(etUsername.getText().toString().trim())) {
			Toast.makeText(LoginActivity.this, "Username tidak boleh kosong", Toast.LENGTH_SHORT).show();
			etUsername.requestFocus();
		} else if (TextUtils.isEmpty(etPassword.getText().toString().trim())) {
			Toast.makeText(LoginActivity.this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
			etPassword.requestFocus();
		} else {
			Intent intent = new Intent(LoginActivity.this, SuccessActivity.class);
			intent.putExtra("data_username", etUsername.getText().toString());
			startActivity(intent);
		}
	}
}
