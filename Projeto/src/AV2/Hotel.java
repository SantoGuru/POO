package AV2;
import java.util.List;
import java.util.ArrayList;

public class Hotel {
	public List<Quarto> quartos = new ArrayList<Quarto>();
	public List<Cliente> clientes = new ArrayList<Cliente>();
	public List<Servico> serviços = new ArrayList<Servico>();
	public List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public Hotel(){}
	
	public int getServico(String nome) {
		for(int i = 0;i<serviços.size();i++){
			if ((serviços.get(i).nome==nome)){
					return i;
			};
		}
		return -1;
};
}
