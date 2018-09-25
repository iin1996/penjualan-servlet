/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daniel.model;

import java.util.Date;

/**
 *
 * @author cahyo
 */
public class Penjualan {
    private int kodeFaktur; //kode_barang => kodeBarang
    private Date tglFaktur;
    private String namaKonsumen;
    private int kodeBarang;
    private int jumlah;
    private int hargaSatuan;
    private int hargaTotal;
    
    public int getKodeFaktur() {
        return kodeFaktur;
    }

    public void setKodeFaktur(int kodeFaktur) {
        this.kodeFaktur = kodeFaktur;
    }

    public Date getTglFaktur() {
        return tglFaktur;
    }

    public void setTglFaktur(Date tglFaktur) {
        this.tglFaktur = tglFaktur;
    }

    public String getNamaKonsumen() {
        return namaKonsumen;
    }

    public void setNamaKonsumen(String namaKonsumen) {
        this.namaKonsumen = namaKonsumen;
    }

    public int getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(int kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(int hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public int getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(int hargaTotal) {
        this.hargaTotal = hargaTotal;
    }
    
}
