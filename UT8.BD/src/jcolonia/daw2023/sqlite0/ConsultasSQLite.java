package jcolonia.daw2023.sqlite0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultasSQLite {
	
	public static void main(String[] args) {
		String fuente = "jdbc:sqlite:ejemplo001.db";
		
		try(Connection conexión = DriverManager.getConnection(fuente);
				Statement sentenciaSQL = conexión.createStatement();
				PreparedStatement preparaciónSQL = conexión.prepareStatement("SELECT * from Personal");
				ResultSet loteDatos = preparaciónSQL.executeQuery();
				){
		
			sentenciaSQL.setQueryTimeout(5);
			preparaciónSQL.setQueryTimeout(5);
			
			
			while (loteDatos.next()) {
			int id = loteDatos.getInt("Id");
			String nombre = loteDatos.getString("Nombre");
			System.out.printf("id= %s, nombre = %s%n", id, nombre);
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


