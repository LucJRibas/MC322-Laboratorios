package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start(null, null);
      
      String commands[] = tk.retrieveCommands();
      
      Tabuleiro tabuleiro = new Tabuleiro();
      
      tk.writeBoard("Tabuleiro inicial", tabuleiro.apresenta());
      for (int l = 0; l < commands.length; l++) {
    	  tabuleiro.executaComando(commands[l]);
          tk.writeBoard("source: " + commands[l].substring(0, 2) + ";target: "+ commands[l].substring(3), tabuleiro.apresenta());

      }
//         System.out.println(commands[l]);
      
      tk.stop();
   }

}
