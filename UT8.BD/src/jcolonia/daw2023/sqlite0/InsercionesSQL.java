package jcolonia.daw2023.sqlite0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsercionesSQL {

	public static void main(String[] args) {
		String fuente = "jdbc:sqlite:ejemplo001.db";
		
		try (	Connection conexión = DriverManager.getConnection(fuente);
				Statement sentenciaSQL = conexión.createStatement();
				PreparedStatement preparaciónSQL = conexión.prepareStatement
						("INSERT INTO Personal values(?,?)");
				){
			
			sentenciaSQL.setQueryTimeout(5);
			
			sentenciaSQL.executeUpdate("DROP TABLE IF EXISTS Personal");
			sentenciaSQL.executeUpdate(
			"CREATE TABLE Personal (Id INTEGER PRIMARY KEY, Nombre TEXT NOT NULL)");			
			
			int ids[] = { 1, 2, 3, 4, 5 };
			String nombres[] = { "África", "Björn", "Cristina", "Delfín", "Elena" };
			
			for (int i = 0; i < ids.length; i++) {
				preparaciónSQL.setInt(1, ids[i]);
				preparaciónSQL.setString(2, nombres[i]);
				preparaciónSQL.setQueryTimeout(5);
				preparaciónSQL.executeUpdate();
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
