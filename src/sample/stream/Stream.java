package sample.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Employee employee1 = new Employee("Edyta", "Karpowicz", 21, List.of("Java", "Spring", "SQL"));
        Employee employee2 = new Employee("Bartłomiej", "Dettlaff", 25, List.of("Java", "Spring", "SQL", "Kubernetes"));
        Employee employee3 = new Employee("Weronika", "Karpowicz", 26, List.of("cos", "aaa", "SQL"));
        Employee employee4 = new Employee("Bartek", "Frąś", 27, List.of("haha", "hyyh", "thth"));
        Employee employee5 = new Employee("Rafał", "Majchrzak", 29, List.of("Java", "thht", "net"));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        firstStream();
        System.out.println("===============");
        secondStream();
        System.out.println("===============");
        secondStream1();
        System.out.println("===============");
        s4();
        System.out.println("===============");
        s5();
        System.out.println("===============");
        s6();
        System.out.println("===============");
        s7();
        System.out.println("===============");
        s8();
        System.out.println("===============");
        s9();
        System.out.println("===============");
        s11();
        System.out.println("===============");
        s12();
        System.out.println("===============");
        s13();
        System.out.println("===============");
        s14();
        System.out.println("===============");
        takeWhileOperation();
        System.out.println("===============");
        dropWhileOperation();
        System.out.println("===============");
        forEachOrdered();
//        peek();

    }

    private static void peek() {
        employees.stream()
                .peek(employee -> employee.setFirstName("Kamil"))
                .collect(Collectors.toList());
    }

    private static void forEachOrdered() {
        String sentence = "Jak nauczyć się programowania? ";
        sentence.chars().forEach(s -> System.out.print((char) s));
        System.out.println();
        sentence.chars().parallel().forEach(s -> System.out.print((char) s));
        sentence.chars().parallel().forEachOrdered(s -> System.out.print((char) s));

    }

    private static void dropWhileOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .dropWhile(employee -> employee.getAge() < 22)
                .forEach(System.out::println);
    }

    private static void takeWhileOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .takeWhile(employee -> employee.getAge() < 30)
                .forEach(System.out::println);
    }

    private static void s14() {
        Integer sum3 = employees.stream()
                .reduce(0, (age, employee) -> age + employee.getAge(), Integer::sum);

        System.out.println(sum3);
        employees.stream()
                .map(Employee::getFirstName)
                .reduce((name, name2) -> name + ", " + name2)
                .get();
    }

    private static void s13() {
        Integer sumOfAllAges = employees.stream()
                .map(Employee::getAge)
                .reduce(Integer::sum)
                .get();

        System.out.println(sumOfAllAges);

        Integer sumOFALLL = employees.stream()
                .map(Employee::getAge)
                .reduce(0, Integer::sum);

        System.out.println(sumOFALLL);

    }

    private static void s12() {
        boolean b = employees.stream()
                .allMatch(emp -> emp.getFirstName().contains("a"));
        System.out.println(b);
    }

    private static void s11() {
        Employee employee1 = employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("B"))
                .findAny().get();
        System.out.println(employee1);
    }

    private static void s10() {
        Employee youngestEmployee = employees.stream()
                .min(Comparator.comparing(Employee::getAge)).get();
        System.out.println(youngestEmployee);

    }

    private static void s9() {
        long numberOfEmployees = employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("B"))
                .count();
        System.out.println(numberOfEmployees);
    }

    private static void s8() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .skip(2)
                .forEach(System.out::println);
    }

    private static void s7() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .limit(2)
                .forEach(System.out::println);
    }

    private static void s6() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .forEach(System.out::println);
    }

    private static void s5() {
        employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("E"))
                .forEach(System.out::println);
    }

    private static void s4() {
        List<List<String>> allSkills = employees.stream()
                .map(Employee::getListOfLanguages)
                .collect(Collectors.toList());

        System.out.println(allSkills);

        List<String> allSkills2 = employees.stream()
                .map(Employee::getListOfLanguages)
                .flatMap(list -> list.stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(allSkills2);
    }

    private static void secondStream1() {
        employees.stream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    private static void secondStream() {
        employees.stream()
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .forEach(System.out::println);
    }


    private static void firstStream() {
        employees.stream()
                .forEach(employee -> System.out.println(employee));
        employees.stream()
                .forEach(System.out::println);
    }


}
