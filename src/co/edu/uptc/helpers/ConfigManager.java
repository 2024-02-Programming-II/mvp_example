package co.edu.uptc.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

  public static Properties properties;
 // private Propertiesmanager instance;


  public  ConfigManager(){
    loadProperties();
  }


//   public static Propertiesmanager getInstance(){
//     if (instance==null){
//       instance = new Propertiesmanager();
//     }
//     return instance;
//   }

  public void loadProperties() {
    properties = new Properties();
    try {
      properties.load(new FileInputStream("resources/config.properties"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
