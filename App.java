
// compile (in the project root folder)
// bin contains the compiled files
// javac -d bin --source-path . ./*.java

// run

// package to jar

// run the jar

import src.day06.MyInterface;
import src.day06.Myimplementation;
import src.day06.Product;
import src.day06.Person;
import src.day06.MyInterface;

import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class App {

    public static void main(String[] args) {

        // Thread th = new Thread(new Runnable() {

        // public void run(){
        // for (int i = 0; i < 10; i++){
        // System.out.println(Thread.currentThread().getName() + "->" + i);
        // }
        // }
        // }
        // );

        // // for thread to run
        // th.start();

        // Myimplementation my1 = new Myimplementation();
        // Myimplementation my2 = new Myimplementation();
        // Myimplementation my3 = new Myimplementation();
        // Myimplementation my4 = new Myimplementation();
        // Myimplementation my5 = new Myimplementation();

        // ExecutorService es = Executors.newSingleThreadExecutor();
        // es.execute(my1);
        // es.execute(my2);
        // es.shutdown();

        // execute the tasks using fixed thread pool
        // ExecutorService es1 = Executors.newFixedThreadPool(5);
        // es1.execute(my1);
        // es1.execute(my2);
        // es1.execute(my3);
        // es1.execute(my4);
        // es1.execute(my5);
        // es1.shutdown();

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Apple iPad", "Apple tabled", "Computer"));
        products.add(new Product(2L, "Apple Macbook Pro", "Apple laptop", "Computer"));
        products.add(new Product(3L, "Huawei 5", "Huawei phone", "Mobile"));
        products.add(new Product(4L, "Oppo Reno", "Oppo phone", "Mobile"));

        // products.forEach(prod -> {
        // System.out.println(prod);
        // }
        // );

        // alternative way to print
        // products.forEach(Product::print);
        // System.out.println();

        // only retrieve products with category 'mobile'
        // use stream and lambda functions
        List<Product> mobileProducts = new ArrayList<>();
        mobileProducts = products
                .stream() // turn collection into stream
                .filter(p -> p.getCategory().equals("Mobile")) // filter category
                .collect(Collectors.toList()); // aggregate result

        // mobileProducts.forEach(Product::print);
        // System.out.println();

        //LocalDate.of(year, month, day)
        LocalDate ld = LocalDate.of(1990,1,12);
        Date currentDate = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person(1L,"Bernard","Tan",3000.0, currentDate));
        persons.add(new Person(2L,"Chris","Tan",2000.0, currentDate));
        persons.add(new Person(3L,"Denise","Tan",1500.0, currentDate));
        persons.add(new Person(4L,"Brandon","Wong",3500.0, currentDate));
        persons.add(new Person(5L,"Richard","Lim",3200.0, currentDate));
        persons.add(new Person(6L,"Francis","Ng",2500.0, currentDate));
        persons.add(new Person(7L,"Michael","Loh",2800.0, currentDate));

        // use comparator to do sorting
        // compare by one column
        Comparator<Person> compare = Comparator.comparing(p -> p.getFirstName());
        persons.sort(compare.reversed()); // sort in descending -- compare.reversed()
        // persons.forEach(p -> {
        //     System.out.println(p.toString());
        // });
        // System.out.println();

        // multiple columns sorting
        Comparator<Person> compareMultiple = Comparator.comparing(Person::getFirstName)
            .thenComparing(Person::getLastName);
        persons.sort(compareMultiple);
        // persons.forEach(p -> {
        //     System.out.println(p.toString());
        // });

        MyInterface<Integer> addOperation = (a,b) -> {
            return a + b;
        };

        MyInterface<Integer> multiplicationOperation = (a,b) -> {
            return a*b;
        };

        System.out.println("add Operation " + addOperation.process(3,2));
        System.out.println("multiplication Operation " + multiplicationOperation.process(3,2));


    }
}