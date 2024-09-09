package com.eergun.databases;

import com.eergun.entities.Futbolcu;
import static com.eergun.utility.Constants.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FutbolcuDb implements ICrud<Futbolcu> {
	DatabaseHelper dbHelper;
	String sql;
	{
		dbHelper = DatabaseHelper.getInstance();
	}
	@Override
	public void add(Futbolcu futbolcu) {
		sql = "INSERT INTO " + tblFutbolcular + "(ad, soyad, yetenek_puani, bütçe, takim_id) VALUES " +
				"('%s', '%s', %d, %d, %d)".formatted(futbolcu.getAd(), futbolcu.getSoyad(), futbolcu.getYetenekPuani(),
				futbolcu.getButce(), futbolcu.getTakimId());
		try {
			dbHelper.executeUpdate(sql);
		}
		catch (SQLException e) {
			System.out.println("futbolcu eklenemedi! " + e.getMessage());
		}
	}
	
	@Override
	public void update(Futbolcu futbolcu) {
		sql = "UPDATE " + tblFutbolcular + (" SET ad = '%s', soyad = '%s', yetenek_puani = %d, bütçe = %d, takim_id = " +
				"%s WHERE id = %d ").formatted(futbolcu.getAd(), futbolcu.getSoyad(), futbolcu.getYetenekPuani(),
		                                       futbolcu.getButce(), futbolcu.getTakimId(), futbolcu.getId());
	}
	
	@Override
	public void delete(int id) {
		sql = "DELETE FROM " + tblFutbolcular + " WHERE id = %d".formatted(id);
		
		try {
			dbHelper.executeUpdate(sql);
		}
		catch (SQLException e) {
			System.out.println("silemedim :( " + e.getMessage());
		}
	}
	
	
	@Override
	public Optional<Futbolcu> findById(int id) {
		sql = "SELECT * FROM " + tblFutbolcular + " WHERE id = %s".formatted(id);
		
		try {
			Optional<ResultSet> resultSet = dbHelper.executeQuery(sql);
			if (resultSet.isPresent()) {
				Futbolcu futbolcu = new Futbolcu();
				futbolcu.setId(id);
				futbolcu.setAd(resultSet.get().getString("ad"));
				futbolcu.setSoyad(resultSet.get().getString("soyad"));
				futbolcu.setState(resultSet.get().getInt("state"));
				futbolcu.setTakimId(resultSet.get().getInt("takim_id"));
				
				return Optional.of(futbolcu);
			}
			else return Optional.empty();
		}
		catch (SQLException e) {
			System.out.println("bulamadik .s " + e.getMessage());
			return Optional.empty();
		}
		
	}
	
	@Override
	public List<Futbolcu> findAll() {
		sql = "SELECT * FROM " + tblFutbolcular;
		List<Futbolcu> futbolcular = new ArrayList<>();
		
		try {
			Optional<ResultSet> resultSet = dbHelper.executeQuery(sql);
			while (resultSet.isPresent()) {
				Futbolcu futbolcu = new Futbolcu();
				futbolcu.setId(resultSet.get().getInt("id"));
				futbolcu.setAd(resultSet.get().getString("ad"));
				futbolcu.setSoyad(resultSet.get().getString("soyad"));
				futbolcu.setState(resultSet.get().getInt("state"));
				futbolcu.setTakimId(resultSet.get().getInt("takim_id"));
				
				futbolcular.add(futbolcu);
			}
		}
		catch (SQLException e) {
			System.out.println("bulamadik .s " + e.getMessage());
		}
		return futbolcular;
	}
	
	@Override
	public void softDelete(int id) {
		Optional<Futbolcu> byId = findById(id);
		byId.ifPresent(futbolcu -> {
			futbolcu.setState(0);
			update(futbolcu);
		});
	}
}