package endless.overlook.webfluxsupplier.methodreference;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Description:<b></b>
 *
 * @author LKL
 * @since 1/8/21 9:52 PM
 **/
public class MethodReference01 {

    public static void main(String[] args) {
        Person person = new Person("Ralph", 30);
        Supplier<String> supplier = person::getName;
        System.out.println(supplier.get());

        Consumer<String> consumer = person::setName;
        consumer.accept("Ralph1");
        System.out.println(supplier.get());

    }
}

class Person {
    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}