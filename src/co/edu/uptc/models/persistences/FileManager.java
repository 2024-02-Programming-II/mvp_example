package co.edu.uptc.models.persistences;

import co.edu.uptc.helpers.ConfigManager;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class FileManager {

    private Properties properties;

  private File file;
  private FileWriter fileWriter;

  public FileManager(){
   
      properties = ConfigManager.properties;
  }

  public void initFile() throws IOException {
    String fileName =
                properties.getProperty("data.path") +
                properties.getProperty("data.namefile");
    System.out.println(fileName);
    file = new File(fileName);
    fileWriter = new FileWriter(file);
  }

  public void write(String datos) {
    try {
      initFile();
      fileWriter.write(datos);
      fileWriter.close();
    } catch (IOException e) {}
  }
}
