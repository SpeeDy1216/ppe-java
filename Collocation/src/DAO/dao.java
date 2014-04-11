package DAO;

import java.sql.Connection;

import file.Connexion;
import java.util.ArrayList;

public abstract class dao<T> {
	public Connection connect = Connexion.getInstance();
	
        public abstract ArrayList findAll();
        
	public abstract T find(long id);
	
	public abstract T create(T obj);
	
	public abstract T update(T obj);
	
	public abstract void delete(T obj);
}
