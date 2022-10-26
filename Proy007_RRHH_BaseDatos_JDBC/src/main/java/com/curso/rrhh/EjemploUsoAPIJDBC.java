package com.curso.rrhh;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploUsoAPIJDBC {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("cargó ok");
		} catch (ClassNotFoundException e) {
			System.out.println("No cargó driver");
			e.printStackTrace();
			return;
		}
		
		String url = "jdbc:oracle:thin:@localhost:49161:xe";
		String usr =  "SYSTEM";
		String clave = "oracle";
		
		
		try (Connection con = DriverManager.getConnection(url, usr, clave)){
			
			System.out.println("conectó ok");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM HR.COUNTRIES");
			while(rs.next()) {
				System.out.println(rs.getString(1) + "|\t" + rs.getString(2) + "\t" + rs.getString(3));
			}
			
//			String setenciaInsert = "INSERT INTO HR.COUNTRIES "
//					+ "VALUES('xx','PAISXX', 4)";
//			
//			int registrosAfectados = st.executeUpdate(setenciaInsert);
//			
//			System.out.printf("insertó %d registros", registrosAfectados);
			
			String sentenciaUpdate = "UPDATE HR.EMPLOYEES SET FIRST_NAME = 'Steve' WHERE EMPLOYEE_ID = 100";
			
			int registrosAfectados = st.executeUpdate(sentenciaUpdate);
			
			System.out.printf("insertó %d registros", registrosAfectados);
			
//			String sentenciaDelete = "DELETE FROM HR.EMPLOYEES WHERE EMPLOYEE_ID = 149";
//			
//			registrosAfectados = st.executeUpdate(sentenciaDelete);
//			
//			System.out.printf("insertó %d registros", registrosAfectados);
			String sentenciaPreparada = "UPDATE HR.COUNTRIES SET COUNTRY_NAME = ? WHERE COUNTRY_ID = ?";
			PreparedStatement ps = con.prepareStatement(sentenciaPreparada);
			
			String pais = "a";
			String codigo = "CN";
			
			ps.setString(1, pais);
			ps.setString(2, codigo);
			
			int rows = ps.executeUpdate();
			
			String crearProcAlmacenado =
					"CREATE OR REPLACE PROCEDURE HR.Ver_NombreEmpleado"
					+ "(PARAM_COD_EMPLEADO IN NUMBER, PARAM_NOMBRE_EMPLEADO OUT VARCHAR) "
					+ "AS "
					+ "BEGIN "
					+ "   SELECT FIRST_NAME INTO PARAM_NOMBRE_EMPLEADO"
					+ "   FROM HR.EMPLOYEES "
					+ "   WHERE EMPLOYEE_ID = PARAM_COD_EMPLEADO;"
					+ "END;";
			con.createStatement().execute(crearProcAlmacenado);
			
			CallableStatement call = con.prepareCall("{call HR.Ver_NombreEmpleado(?, ?)");
			call.setInt(1, 100);
			call.registerOutParameter(2, java.sql.Types.VARCHAR);
			call.executeQuery();
			
			System.out.println("\n" + call.getString(2));
			
			modificarPaises(con, 101, 102, 103, 104);
			
		} catch (SQLException e) {
			System.out.println("Error conexión " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void modificarPaises(Connection conexion, int... codigos) {
		try {
			conexion.setAutoCommit(false);
			String modif = "UPDATE HR.EMPLOYEES "
					+ "SET FIRST_NAME = FIRST_NAME" + "||'modif'"
					+ "WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = conexion.prepareStatement(modif);
			
			for(int codigo: codigos) {
				ps.setInt(1, codigo);
				ps.executeUpdate();
			}
			conexion.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		
	}

}
