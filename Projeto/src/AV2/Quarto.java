package AV2;
import java.util.List;
import java.util.ArrayList;

public class Quarto {
	public Categoria categoria;
	public Boolean reservado = false;
	public Reserva reserva;
	public Cliente clienteResponsavel;
	public List<Cliente> hospedes = new ArrayList<Cliente>();
	public Funcionario funcionarioResponsavel;
	
	public void diaria(){
		Fatura diaria = new Fatura("Diaria do Quarto",categoria.custoQuarto);
		clienteResponsavel.extratoFatura.addFatura(diaria);
	};
	
	public Quarto(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void addHospede(Cliente H){
		hospedes.add(H);
	};
}
