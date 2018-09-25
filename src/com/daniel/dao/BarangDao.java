package com.daniel.dao;

import com.daniel.model.Barang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.daniel.util.DbUtil;

public class BarangDao {

	private Connection connection;

	public BarangDao() {
		connection = DbUtil.getConnection();
	}
        
        public void addBarang(Barang barang) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into barang(nama_barang,harga_jual,harga_beli,satuan,kategori) values (?, ?, ?, ? ,?)");
                        preparedStatement.setString(1, barang.getNamaBarang());
                        preparedStatement.setInt(2, barang.getHargaJual());
                        preparedStatement.setInt(3, barang.getHargaBeli());
                        preparedStatement.setInt(4, barang.getSatuan());
                        preparedStatement.setString(5, barang.getKategori());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
        
        public void deleteBarang(int kodeBarang) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from barang where kode_barang=?");
			// Parameters start with 1
			preparedStatement.setInt(1, kodeBarang);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
		}
	}
	
        public void updateBarang(Barang barang) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update barang set nama_barang=?, harga_jual=?, harga_beli=?, satuan=?, kategori=?"+
							"where kode_barang=?");
			// Parameters start with 1
			preparedStatement.setString(1,barang.getNamaBarang());
                        preparedStatement.setInt(2,barang.getHargaJual());
                        preparedStatement.setInt(3,barang.getHargaBeli());
                        preparedStatement.setInt(4,barang.getSatuan());
                        preparedStatement.setString(5,barang.getKategori());
                        preparedStatement.setInt(6,barang.getKodeBarang());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Barang> getAllBarangs() {
		List<Barang> barangs = new ArrayList<Barang>();
		
                try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from barang");
			while (rs.next()) {
				Barang barang = new Barang();
				barang.setKodeBarang(rs.getInt("kode_barang"));
                                barang.setNamaBarang(rs.getString("nama_barang"));
                                barang.setHargaJual(rs.getInt("harga_jual"));
                                barang.setHargaBeli(rs.getInt("harga_beli"));
                                barang.setSatuan(rs.getInt("satuan"));
                                barang.setKategori(rs.getString("kategori"));
				
                                barangs.add(barang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return barangs;
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
