import java.io.File;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void menu(){
        System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ------");
        System.out.println("Chọn chức năng theo số ( để tiếp tục) ");
        System.out.println("1.Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3.Cập nhật");
        System.out.println("4.Xóa");
        System.out.println("5.Tìm kiếm");
        System.out.println("6.Đọc từ File");
        System.out.println("7.Ghi vào File");
        System.out.println("8.Thoát");
        System.out.println("Chọn chức năng: ");
    }
    public static void display(List<Person> list){
        Iterator<Person> personIterator= list.iterator();
        while (personIterator.hasNext()){
            System.out.println(personIterator.next());
        }
    }
    public static void main(String[] args) {
        menu();
        Scanner scanner= new Scanner(System.in);
        int i;
        do {
            i= scanner.nextInt();
            System.out.println("Nhập lại lựa chọn");
        }while (i>8 || i<0);
        switch (i){
            case 1:
                display(FileCsv.readFile());
                break;
            case 2:
                PersonManager personManager= new PersonManager();

                Person person=personManager.insertInformation();

                FileCsv.readFile().add(person);
                FileCsv.writeFile(FileCsv.readFile());

                display(FileCsv.readFile());

                break;
            case 3:
                PersonManager personManager1= new PersonManager();
                Person person1=personManager1.insertInformation();

                System.out.println("Nhập số điện thoại");
                String number2=scanner.next();

                personManager1.update(number2,person1);
                FileCsv.writeFile(FileCsv.readFile());

                display(FileCsv.readFile());
                break;
            case 4:
                PersonManager personManager2= new PersonManager();
                Person person2= personManager2.insertInformation();
                FileCsv.readFile().remove(person2);
                break;
            case 5:
                PersonManager personManager3= new PersonManager();
                System.out.println("Nhập tên cần tìm :");
                String name= scanner.next();
                personManager3.search(name);
                FileCsv.writeFile(FileCsv.readFile());

                display(FileCsv.readFile());
                break;
            case 6:break;
            case 7:break;
            case 8:
                System.exit(0);
                break;

        }


    }
}
