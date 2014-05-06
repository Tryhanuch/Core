package exception;

/**
 * Created by tish on 12.04.2014.
 */
public class Worker {
    private String name;
    private int age;
    private int salary;

    public void test(){
        if (age == 0){
            throw new MyException();  //throw - генерирует исключение KirkorovException
        }
    }

    public void test2() throws ControlException {
        if (age == 0){
            throw new ControlException();
        }
    }
}
