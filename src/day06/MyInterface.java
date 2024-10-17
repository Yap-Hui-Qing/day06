package src.day06;

@FunctionalInterface
public interface MyInterface<T> {

    T process(T a, T b);
    
    // put implementation into separate class or put inside main function
}
