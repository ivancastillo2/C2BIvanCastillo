package com.curso.mercado.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.curso.mercado.entidades.Producto;

public class ProductoDataBaseDAO implements GenericDAO<Producto> {

	private Connection con;
	
	public ProductoDataBaseDAO(Connection con) {
		this.con = con;
	}
	
	
	@Override
	public void add(Producto entidad) {
		try {
			int idMax = getMaxProductId();
			
			String insert = "INSERT INTO HR.PRODUCTOS2(ID_PRODUCTO, DESCRIPCION, PRECIO, STOCK)"
					+ " VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, ++idMax);
			ps.setString(2, entidad.getDescripcion());
			ps.setDouble(3, entidad.getPrecio());
			ps.setInt(4, entidad.getStock());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Producto> getAll() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		String consulta = "SELECT * FROM HR.PRODUCTOS2";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			while(rs.next()) {
				Producto p = new Producto();
				p.setIdProducto(rs.getInt(1));
				p.setDescripcion(rs.getString(2));
				p.setPrecio(rs.getDouble(3));
				p.setStock(rs.getInt(4));
				productos.add(p);
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("DB JDBC API. " + e.getMessage(), e);
		}
		return productos;
	}

	@Override
	public Producto getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Producto entidad) {
		// TODO Auto-generated method stub
		
	}
	
	private int getMaxProductId() {
		String consulta = "SELECT MAX(ID_PRODUCTO)"
				+ " FROM HR.PRODUCTOS2";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			
			int idMax = 0;
			if(rs.next()) {
				idMax = rs.getInt(1);
			}
			return idMax;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("No pudo obtener el último id");
		}
	}

}
