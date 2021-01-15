package sample.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJavaStart {

    public static void main(String[] args) {
        Stream<Integer> iterate = Stream.iterate(1, n -> n + 1);
        iterate.forEach(n -> System.out.println(n));

        List<String> names = Arrays.asList("Edyta", "Wera");
        names.stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return s.endsWith("a");
                    }
                });


        List<String> names1 = Arrays.asList("Edyta", "Wera");

        List<User> userList = names1.stream()
                .filter(user -> user.endsWith("a"))
                .map(string -> new User(string, new Random().nextInt(70)))
                .sorted(Comparator.comparing(User::getName).reversed())
                .collect(Collectors.toList());

        System.out.println(userList);

    }
}

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
