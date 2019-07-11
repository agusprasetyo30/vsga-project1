package com.example.project.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.models.DataSma;
import com.example.project.models.DataSmk;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DataSmaAdapter extends RecyclerView.Adapter<DataSmaAdapter.DataSmaViewHolder> {
	
	List<DataSma> listDataSma;
	
	// Konstruktor
	public DataSmaAdapter(List<DataSma> listDataSma) {
		this.listDataSma = listDataSma;
	}
	
	// variabel untuk menginisialisasi interface
	private OnSmaClickListener listener;
	
	// Membuat listener
	public interface OnSmaClickListener {
		public void onClickSma(View view, int position);
	}
	
	// setter untuk listener/untuk mengisi listener
	public void setListener(OnSmaClickListener listener) {
		this.listener = listener;
	}
	
	@NonNull
	@Override
	public DataSmaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
		View view = LayoutInflater
						.from(viewGroup.getContext())
						.inflate(R.layout.cardview_sekolah_item, viewGroup, false);
		
		DataSmaViewHolder viewHolder = new DataSmaViewHolder(view);
		return viewHolder;
	}
	
	@Override
	public void onBindViewHolder(@NonNull DataSmaViewHolder dataSmaViewHolder, int position) {
		DataSma item = listDataSma.get(position);
		dataSmaViewHolder.tv_nama_sekolah.setText(item.getNamaSekolah());
		
		Picasso.get().cancelRequest(dataSmaViewHolder.img_logo_sekolah);
		dataSmaViewHolder.img_logo_sekolah.setImageResource(item.getFoto());
	}
	
	@Override
	public int getItemCount() {
		return listDataSma.size();
	}
	
	public class DataSmaViewHolder extends RecyclerView.ViewHolder {
		public ImageView img_logo_sekolah;
		public TextView tv_nama_sekolah;
		
		public DataSmaViewHolder(@NonNull View itemView) {
			super(itemView);
			img_logo_sekolah = itemView.findViewById(R.id.img_logo_sekolah);
			tv_nama_sekolah = itemView.findViewById(R.id.tv_nama_sekolah);
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					listener.onClickSma(view, getAdapterPosition());
				}
			});
		}
	}
}
