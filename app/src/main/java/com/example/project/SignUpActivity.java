package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
	EditText etName, etUsername, etPassword, etConfirmPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		setTitle("Registrasi");
		
		etName = findViewById(R.id.et_reg_name);
		etUsername = findViewById(R.id.et_reg_username);
		etPassword = findViewById(R.id.et_reg_password);
		etConfirmPassword = findViewById(R.id.et_reg_confirm_password);
	}
	
	public void clickRegister(View view) {
		//  jika username & password kosong
		if (TextUtils.isEmpty(etUsername.getText().toString().trim()) &&
			TextUtils.isEmpty(etName.getText().toString().trim()) &&
		   TextUtils.isEmpty(etPassword.getText().toString().trim()) &&
			TextUtils.isEmpty(etConfirmPassword.getText().toString().trim()))
		{
			Toast.makeText(SignUpActivity.this, "Data register tidak boleh kosong", Toast.LENGTH_LONG).show();
			etName.requestFocus();
			
		} else if (TextUtils.isEmpty(etName.getText().toString().trim())) {
			Toast.makeText(SignUpActivity.this, "Nama harus diisi!", Toast.LENGTH_LONG).show();
			etName.requestFocus();
			
		} else if (TextUtils.isEmpty(etUsername.getText().toString().trim())) {
			Toast.makeText(SignUpActivity.this, "Username harus diisi!", Toast.LENGTH_LONG).show();
			etUsername.requestFocus();
			
		} else if (TextUtils.isEmpty(etPassword.getText().toString().trim())) {
			Toast.makeText(SignUpActivity.this, "Password tidak boleh kosong", Toast.LENGTH_LONG).show();
			etPassword.requestFocus();
			
		}  else if (TextUtils.isEmpty(etConfirmPassword.getText().toString().trim())) {
			Toast.makeText(SignUpActivity.this, "Konfirmasi password tidak boleh kosong", Toast.LENGTH_LONG).show();
			etPassword.requestFocus();
			
		} else if (!etPassword.getText().toString().equals(etConfirmPassword.getText().toString())) {
			Toast.makeText(SignUpActivity.this, "Password yang anda masukan tidak sesuai", Toast.LENGTH_LONG).show();
			etPassword.setText("");
			etConfirmPassword.setText("");
			etPassword.requestFocus();
		} else {
			Intent intent = new Intent(SignUpActivity.this, SuccessActivity.class);
			intent.putExtra("data_username", etUsername.getText().toString());
			startActivity(intent);
		}
		
	}
}
