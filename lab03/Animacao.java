package mc322.lab03;

public class Animacao {
	AquarioLombriga lombNoAq;
	String acoes;
	int estado = -1;
	
	Animacao(String strAnimacao){
		lombNoAq = new AquarioLombriga(
				Integer.parseInt(strAnimacao.substring(0, 1)),
				Integer.parseInt(strAnimacao.substring(2, 3)),
				Integer.parseInt(strAnimacao.substring(4, 5))
		);
		
		acoes = strAnimacao.substring(6);
		
	}
	
	public void passo() {
		if (estado >= acoes.length()) return; 
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
		if (estado == -1) {
			estado = 0;
			return "=====";
		}
    	return this.lombNoAq.apresenta();
    }
}
