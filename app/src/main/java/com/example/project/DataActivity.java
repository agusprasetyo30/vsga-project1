package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.project.adapters.DataSmaAdapter;
import com.example.project.adapters.DataSmkAdapter;
import com.example.project.models.DataSma;
import com.example.project.models.DataSmk;

import java.util.ArrayList;
import java.util.List;

public class DataActivity extends AppCompatActivity implements DataSmkAdapter.OnSmkClickListener, DataSmaAdapter.OnSmaClickListener {
	// Variabel untuk SMK
	public RecyclerView rvSmk;
	public DataSmkAdapter dataSmkAdapter;
	public RecyclerView.LayoutManager layoutManager1;
	public List<DataSmk> listSmk = new ArrayList<>();
	
	// Variabel untuk SMA
	public RecyclerView rvSma;
	public DataSmaAdapter dataSmaAdapter;
	public RecyclerView.LayoutManager layoutManager2;
	public List<DataSma> listSma = new ArrayList<>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data);
		rvSmk = findViewById(R.id.rv_smk);
		rvSma = findViewById(R.id.rv_sma);
		
		/* SMK */
		
		// Menginisialsasi arraylist agar bisa diisi
		listSmk = new ArrayList<>();
		
		// Mengisi list/data SMK
		listSmk.add(new DataSmk("SMK Taruna Jaya Prawira Tuban", R.drawable.smk_tjp_logo));
		listSmk.add(new DataSmk("SMKN 1 Tuban", R.drawable.smk_1_logo));
		listSmk.add(new DataSmk("SMKN 2 Tuban", R.drawable.smk_2_logo));
		listSmk.add(new DataSmk("SMKN 3 Tuban", R.drawable.smk_3_logo));
		listSmk.add(new DataSmk("SMKN Palang", R.drawable.smk_palang_logo));
		listSmk.add(new DataSmk("SMKN Rengel", R.drawable.smk_rengel_logo));
		listSmk.add(new DataSmk("SMKN Tambakboyo", R.drawable.smk_tambakboyo_logo));
		
		// Create adapter untuk SMK
		dataSmkAdapter = new DataSmkAdapter(listSmk);
		dataSmkAdapter.setListener(this);
		// Melampirkan adapter ke recycle view ke item
		rvSmk.setAdapter(dataSmkAdapter);
		// Menambahkan manajer position/letak posisi pada item
		layoutManager1 = new GridLayoutManager(this, 1);
		((GridLayoutManager) layoutManager1).setOrientation(LinearLayout.HORIZONTAL);
		rvSmk.setLayoutManager(layoutManager1);
		rvSmk.setHasFixedSize(true);
		
		/* SMA */
		
		// Menginisialsasi arraylist agar bisa diisi
		listSma = new ArrayList<>();
		
		// Mengisi list/data SMA
		listSma.add(new DataSma("SMAN 1 Tuban", R.drawable.sma_1_logo));
		listSma.add(new DataSma("SMAN 2 Tuban", R.drawable.sma_2_logo));
		listSma.add(new DataSma("SMAN 3 Tuban", R.drawable.sma_3_logo));
		listSma.add(new DataSma("SMAN 4 Tuban", R.drawable.sma_4_logo));
		listSma.add(new DataSma("SMAN 5 Tuban", R.drawable.sma_5_logo));
		listSma.add(new DataSma("SMAN Singgahan", R.drawable.sma_singgahan_logo));
		listSma.add(new DataSma("SMAN 1 Rengel", R.drawable.sma_rengel_logo));
		
		// Create adapter untuk SMA
		dataSmaAdapter = new DataSmaAdapter(listSma);
		dataSmaAdapter.setListener(this);
		// Melampirkan adapter ke recycle view ke item
		rvSma.setAdapter(dataSmaAdapter);
		// Menambahkan manajer position/letak posisi pada item
		layoutManager2 = new GridLayoutManager(this, 1);
		((GridLayoutManager) layoutManager2).setOrientation(LinearLayout.HORIZONTAL);
		rvSma.setLayoutManager(layoutManager2);
		rvSma.setHasFixedSize(true);
	}
	
	@Override
	public void onClickSmk(View view, int position) {
		DataSmk dataSmk = listSmk.get(position);
		Toast.makeText(this, dataSmk.getNamaSekolah(), Toast.LENGTH_LONG).show();
	}
	
	@Override
	public void onClickSma(View view, int position) {
		DataSma dataSma = listSma.get(position);
		Toast.makeText(this, dataSma.getNamaSekolah(), Toast.LENGTH_LONG).show();
	}
}
