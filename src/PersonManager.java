import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PersonManager implements IContact<Person> {
    static List<Person> list;
    static {
        list= new ArrayList<>();
        list.add(new Person("0964068256","HY","Nguyen","Male","Hung Yen","6.12.1998","tuananh@gmail.com"));
        list.add(new Person("0888888888","HY","Anh","Male","Ha Noi","6.6.1998","tuananh@gmail.com"));
    }



    @Override
    public void add(Person person) {
        if (!checkNumberPhone(person.getNumberPhone())){
            list.add(person);
        }else System.out.println("Số điện thoại này đã có chủ");
    }

    @Override
    public void update(String numberPhone, Person person) {
        if (checkNumberPhone(numberPhone)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getNumberPhone() == numberPhone) {
                    list.set(i, person);
                }
            }
        }
    }

    @Override
    public List<Person> delete(String numberPhone) {
        if (checkNumberPhone(numberPhone)){
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getNumberPhone()== numberPhone){
                    list.remove(list.get(i));
                }
            }
        }
        return list;
    }

    @Override
    public List<Person> searchByName(String name) {
        List<Person> personList= new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumberPhone()==name){
                personList.add(list.get(i));
            }
        }
        return personList;
    }
    public boolean checkNumberPhone(String numberPhone){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumberPhone().equals(numberPhone)){
              return true;
            }
        }
        return false;
    }
    public List<Person> findAll(){
        List<Person> list1 = new ArrayList<>();
        Iterator<Person> iterator= list.iterator();
        while (iterator.hasNext()){
            list1.add(iterator.next());
        }
        return list1;
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
