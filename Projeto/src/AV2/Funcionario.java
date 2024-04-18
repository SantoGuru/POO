package AV2;

public class Funcionario extends Pessoa{
	public String ID;
	
	public void alocar(Quarto quarto){
		quarto.funcionarioResponsavel = this;
	};
	public void desalocar(Quarto quarto){
		quarto.clienteResponsavel = null;
		quarto.hospedes.clear();
		quarto.reserva = null;
		quarto.reservado = false;
	};
	
	public Funcionario(String ID,String nome,String CPF,String numero) {
		super(nome,CPF,numero);
		this.ID = ID;
	}
}
