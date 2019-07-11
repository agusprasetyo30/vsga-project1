package com.example.project.models;

public class DataSma {
	private String namaSekolah;
	private int foto;
	
	public DataSma() {
	}
	
	public DataSma(String namaSekolah, int foto) {
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
