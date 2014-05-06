package orfography;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by tish on 26.04.2014.
 */
public class Compare {

    public static void checkAL(ArrayList<String> words) throws FileNotFoundException {

//        File fCheck = new File("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson3\\src\\orfography\\FCheck.txt");
//        Scanner sCheck = new Scanner(fCheck);
//        ArrayList<String> words = new ArrayList<>();
//
//        while (sCheck.hasNextLine()){
//            String[] strings = sCheck.nextLine().split(" ");
//            for(String s: strings) {
//                words.add(s);
//            }
//        }

        File fDict = new File("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson3\\src\\orfography\\FDictionry.txt");
        Scanner sDict = new Scanner(fDict);
        ArrayList<String> checkWords = new ArrayList<>();
        int count = 0;

        while (sDict.hasNextLine()){
            String[] strings = sDict.nextLine().split(" ");
            for(String s: strings) {
                checkWords.add(s);
            }
        }

        long begin = System.nanoTime();

        for (String word : words) {
            if (checkWords.contains(word)) {
                count++;
            }
        }

//        for (String word : words) {
//            for (String checkWord : checkWords) {
//                if (word.equals(checkWord)) {
//                    count++;
//                }
//            }
//        }

        System.out.println("Size " + checkWords.size());
        System.out.println("Check " + count);
        System.out.println("ArrayList");
        long end = System.nanoTime();
        System.out.println((double)(end - begin) / 10000);
        System.out.println();
    }

    public static void checkLL(ArrayList<String> words) throws FileNotFoundException {

//        File fCheck = new File("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson3\\src\\orfography\\FCheck.txt");
//        Scanner sCheck = new Scanner(fCheck);
//        ArrayList<String> words = new ArrayList<>();
//
//        while (sCheck.hasNextLine()){
//            String[] strings = sCheck.nextLine().split(" ");
//            for(String s: strings) {
//                words.add(s);
//            }
//        }

        File fDict = new File("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson3\\src\\orfography\\FDictionry.txt");
        Scanner sDict = new Scanner(fDict);
        LinkedList<String> checkWords = new LinkedList<>();
        int count = 0;

        while (sDict.hasNextLine()){
            String[] strings = sDict.nextLine().split(" ");
            for(String s: strings) {
                checkWords.add(s);
            }
        }

        long begin = System.nanoTime();

        for (String word : words) {
            if (checkWords.contains(word)) {
                count++;
            }
        }

        System.out.println("Size " + checkWords.size());
        System.out.println("Check " + count);
        System.out.println("LinkedList");
        long end = System.nanoTime();
        System.out.println((double)(end - begin) / 10000);
        System.out.println();
    }

    public static void checkHS(ArrayList<String> words) throws FileNotFoundException {

//        File fCheck = new File("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson3\\src\\orfography\\FCheck.txt");
//        Scanner sCheck = new Scanner(fCheck);
//        ArrayList<String> words = new ArrayList<>();
//
//        while (sCheck.hasNextLine()){
//            String[] strings = sCheck.nextLine().split(" ");
//            for(String s: strings) {
//                words.add(s);
//            }
//        }

        File fDict = new File("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson3\\src\\orfography\\FDictionry.txt");
        Scanner sDict = new Scanner(fDict);
        HashSet<String> checkWords = new HashSet<>();
        int count = 0;

        while (sDict.hasNextLine()){
            String[] strings = sDict.nextLine().split(" ");
            for(String s: strings) {
                checkWords.add(s);
            }
        }

        long begin = System.nanoTime();

        for (String word : words) {
            if (checkWords.contains(word)) {
                count++;
            }
        }

//        Iterator<String> iter = checkWords.iterator();
//        while (iter.hasNext()){
//            String element = iter.next();
//            System.out.println(element);
//        }

//        for (String word : words) {
//            for (String checkWord : checkWords) {
//                if (word.contains(checkWord)) {
//                    count++;
//                }
//            }
//        }

        System.out.println("Size " + checkWords.size());
        System.out.println("Check " + count);
        System.out.println("HashSet");
        long end = System.nanoTime();
        System.out.println((double)(end - begin) / 10000);
        System.out.println();
    }

}
