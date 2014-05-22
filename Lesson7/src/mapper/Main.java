package mapper;

import mapper.mpp.DBDataMapper;
import mapper.obj.Car;
import mapper.obj.User;

import java.util.List;

/**
 * Created by tish on 27.04.2014.
 */
public class Main {
    public static void main(String[] args) {

//        FileDataMapper dm = new FileDataMapper();
//
//        rewrite by SecondUser;
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
        User nu2 = new User("Piter", "Pan", 30, 8750);

        Car car0 = new Car("VW", "Golf", 22000);
        Car car1 = new Car("Mercedes", "Vito", 47000);

//        dbdm.save(nu);
//        dbdm.save(nu1);
//        dbdm.save(nu2);

//        dbdm.save(car0);
//        dbdm.save(car1);

        User user = (User) dbdm.load(3, User.class);
        System.out.println(user.getId() + " " + user.getFirstName() + " " + user.getLastName() + " " + user.getAge()
                + " " + user.getSalary());

        System.out.println();
        List<Object> users = dbdm.loadAll(User.class);
        for (int i = 0; i < users.size(); i++) {
            User u = (User) users.get(i);
            System.out.println(u.getId() + " " + u.getFirstName() + " " + u.getLastName() + " " + u.getAge()
                    + " " + u.getSalary());
        }


    }
}
