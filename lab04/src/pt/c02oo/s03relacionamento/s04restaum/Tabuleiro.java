package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	private Peca tabuleiro[][];
	
	Tabuleiro(){
		tabuleiro = new Peca[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (j == 3 && i == 3)
					tabuleiro[i][j] = new Peca(i, j, TiposPeca.MORTA); 
				else if (emIntervalo(j, 2, 4) || emIntervalo(i, 2, 4))
					tabuleiro[i][j] = new Peca(i, j, TiposPeca.VIVA);
				else 
					tabuleiro[i][j] = new Peca(i, j, TiposPeca.VAZIA);
			}
		}
	}
	
	static private boolean emIntervalo(int val, int min, int max) {
		return val >= min && val <= max;
	}
	
	public boolean comandoValido(int i0, int j0, int i1, int j1) {
		return tabuleiro[i1][j1].destinoValido() && tabuleiro[(i0 + i1)/2][(j0 + j1)/2].estaViva();
	}
	
	public void executaComando(String comando) {
		int i0, j0, i1, j1;
		j0 = comando.charAt(0) - 'a';
		i0 = comando.charAt(1) - '1';
		j1 = comando.charAt(3) - 'a';
		i1 = comando.charAt(4) - '1';
		
		if (!tabuleiro[i0][j0].podeMover(i1, j1, this)) return;
				
		Peca temp = tabuleiro[i0][j0]; 
		tabuleiro[i1][j1].mudaPosicao(i0, j0);
		tabuleiro[i0][j0] = tabuleiro[i1][j1];
		tabuleiro[i1][j1] = temp;
		tabuleiro[(i0 + i1)/2][(j0 + j1)/2].setTipo(TiposPeca.MORTA);
	}
	
	public char[][] apresenta() {
		char tab[][] = new char[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				tab[i][j] = tabuleiro[i][j].apresenta();
			}
		}
		return tab;
	}

}
