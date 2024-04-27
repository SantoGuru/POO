package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DB {
	File arquivo;
	
	public DB(String nome)throws IOException{
		File checkFile = new File(nome+".txt");
		if (checkFile.exists() == true) {
			this.arquivo = checkFile;
		}else{
			FileWriter FW = new FileWriter(nome+".txt",true);
			FW.close();
			this.arquivo = checkFile;
		}
	};
}
