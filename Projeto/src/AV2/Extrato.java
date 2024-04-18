package AV2;
import java.util.List;
import java.util.ArrayList;

public class Extrato {
	public List<Fatura> faturas = new ArrayList<Fatura>();
	public Double custoFinal = 0.0;
	
	public void addFatura(Fatura fatura) {
		faturas.add(fatura);
	}
	
	public void calcularExtrato() {
		this.custoFinal = 0.0;
		System.out.println("----- EXTRATO -----");
		for(int i = 0;i<faturas.size();i++){
			System.out.println("Serviço: "+faturas.get(i).nome);
			System.out.println("Valor: R$"+faturas.get(i).valor);
			System.out.println("----- ------- -----");
			this.custoFinal += faturas.get(i).valor;
		}
		System.out.println("VALOR FINAL: R$"+this.custoFinal);
	}
}
