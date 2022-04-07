package pt.c02oo.s03relacionamento.s04restaum;

import static java.lang.Math.abs;

public class Peca {
	int i, j;
	TiposPeca tipo;
	
	Peca(int i,int j,TiposPeca tipo){
		this.i = i;
		this.j = j;
		this.tipo = tipo;
	}

	public boolean podeMover(int i1, int j1, Tabuleiro tabuleiro) {
		if (!(abs(i1 - i) == 2 && j1 == j || abs(j1 - j) == 2 && i1 == i)
		|| (i1 >= 7 || i1 < 0) && (j1 >= 7 || j1 < 0) || tipo != TiposPeca.VIVA) return false;

		
		if (!tabuleiro.comandoValido(i, j, i1, j1)) return false;
		
		i = i1;
		j = j1;
		return true;
	}
	
	public void setTipo(TiposPeca tipo) {
		this.tipo = tipo;
	}
	
	public boolean estaViva() {
		return tipo == TiposPeca.VIVA;
	}
	
	public boolean destinoValido() {
		return tipo == TiposPeca.MORTA;
	}
	
	public void mudaPosicao(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public char apresenta() {
		switch(tipo) {
			case VIVA: return 'P';
			case MORTA: return '-';
			default: return ' ';
		}
	}
}
