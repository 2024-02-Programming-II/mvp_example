
import co.edu.uptc.presenters.Runner;
import java.util.Locale;


public class App {
    public static void main(String[] args) throws Exception {
 

     Locale.setDefault(new Locale("es", "CO"));
   //  Locale.setDefault(new Locale("en", "US"));
      
          Runner runner = new Runner();
          runner.start(); 


    // new ConfigManager();
    // FileManager fileManager = new  FileManager();
    // fileManager.write();
    

    }
}
