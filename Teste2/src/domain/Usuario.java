package domain;
import java.io.IOException;

import dao.*;

public class Usuario {
	public String nome;
	public String CPF;
	public int idade;
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public Usuario cadastrar(DB db) throws IOException {
		return usuarioDAO.cadastrar(this,db);
	}
	
	public Usuario(String nome, String CPF, int idade) {
		this.nome = nome;
		this.CPF = CPF;
		this.idade = idade;
	}
}
