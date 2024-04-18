package AV2;

public class Reserva {
	public Cliente whoIs;
	public String dataReserva;
	public String dataDesocupar;
	
	public Reserva(Cliente whoIs,String dR,String dD) {
		this.whoIs = whoIs;
		this.dataReserva = dR;
		this.dataDesocupar = dD;
	};
}
