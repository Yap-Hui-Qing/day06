package src.day06;

public class Myimplementation implements Runnable{
    public void run(){
        RunningThreadCount();
    }

    public void RunningThreadCount(){
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "->" + i);
        }
    }
}
