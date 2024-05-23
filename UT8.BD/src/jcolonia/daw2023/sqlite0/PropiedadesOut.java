package jcolonia.daw2023.sqlite0;

import java.io.FileOutputStream;
import java.util.Properties;

public class PropiedadesOut {
	
	public static void main(String[] args) {
		try (FileOutputStream out = new FileOutputStream("config.xml");
				){
		Properties configuración = new Properties();
		configuración.setProperty("jdbc.url", "jdbc:sqlite:ejemplo04.db");
		configuración.setProperty("jdbc.user", "Hola");
		configuración.setProperty("jdbc.password", "1234");
		configuración.storeToXML(out, "Configuración BD", "UTF-8");
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
		}

	}
	
}
