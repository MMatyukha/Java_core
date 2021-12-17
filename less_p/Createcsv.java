import java.io.IOException;
 
public class GenerateCsv
{
   public static void main(String [] args)
   {
    generateCsvFile("с:\\test.csv"); 
   }
 
   private static void generateCsvFile(String sFileName)
   {
 try
 {
     FileWriter writer = new FileWriter(sFileName);
 
     writer.append("Name");
     writer.append(',');
     writer.append("email");
     writer.append('\n');
 
     writer.append("sample");
     writer.append(',');
     writer.append("sample@sample.com");
            writer.append('\n');
 
     writer.append("demo");
     writer.append(',');
     writer.append("demo@demo.com");
     writer.append('\n');
 
     
     writer.flush();
     writer.close();
 }
 catch(IOException e)
 {
      e.printStackTrace();
 } 
    }
}
