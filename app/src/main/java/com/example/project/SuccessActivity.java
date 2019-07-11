package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SuccessActivity extends AppCompatActivity {
	TextView tvUsername;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_success);
		tvUsername = findViewById(R.id.tv_nama_user);
		
		Bundle extra = getIntent().getExtras();
		
		if (extra.getString("data_username") != null) {
			tvUsername.setText(extra.getString("data_username"));
		} else {
			tvUsername.setText("Terjadi kesalahan");
		}
	}
}
