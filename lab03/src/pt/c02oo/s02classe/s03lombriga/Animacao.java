package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	AquarioLombriga lombNoAq;
	String acoes;
	int estado = -2;
	
	Animacao(String strAnimacao){
		lombNoAq = new AquarioLombriga(
				Integer.parseInt(strAnimacao.substring(0, 2)),
				Integer.parseInt(strAnimacao.substring(2, 4)),
				Integer.parseInt(strAnimacao.substring(4, 6))
		);
		
		acoes = strAnimacao.substring(6);
		
	}
	
	public void passo() {
		if (estado >= acoes.length()) return;
		else if (estado < 0) {
			estado++;
			return;
		}
		switch (acoes.charAt(estado)) {
			case 'C':
				lombNoAq.crescer();
				break;
			case 'M':
				lombNoAq.mover();
				break;
			case 'V':
				lombNoAq.virar();
				break;
		}
		estado++;
	}
	
	
	public String apresenta() {
		if (estado == -2) {
			estado++;
			return "=====";
		}
    	return this.lombNoAq.apresenta();
    }
}
