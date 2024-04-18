package AV2;

public class Cliente extends Pessoa {
	public Extrato extratoFatura;
	public Quarto quartoAtual;

	public void ocuparQuarto(Quarto quarto) {
		if (quarto.reservado != true) {
			quarto.reservado = true;
			this.quartoAtual = quarto;
			quarto.clienteResponsavel = this;
		} else if ((quarto.reservado == true) || (quarto.reserva.whoIs == this)) {
			quarto.reservado = true;
			this.quartoAtual = quarto;
			quarto.clienteResponsavel = this;
		}

	}

	public void reservarQuarto(Quarto quarto, String dataIn, String dataOff) {
		if (quarto.reservado != true) {
			Reserva R = new Reserva(this, dataIn, dataOff);
			quarto.reservado = true;
			quarto.reserva = R;
		}
	}

	public void consumirItem(String nome) {
		if (quartoAtual != null) {
			int getItem = quartoAtual.categoria.frigobar.getItem(nome);
			if (getItem != -1) {
				Item itemConsumido = quartoAtual.categoria.frigobar.itens.get(getItem);
				itemConsumido.quantidade -= 1;
				Fatura comeu = new Fatura("[Item frigobar: "+itemConsumido.nome+"]", itemConsumido.valor);
				quartoAtual.clienteResponsavel.extratoFatura.addFatura(comeu);
			}
		}
		;
	}

	public void utilizarServico(String nome,Hotel hotel) {
		if (quartoAtual != null) {
			int getServico = hotel.getServico(nome);
			if (getServico != -1) {
				Servico servico = hotel.serviços.get(getServico);
				Fatura faturou = new Fatura("[Utilizou o serviço de: "+servico.nome+"]", servico.valor);
				quartoAtual.clienteResponsavel.extratoFatura.addFatura(faturou);
			}
		}
		;
	}

	public Cliente(String nome, String CPF, String numero) {
		super(nome, CPF, numero);
		this.extratoFatura = new Extrato();
	}
};
