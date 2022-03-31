package mc322.lab03;

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      for (int l = 0; l < lombrigas.length; l++) {
    	  System.out.println(lombrigas[l]);
    	  Animacao anim = new Animacao(lombrigas[0]);
    	  for (int j = 0; j <= lombrigas[l].length(); j++) {
    		  tk.gravaPasso(anim.apresenta());
    		  anim.passo();
    		  
    	  }
    	  
      }
      
      tk.stop();
   }

}