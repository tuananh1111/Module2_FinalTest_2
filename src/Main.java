import java.io.File;
import java.nio.channels.FileChannel;
import java.sql.SQLOutput;
import java.util.ArrayList;
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
        PersonManager personManager = new PersonManager();
        List<Person> list = new ArrayList<>();
        int choice = -1;
        Scanner sc = new Scanner(System.in);

        while (choice != 8) {
            menu();
            choice = Integer.parseInt(sc.next());
            switch (choice) {
                case 1:
                    System.out.println("====Xem danh sách====");
                    list = personManager.findAll();
                    System.out.println(list);
                    break;
                case 2:
                    System.out.println("===Them danh ba====");
                    Person person= personManager.insertInformation();
                    list.add(person);
                    list= personManager.findAll();
                    System.out.println(list);
                    break;
                case 3:
                    System.out.println("====Cập nhật danh bạ=======");
                    System.out.println("Nhập số điện thoại cần cập nhật thông tin :");
                    String numberPhone= sc.next();
                    if (personManager.checkNumberPhone(numberPhone)){
                        Person person1=personManager.insertInformation();
                        personManager.update(numberPhone,person1);
                        list= personManager.findAll();
                        System.out.println(list);
                    }else System.out.println("Không có khách hàng nào");
                    break;

        }


    }
}
}
