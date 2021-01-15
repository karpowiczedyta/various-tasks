package sample.stream;

import java.util.List;

public class Employee {
    String firstName;
    String lastName;
    int age;
    List<String> listOfLanguages;

    public Employee(String firstName, String lastName, int age, List<String> listOfLanguages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.listOfLanguages = listOfLanguages;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getListOfLanguages() {
        return listOfLanguages;
    }

    public void setListOfLanguages(List<String> listOfLanguages) {
        this.listOfLanguages = listOfLanguages;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", listOfLanguages=" + listOfLanguages +
                '}';
    }
}
