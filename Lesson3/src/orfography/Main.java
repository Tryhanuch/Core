package orfography;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tish on 26.04.2014.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File fCheck = new File("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson3\\src\\orfography\\FCheck.txt");
        Scanner sCheck = new Scanner(fCheck);
        ArrayList<String> words = new ArrayList<>();

        while (sCheck.hasNextLine()){
            String[] strings = sCheck.nextLine().split(" ");
            for(String s: strings) {
                words.add(s);
            }
        }

        try {
            Compare.checkAL(words);
            Compare.checkLL(words);
            Compare.checkHS(words);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
