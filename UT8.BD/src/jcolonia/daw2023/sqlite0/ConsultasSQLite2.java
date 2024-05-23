package jcolonia.daw2023.sqlite0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultasSQLite2 {
	
	public static void main(String[] args) {
		String fuente = "jdbc:sqlite:world2.db";
		
		try(Connection conexión = DriverManager.getConnection(fuente);
				Statement sentenciaSQL = conexión.createStatement();
				PreparedStatement preparaciónSQL = conexión.prepareStatement("SELECT * from Country");
				ResultSet loteDatos = preparaciónSQL.executeQuery();
				){
		
			sentenciaSQL.setQueryTimeout(5);
			preparaciónSQL.setQueryTimeout(5);
			
			
			while (loteDatos.next()) {
			String nombre = loteDatos.getString("Name");
			System.out.printf("nombre = %s%n", nombre);
			}

		}catch(SQLException ex) {
			System.err.printf("Error: %s \n--%s--\n%s",
					"No se ha creado la base de datos SQLite",
					ex.getLocalizedMessage());
			ex.getStackTrace();
			System.exit(1);
	}
	

	}
}


