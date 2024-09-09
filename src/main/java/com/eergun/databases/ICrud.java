package com.eergun.databases;

import java.util.List;
import java.util.Optional;

public interface ICrud<T> {
	public void add(T obj);
	public void update(T obj);
	public void delete(int id);
	public Optional<T> findById(int id);
	public List<T> findAll();
	public void softDelete(int id);
}