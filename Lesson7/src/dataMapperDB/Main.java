package dataMapperDB;

/**
 * Created by tish on 27.04.2014.
 */
public class Main {
    public static void main(String[] args) {
//        FileDataMapper dm = new FileDataMapper();
//
//        User u0 = new User("Alex", 7800);
//        User u1 = new User("Max", 5500);
//        User u2 = new User("Pit", 2100);
//        User u3 = new User("Brad", 500);
//        User u4 = new User("Tom", 3500);

//        dm.save(u0);
//        dm.save(u1);
//        dm.save(u2);
//        dm.save(u3);
//        dm.save(u4);
//
//        User u = (User) dm.load(2, User.class);
//        System.out.println(u.getId() + " " + u.getName() + " " + u.getSalary());
//
//        System.out.println();
//        List<Object> all = dm.loadAll(User.class);
//        for (int i = 0; i < all.size(); i++) {
//            User user = (User) all.get(i);
//            System.out.println(user.getId() + " " + user.getName() + " " + user.getSalary());
//        }

        DBDataMapper dbdm = new DBDataMapper();

        User nu = new User("Kolia", "Loboda", 22, 5000);
        User nu1 = new User("Clark", "Kent", 24, 3750);

        Car car = new Car("VW", "Golf", 22000);
        Car car1 = new Car("Mercedes", "Vito", 47000);

//        dbdm.save(nu);
//        dbdm.save(car);

//        dbdm.save(nu1);
//        dbdm.save(car1);


    }
}
