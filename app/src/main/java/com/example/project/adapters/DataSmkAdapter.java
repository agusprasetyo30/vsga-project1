package com.example.project.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.models.DataSmk;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DataSmkAdapter extends RecyclerView.Adapter<DataSmkAdapter.DataSmkViewHolder> {
	
	List<DataSmk> listDataSmk;
	
	// Konstruktor
	public DataSmkAdapter(List<DataSmk> listDataSmk) {
		this.listDataSmk = listDataSmk;
	}
	
	// variabel untuk menginisialisasi interface
	private OnSmkClickListener listener;
	
	// Membuat listener
	public interface OnSmkClickListener {
		public void onClickSmk(View view, int position);
	}
	
	// setter untuk listener/untuk mengisi listener
	public void setListener(OnSmkClickListener listener) {
		this.listener = listener;
	}
	
	@NonNull
	@Override
	public DataSmkViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
		View view = LayoutInflater
						.from(viewGroup.getContext())
						.inflate(R.layout.cardview_sekolah_item, viewGroup, false);
		
		DataSmkViewHolder viewHolder = new DataSmkViewHolder(view);
		return viewHolder;
	}
	
	@Override
	public void onBindViewHolder(@NonNull DataSmkViewHolder dataSmkViewHolder, int position) {
		DataSmk item = listDataSmk.get(position);
		dataSmkViewHolder.tv_nama_sekolah.setText(item.getNamaSekolah());
		
		Picasso.get().cancelRequest(dataSmkViewHolder.img_logo_sekolah);
		dataSmkViewHolder.img_logo_sekolah.setImageResource(item.getFoto());
	}
	
	@Override
	public int getItemCount() {
		return listDataSmk.size();
	}
	
	public class DataSmkViewHolder extends RecyclerView.ViewHolder {
		public ImageView img_logo_sekolah;
		public TextView tv_nama_sekolah;
		
		public DataSmkViewHolder(@NonNull View itemView) {
			super(itemView);
			img_logo_sekolah = itemView.findViewById(R.id.img_logo_sekolah);
			tv_nama_sekolah = itemView.findViewById(R.id.tv_nama_sekolah);
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					listener.onClickSmk(view, getAdapterPosition());
				}
			});
		}
	}
}
