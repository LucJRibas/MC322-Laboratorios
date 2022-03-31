package mc322.lab03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class Toolkit {
   public static String DIRETORIO =
         Toolkit.class.getResource(".").getPath() + "/";
   
   private static Toolkit tk;
   
   private PrintWriter pw;
   
   public static Toolkit start() {
      tk = new Toolkit();
      try {
         tk.pw = new PrintWriter(
                new FileWriter(DIRETORIO + "anima.csv"));
      }catch(IOException erro){
         erro.printStackTrace();
      }
      return tk;
   }
   
   public String[] recuperaLombrigas() {
      Vector<String> v = new Vector<String>();
      try {
         BufferedReader file =
               new BufferedReader(new FileReader(DIRETORIO + "lombriga.csv"));

         String line = file.readLine();
         while (line != null) {
            v.add(line);
            line = file.readLine();
         }
         file.close();
      } catch (Exception erro) {
         erro.printStackTrace();
      }
      return (String[])v.toArray(new String[v.size()]);
   }

   public void gravaPasso(String passo){
      try {
         System.out.println(passo);
         pw.println(passo);
      }catch(Exception erro){
         erro.printStackTrace();
      }
   }
   
   public void stop() {
      pw.close();
   }
}
