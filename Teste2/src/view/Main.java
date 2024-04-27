package view;
import domain.*;

import java.io.IOException;

import dao.*;

public class Main {

	public static void main(String[] args) {
		try {
			DB usuarios= new DB("usuarios");
			Usuario usuario = new Usuario("Breno","111.222.333-80",10);
			usuario = usuario.cadastrar(usuarios);
			
			Usuario usuario2 = new Usuario("Carlinhos","222.111.333-10",20);
			usuario2 = usuario2.cadastrar(usuarios);
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
