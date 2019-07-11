package com.example.project.models;

public class DataSmk {
	private String namaSekolah;
	private int foto;
	
	public DataSmk() {
	}
	
	public DataSmk(String namaSekolah, int foto) {
		this.namaSekolah = namaSekolah;
		this.foto = foto;
	}
	
	public String getNamaSekolah() {
		return namaSekolah;
	}
	
	public void setNamaSekolah(String namaSekolah) {
		this.namaSekolah = namaSekolah;
	}
	
	public int getFoto() {
		return foto;
	}
	
	public void setFoto(int foto) {
		this.foto = foto;
	}
}
