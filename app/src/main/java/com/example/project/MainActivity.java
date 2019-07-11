package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void clickLoginButton(View view) {
		Intent i = new Intent(MainActivity.this, LoginActivity.class);
		startActivity(i);
	}
	
	public void clickDaftarButton(View view) {
		Intent i = new Intent(MainActivity.this, DataActivity.class);
		startActivity(i);
	}
}
