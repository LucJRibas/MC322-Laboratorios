package mc322.lab03;

public class AquarioLombriga {
    char lombrigaNoAquario[];
    int posCabeca, posRabo, tamAquario, direction = 1;
    
    AquarioLombriga(int tamAquario, int tamLombriga, int posCabeca){
    	this.tamAquario = tamAquario;
        lombrigaNoAquario = new char[tamAquario];
        this.posCabeca = posCabeca - 1;
        posRabo = this.posCabeca + tamLombriga - 1;
        for (int i = 0; i < this.posCabeca; i++)
            lombrigaNoAquario[i] = '#';
        lombrigaNoAquario[this.posCabeca] = 'O';
        for (int i = this.posCabeca + 1; i < posRabo + 1; i++)
            lombrigaNoAquario[i] = '@';
        for (int i = posRabo + 1; i < this.tamAquario; i++)
            lombrigaNoAquario[i] = '#';
        
    }
    
    public void crescer() {
		if (direction == 1) {
			if (posRabo + 1 >= tamAquario) return;

			lombrigaNoAquario[++posRabo] = '@';

		} else {
			if (posRabo <= 0) return;
			lombrigaNoAquario[--posRabo] = '@';
		}
    }
    
    public void virar() {
    	lombrigaNoAquario[posCabeca] = '@';
    	lombrigaNoAquario[posRabo] = 'O';
    	int temp = posCabeca;
    	posCabeca = posRabo;
    	posRabo = temp;
    	direction = direction == 1 ? -1: 1;
    }
    
    public void mover() {
    	if (direction == -1) {
    		if (posCabeca + 1 >= tamAquario) {
    			virar();
    			return;
    		}
    		lombrigaNoAquario[posCabeca++] = '@';
			lombrigaNoAquario[posCabeca] = 'O';
			lombrigaNoAquario[posRabo++] = '#';

    	} else {
    		if (posCabeca <= 0) {
    			virar();
    			return;
    		}
    		lombrigaNoAquario[posCabeca--] = '@';
			lombrigaNoAquario[posCabeca] = 'O';
			lombrigaNoAquario[posRabo--] = '#';
    	}
    	
    }
    
    public String apresenta() {
    	return new String(lombrigaNoAquario);
    }
    
    
}
