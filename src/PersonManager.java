import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PersonManager implements IContact<Person> {
    static List<Person> list= FileCsv.readFile();



    @Override
    public void add(Person person) {
        if (checkNumberPhone(person)){
            list.add(person);
        }
    }

    @Override
    public void update(String numberPhone, Person person) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumberPhone()==numberPhone){
                list.set(i,person);
            }
        }
    }

    @Override
    public void delete(Person person) {
        if (checkNumberPhone(person)){
            list.remove(person);
        }else
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
    }

    @Override
    public List<Person> search(String name) {
        List<Person> personList= new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumberPhone()==name){
                personList.add(list.get(i));
            }
        }
        return personList;
    }
    public boolean checkNumberPhone(Person person){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumberPhone()!= person.getNumberPhone()){
              return true;
            }
        }
        return false;
    }
    public List<Person> findAll(){
        List<Person> list = new ArrayList<>();
        Iterator<Person> iterator= list.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }
    public Person insertInformation(){
        Person person= new Person();
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhập số điện thoại:");
        String number= scanner.next();
        System.out.println("Nhập nhóm :");
        String group= scanner.next();
        System.out.println("Nhập tên :");
        String name= scanner.next();
        System.out.println("Nhập giới tính (Male or Female)");
        String gender= scanner.next();
        System.out.println("Nhập địa chỉ");
        String address= scanner.next();
        System.out.println("Nhập ngày sinh (xx.xx.xxxx):");
        String dateOfBirth= scanner.next();
        System.out.println("Nhập email:");
        String email= scanner.next();
        person.setNumberPhone(number);
        person.setGroup(group);
        person.setName(name);
        person.setGender(gender);
        person.setAddress(address);
        person.setDateOfBirth(dateOfBirth);
        person.setEmail(email);
        return person;
    }

}
