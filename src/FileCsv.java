import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCsv {
    public static List<Person> readFile() {
        List<Person> list = new ArrayList();

        try {
            File file = new File("contact.csv");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            String line = "";
            while ((line = buffer.readLine()) != null) {
                String[] strings = line.split(",");
                list.add(new Person(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5],strings[6]));
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void writeFile(List<Person> list){

        try {
            FileWriter fileWriter= new FileWriter("contact.csv");
                for (int i = 0; i < list.size(); i++) {
                    fileWriter.write(String.valueOf(list.get(i)));
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
