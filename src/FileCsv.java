import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCsv {
    public void readFile(){
        try {
            FileReader file = new FileReader("D:\\Module2_FinalTest\\src\\csv-example-master\\contacts.csv");
            BufferedReader bf = new BufferedReader(file);

            String line = "";
            while((line = bf.readLine())!=null){
                String[] contact = line.split(",");
                System.out.println("Person: number phone " + contact[0]+"group "+contact[1]+"name"+contact[2]
                        +"gender: " + contact[3]+" address "+contact[4]+" date of birth"+contact[5]+" email "+contact[6]);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeFile(List list){
        try {
            File file= new File("cont.txt");
            if (!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 0; i < PersonManager.list.size(); i++) {
                fileWriter.write(PersonManager.list.get(i).toString());
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
