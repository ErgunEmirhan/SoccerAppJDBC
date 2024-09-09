package com.eergun.databases;

import com.eergun.entities.Takim;
import static com.eergun.utility.Constants.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TakimDb implements ICrud<Takim> {
	DatabaseHelper dbHelper = DatabaseHelper.getInstance();
	String sql;
	
	@Override
	public void add(Takim obj) {
		sql =
				"INSERT INTO " + tblTakimlar + "(ad, baskan_id, stadyum_id) VALUES ('%s', %d, %d)".formatted(obj.getAd(), obj.getBaskanId(), obj.getStadyumId());
		try {
			dbHelper.executeUpdate(sql);
		}
		catch (SQLException e) {
			System.out.println("maalesef takimi ekleyemedim -_- " + e.getMessage());
		}
	}
	
	public void softDelete(int id) {
		Optional<Takim> byId = findById(id);
		byId.ifPresent(takim -> {
			takim.setState(0);
			update(takim);
		});
	}
	
	@Override
	public void update(Takim obj) {
		sql =
				"UPDATE " + tblTakimlar + (" SET ad = '%s', baskan_id = %d, stadyum_id = %d, state = %d  " +
						"WHERE id = %d").formatted(obj.getAd(), obj.getBaskanId(), obj.getStadyumId(),
				                                   obj.getState(), obj.getId());
		try {
			dbHelper.executeUpdate(sql);
		}
		catch (SQLException e) {
			System.out.println("ne yazik ki guncellemeyi beceremedim :S " + e.getMessage());
		}
	}
	
	@Override
	public void delete(int id) {
		sql = "DELETE FROM " + tblTakimlar + " WHERE id = %d".formatted(id);
		try {
			dbHelper.executeUpdate(sql);
		}
		catch (SQLException e) {
			System.out.println("silemedik " + e.getMessage());
		}
	}
	
	@Override
	public Optional<Takim> findById(int id) {
		sql = "SELECT * FROM " + tblTakimlar + " WHERE id = %d".formatted(id);
		try {
			Optional<ResultSet> resultSetOpt = dbHelper.executeQuery(sql);
			if (resultSetOpt.isPresent()) {
				ResultSet resultSet = resultSetOpt.get();
				if (resultSet.next()) {
					Takim takim = new Takim();
					takim.setId(resultSet.getInt("id"));
					takim.setAd(resultSet.getString("ad"));
					takim.setBaskanId(resultSet.getInt("baskan_id"));
					takim.setStadyumId(resultSet.getInt("stadyum_id"));
					takim.setState(resultSet.getInt("state"));
					return Optional.of(takim);
				}
				else return Optional.empty();
			}
		}
		catch (SQLException e) {
			System.out.println("maalesef takimi bulamadim :( " + e.getMessage());
			
		}
		return Optional.empty();
	}
	
	@Override
	public List<Takim> findAll() {
		sql = "SELECT * FROM " + tblTakimlar;
		ArrayList<Takim> takims = new ArrayList<>();
		try {
			Optional<ResultSet> resultSetOpt = dbHelper.executeQuery(sql);
			if (resultSetOpt.isPresent()) {
				ResultSet resultSet = resultSetOpt.get();
				while (resultSet.next()) {
					Takim takim = new Takim();
					takim.setId(resultSet.getInt("id"));
					takim.setAd(resultSet.getString("ad"));
					takim.setBaskanId(resultSet.getInt("baskan_id"));
					takim.setStadyumId(resultSet.getInt("stadyum_id"));
					takim.setState(resultSet.getInt("state"));
					takims.add(takim);
				}
			}
		}
		catch (SQLException e) {
			System.out.println("maalesef takimi bulamadim :( " + e.getMessage());
			
		}
		return takims;
	}
}