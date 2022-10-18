package com.curso.mercado.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.entidades.Producto;
import com.curso.mercado.servicios.ProductoService;


public class AltaProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductoService productoService = new ProductoService();   
    
    public AltaProductoServlet() {
        super();
        System.out.println("Instansciando AltaProductoServer");
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Estoy en el doPost");
		
		String paramDescripcion = request.getParameter("descripcion");
		String paramPrecio = request.getParameter("precio");
		
		String msgError = "";
		
		if(paramDescripcion == null || paramDescripcion.trim().length() == 0) {
			msgError = "Debes indicar una descripcion del producto";
		}
		
		double precio = 0;
		
		if(paramPrecio == null || paramPrecio.trim().length() == 0) {
			msgError = "Debes indicar un precio el producto";
		} else {
			precio = Double.parseDouble(paramPrecio);
		}
		
		if(msgError.length() > 0) {
			System.out.println("fallo " + msgError);
			
			request.setAttribute("error", msgError);
			
			RequestDispatcher rd = request.getRequestDispatcher("alta_producto.jsp");
			rd.forward(request, response);
			
		} else {
			Producto p = new Producto(null, paramDescripcion, precio);
			System.out.println("das de alta " + p);
			productoService.darAltaUnProducto(p);
			
			List<Producto> listaProductos = productoService.dameTodosLosProductos();
			
			request.setAttribute("lista", listaProductos);
			RequestDispatcher rd = request.getRequestDispatcher("lista_productos.jsp");
			rd.forward(request, response);
			
		}
		
	}

}
