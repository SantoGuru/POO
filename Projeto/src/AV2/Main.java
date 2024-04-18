package AV2;

public class Main {
	public static void main(String[] args) {
		// Criar o Hotel
		Hotel H1 = new Hotel();
		// 1. Criar Categorias de Quartos
		// 1.1 Criar a categoria 'simples'
		Categoria categoriaSimples = new Categoria(100.0, "simples", new Frigobar());
		// 1.1.1 Cria Produtos do Frigobar da Categoria
		Item simplesChips = new Item("Chips", 5.0, 5);
		Item simplesAgua = new Item("Agua", 3.0, 5);
		// 1.1.2 - Adicionar os produtos na Categoria
		categoriaSimples.frigobar.addItem(simplesAgua);
		categoriaSimples.frigobar.addItem(simplesChips);
		// 1.2 Cria a categoria 'casal'
		Categoria categoriaCasal = new Categoria(250.0, "casal", new Frigobar());
		// 1.2.1 Cria Produtos do Frigobar da Categoria
		Item casalChips = new Item("Chips", 5.0, 10);
		Item casalAgua = new Item("Agua", 3.0, 10);
		// 1.2.2 - Adicionar os produtos na Categoria
		categoriaCasal.frigobar.addItem(casalAgua);
		categoriaCasal.frigobar.addItem(casalChips);
		// 1.3 Cria a categoria 'luxo'
		Categoria categoriaLuxo = new Categoria(1000.0, "luxo", new Frigobar());
		// 1.3.1 Cria Produtos do Frigobar da Categoria
		Item luxoChips = new Item("Chips", 5.0, 10);
		Item luxoAgua = new Item("Agua", 3.0, 10);
		// 1.3.2 - Adicionar os produtos na Categoria
		categoriaLuxo.frigobar.addItem(luxoAgua);
		categoriaLuxo.frigobar.addItem(luxoChips);
		// 2. Criar Quartos
		Quarto Q1 = new Quarto(categoriaSimples);
		Quarto Q2 = new Quarto(categoriaCasal);
		Quarto Q3 = new Quarto(categoriaLuxo);
		// 2.1 Alocar quartos ao Hotel
		H1.quartos.add(Q1);
		H1.quartos.add(Q2);
		H1.quartos.add(Q3);
		// 3. Cadastro de Funcionarios
		Funcionario F1 = new Funcionario("01", "Cleiton", "666.000.555-50", "(85)95555-5555");
		Funcionario F2 = new Funcionario("02", "Claudio", "666.000.666-60", "(85)96666-6666");
		Funcionario F3 = new Funcionario("03", "Cadu", "666.000.777-70", "(85)97777-7777");
		// 3.1 Atribuir para Quartos
		F1.alocar(Q1);
		F2.alocar(Q2);
		F3.alocar(Q3);
		// 4. Cadastro de novos clientes
		Cliente C1 = new Cliente("Pietro", "636.000.277-70", "(85)97777-7777");
		Cliente C2 = new Cliente("Carlos", "616.000.177-70", "(85)97777-7777");
		Cliente C3 = new Cliente("Paulo", "646.000.477-70", "(85)97777-7777");
		// 5. Cliente X Quarto
		C1.reservarQuarto(H1.quartos.get(1), "01/10/2024", "02/10/2024");
		C2.reservarQuarto(H1.quartos.get(2), "01/10/2024", "02/10/2024");
		C3.reservarQuarto(H1.quartos.get(2), "01/10/2024", "02/10/2024"); // Não vai conseguir reservar
		// 6. Reserva X Ocupar (reserva não tem compromisso de gasto apenas impede que
		// outro reserve ou ocupe)
		C1.ocuparQuarto(H1.quartos.get(1));
		// OBS: 1. Ao ocupar o quarto, assume-se os gastos pela diaria.
		// OBS: 2. Ao ocupar, o quarto é considerado reservado para critérios de verificação.
		// Executar uma demonstração
		
		// Serviço foi posto para funcionar como um produto, então o passo é o mesmo que o de um item;
		Servico S1 = new Servico("Massagem",50.0);
		H1.serviços.add(S1);
		
		C1.consumirItem("Chips");
		C1.utilizarServico("Massagem",H1);
		
		H1.quartos.get(1).addHospede(C2); // Clientes podem ser adicionados como hospedes, podendo consumir
		// e ter acesso as funções entretanto, os gastos vão para o extrato do responsável pelo quarto.
		
		H1.quartos.get(1).diaria();
		C1.extratoFatura.calcularExtrato();
		
		H1.quartos.get(1).funcionarioResponsavel.desalocar(H1.quartos.get(1)); // o funcionario previamente alocado, é responsável pela consequente desalocação e limpeza do quarto.
		
		// Encerrando o ciclo de demonstração;
	}
}
