package mc322.lab03;

public class AquarioLombriga {
    char lombrigaNoAquario[];
    int posCabeca, posRabo, tamLombriga, tamAquario;
    
    AquarioLombriga(int tamAquario, int tamLombriga, int posCabeca){
    	this.tamAquario = tamAquario;
    	this.tamLombriga = tamLombriga;
        lombrigaNoAquario = new char[tamAquario];
        this.posCabeca = posCabeca - 1;
        posRabo = this.posCabeca + this.tamLombriga - 1;
        for (int i = 0; i < this.posCabeca; i++)
            lombrigaNoAquario[i] = '#';
        lombrigaNoAquario[this.posCabeca] = '0';
        for (int i = this.posCabeca + 1; i < posRabo + 1; i++)
            lombrigaNoAquario[i] = '@';
        for (int i = posRabo + 1; i < this.tamAquario; i++)
            lombrigaNoAquario[i] = '#';
        
    }
    
    public void crescer() {
		if (posCabeca < posRabo) {
			if (posRabo + 1 >= tamAquario) return;

			lombrigaNoAquario[++posRabo] = '@';

		} else {
			if (posRabo <= 0) return;
			lombrigaNoAquario[--posRabo] = '@';
		}
    	tamLombriga++;
    }
    
    public void virar() {
    	lombrigaNoAquario[posRabo] = '0';
    	lombrigaNoAquario[posCabeca] = '@';
    	int temp = posCabeca;
    	posCabeca = posRabo;
    	posRabo = temp;
    }
    
    public void mover() {
    	if (posCabeca > posRabo) {
    		if (posCabeca + 1 >= tamAquario) {
    			virar();
    			return;
    		}
    		lombrigaNoAquario[posCabeca++] = '@';
			lombrigaNoAquario[posCabeca] = '0';
			lombrigaNoAquario[posRabo++] = '#';

    	} else {
    		if (posCabeca <= 0) {
    			virar();
    			return;
    		}
    		lombrigaNoAquario[posCabeca--] = '@';
			lombrigaNoAquario[posCabeca] = '0';
			lombrigaNoAquario[posRabo--] = '#';
    	}
    	
    }
    
    public String apresenta() {
    	return new String(lombrigaNoAquario);
    }
    
    
}
