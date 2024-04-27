package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import domain.*;

public class UsuarioDAO {
	
	public Boolean verify(Usuario usuario,DB DB) throws IOException{
		String linha;
		FileReader FR = new FileReader(DB.arquivo);
		BufferedReader BR = new BufferedReader(FR);
		while((linha = BR.readLine())!=null) {
			String[] dados = linha.split(",");
			System.out.println(usuario.CPF);
			if (dados[1].toString().equals(usuario.CPF)) {
				BR.close();
				return false;
			}
		};
		BR.close();
		return true;
	};
	
	public Usuario cadastrar(Usuario usuario,DB DB) throws IOException{
		if (this.verify(usuario, DB)){
			// File/Buffer
			FileReader FR = new FileReader(DB.arquivo);
			BufferedReader BR = new BufferedReader(FR);
			FileWriter FW = new FileWriter(DB.arquivo,true);
			BufferedWriter BW = new BufferedWriter(FW);
			// newLine até uma linha vazia
			String linha;
			while((linha = BR.readLine())!=null) {
				BW.newLine();
			};
			// BufferedWriter 
			BW.write(usuario.nome+","+usuario.CPF+","+usuario.idade);
			// Fechamento dos File/Buffer
			BR.close();
			BW.close();
			// Retorno do usuário recém cadastrado e fechamento do método
			return usuario;
		}else {
			// Retorno do usuário já cadastrado e fechamento do método
			return usuario;
		}
	};
}
