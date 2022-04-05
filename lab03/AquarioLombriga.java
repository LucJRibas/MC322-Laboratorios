package mc322.lab03;

public class AquarioLombriga {
    char lombrigaNoAquario[];
    int posCabeca, posRabo, tamLombriga, tamAquario;
    
    AquarioLombriga(int tamAquario, int tamLombriga, int posCabeca){
    	this.tamAquario = tamAquario;
    	this.tamLombriga = tamLombriga;
        this.lombrigaNoAquario = new char[tamAquario];
        this.posCabeca = posCabeca - 1;
        this.posRabo = this.posCabeca + this.tamLombriga - 1;
        for (int i = 0; i < this.posCabeca; i++)
            this.lombrigaNoAquario[i] = '#';
        this.lombrigaNoAquario[this.posCabeca] = '0';
        for (int i = this.posCabeca + 1; i < this.posRabo + 1; i++)
            this.lombrigaNoAquario[i] = '@';
        for (int i = this.posRabo + 1; i < this.tamAquario; i++)
            this.lombrigaNoAquario[i] = '#';
        
    }
    
    public void crescer() {
		if (this.posCabeca < this.posRabo) {
			if (this.posRabo + 1 >= this.tamAquario) return;

			this.lombrigaNoAquario[++this.posRabo] = '#';

		} else {
			if (this.posRabo <= 0) return;
			this.lombrigaNoAquario[--this.posRabo] = '@';
		}

    	if (this.posCabeca + this.tamLombriga >= tamAquario) return;
    	this.lombrigaNoAquario[this.posCabeca + this.tamLombriga] = '@';
    	this.tamLombriga++;
    }
    
    public void virar() {
    	this.lombrigaNoAquario[this.posRabo] = '0';
    	this.lombrigaNoAquario[this.posCabeca] = '@';
    	int temp = this.posCabeca;
    	this.posCabeca = this.posRabo;
    	this.posRabo = temp;
    }
    
    public void mover() {
    	if (this.posCabeca > this.posRabo) {
    		if (this.posCabeca + 1 >= this.tamAquario) {
    			virar();
    			return;
    		}
    		this.lombrigaNoAquario[this.posCabeca++] = '@';
			this.lombrigaNoAquario[this.posCabeca] = '0';
			this.lombrigaNoAquario[this.posRabo++] = '#';

    	} else {
    		if (this.posCabeca <= 0) {
    			virar();
    			return;
    		}
    		this.lombrigaNoAquario[this.posCabeca--] = '@';
			this.lombrigaNoAquario[this.posCabeca] = '0';
			this.lombrigaNoAquario[this.posRabo--] = '#';
    	}
    	
    }
    
    public String apresenta() {
    	return new String(this.lombrigaNoAquario);
    }
    
    
}
