package authentication;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by tish on 12.04.2014.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите логин:");
        String login = sc.next();
        System.out.println("Введите пароль:");
        String pass = sc.next();
        System.out.println();

        LogIn logIn = new LogIn();
        try {
            logIn.logIn(login, pass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (OutAuthenticationException e) {
            System.exit(0);
            System.out.println("Неверный логин или пароль!");
        } finally {
            System.out.println("afd");
        }
    }
}
