package com.daniel.dao;

import com.daniel.model.Barang;
import com.daniel.model.Penjualan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.daniel.util.DbUtil;

public class PenjualanDao {

	private Connection connection;

	public PenjualanDao() {
		connection = DbUtil.getConnection();
	}
        
        public void addPenjualan(Penjualan penjualan) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into penjualan(tgl_faktur,nama_konsumen,kode_barang,jumlah,harga_satuan,harga_total) values (?, ?, ?, ? ,?,?)");
                        preparedStatement.setDate(1, new java.sql.Date(penjualan.getTglFaktur().getTime()));
                        preparedStatement.setString(2, penjualan.getNamaKonsumen());
                        preparedStatement.setInt(3, penjualan.getKodeBarang());
                        preparedStatement.setInt(4, penjualan.getJumlah());
                        preparedStatement.setInt(5, penjualan.getHargaSatuan());
                        preparedStatement.setInt(6, penjualan.getHargaTotal());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
        	
	public Barang getBarangBykode_barang(int kodeBarang) {
		Barang barang = new Barang();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from barang where kode_barang=?");
			preparedStatement.setInt(1, kodeBarang);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				barang.setKodeBarang(rs.getInt("kode_barang"));
                                barang.setNamaBarang(rs.getString("nama_barang"));
                                barang.setHargaJual(rs.getInt("harga_jual"));
                                barang.setHargaBeli(rs.getInt("harga_beli"));
                                barang.setSatuan(rs.getInt("satuan"));
                                barang.setKategori(rs.getString("kategori"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return barang;
	}
}
