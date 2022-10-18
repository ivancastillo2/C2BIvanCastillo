package com.curso.db;

import java.util.Collection;
import java.util.TreeMap;
import java.util.Map;

import com.curso.mercado.entidades.Producto;
import com.curso.mercado.entidades.Usuario;

public class BaseDatosMercado {

	private static Map<Integer, Producto> tablaProducto;
	private static int contadorProducto = 3;
	private static Map<Integer, Usuario> tablaUsuario;
	private static int contadorUsuario = 3;
	
	//iniciar el static tablaProducto
	static {
		tablaProducto = new TreeMap<Integer, Producto>();
		tablaProducto.put(1, new Producto(1, "Libro Receta", 30.0));
		tablaProducto.put(2, new Producto(2, "Jarron Chino", 340.0));
		tablaProducto.put(3, new Producto(3, "Lápìz", 3.0));
		tablaUsuario = new TreeMap<Integer, Usuario>();
		tablaUsuario.put(1, new Usuario("Luis", "Admin"));
		tablaUsuario.put(2, new Usuario("Iván", "Cliente"));
		tablaUsuario.put(3, new Usuario("Pepe", "Cliente"));
	}
	
	private BaseDatosMercado() {
		
	}
	
	//crear los metodos para añadir, borrar, modificar solicitar por
	//id y solicitar todos.
	public static void addProducto(String nombre, double precio) {
		int newId = ++contadorProducto;
		Producto newP = new Producto(newId, nombre, precio);
		tablaProducto.put(newId, newP);
	}
	
	public static void borrarProducto(int idProducto) {
		tablaProducto.remove(idProducto);
	}
	
	public static void modificarProducto(Producto pModf) throws Exception {
		Producto p = getByIDProducto(pModf.getIdProducto());
		if(p == null) {
			throw new Exception("Producto no encontrado para ser modificado");
		}
		tablaProducto.put(p.getIdProducto(), p);
	}
	
	public static Collection<Producto> getAllProducto() {
		return tablaProducto.values();
	}
	
	public static Producto getByIDProducto(int idProducto) {
		return tablaProducto.get(idProducto);
	}
	
	public static int getContadorProducto() {
		return contadorProducto;
	}
	
	public static Collection<Usuario> getAllUsuario() {
		return tablaUsuario.values();
	}
}
