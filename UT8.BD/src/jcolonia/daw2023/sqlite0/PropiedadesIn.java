package jcolonia.daw2023.sqlite0;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropiedadesIn {
	public static void main(String[] args) {
		Properties configuración = new Properties();
		String usuario, contraseña, url;
		usuario = "";
		contraseña = "";
		url = "";
		try(FileInputStream in = new FileInputStream("config.xml");) {
			configuración.loadFromXML(in);
			url = configuración.getProperty("jdbc.url");
			usuario = configuración.getProperty("jdbc.user");
			contraseña = configuración.getProperty("jdbc.password");
		}catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		System.out.printf("Url: %s \nUsuario: %s \nContraseña: %s", url, usuario, contraseña);
	}
}
