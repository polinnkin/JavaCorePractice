package com.Module1_JavaLanguage.task4;
/**
 * LanguageGroups class for Task #4.
 * <p>
 * There is a list of students where each student has a first name, last name and studying language.
 * This program divides the list of students into groups of 5 people by studying language.
 *
 * @version 2.0 11/10/2018
 * @author Polina Bochkareva
 */

import java.util.*;
import java.util.stream.Collectors;

public class LanguageGroups {
    /**
     * This is the main method which makes use of div, printResult, printArrayList methods.
     * @param args Unused.
     */
    public static void main(String[] args) {

        // Create students
        Student st1 = new Student("Jane", "Ostin", Language.SPANISH);
        Student st2 = new Student("Lane", "Bryce", Language.ENGLISH);
        Student st3 = new Student("Jude", "Sting", Language.ENGLISH);
        Student st4 = new Student("Mike", "Dre", Language.SPANISH);
        Student st5 = new Student("Cris", "Je", Language.ENGLISH);
        Student st6 = new Student("Elon", "Musk", Language.SPANISH);
        Student st7 = new Student("Jahn", "Ostin", Language.SPANISH);
        Student st8 = new Student("Ann", "Bryce", Language.ENGLISH);
        Student st9 = new Student("Jude", "Lin", Language.ENGLISH);
        Student st10 = new Student("Steve", "Dre", Language.SPANISH);
        Student st11 = new Student("Carl", "Je", Language.ENGLISH);
        Student st12 = new Student("Sir", "Le", Language.SPANISH);

        // Add students to arrayList
        ArrayList<Student> allStudents = new ArrayList<>();

        allStudents.add(st1);
        allStudents.add(st2);
        allStudents.add(st3);
        allStudents.add(st4);
        allStudents.add(st5);
        allStudents.add(st6);
        allStudents.add(st7);
        allStudents.add(st8);
        allStudents.add(st9);
        allStudents.add(st10);
        allStudents.add(st11);
        allStudents.add(st12);

        // Count how many students take SPANISH or ENGLISH class
        int countEng = 0;
        int countSpan = 0;

        for (int i = 0; i < allStudents.size(); i++) {
            if (allStudents.get(i).getLanguage() == Language.ENGLISH) {
                countEng++;
            } else countSpan++;
        }

        // Count how many groups of 5 is going to be.
        int countEngGroup = div(countEng);
        int countSpanGroup = div(countSpan);

        // Create groups for ENGLISH class
        HashMap<String, ArrayList<Student>> engMap = new HashMap<>();
        for (int i = 0; i < countEngGroup; i++) {
            engMap.put("Group" + (i + 1), new ArrayList<Student>());
        }

        // Create groups for SPANISH class
        HashMap<String, ArrayList<Student>> spanMap = new HashMap<>();
        for (int i = 0; i < countSpanGroup; i++) {
            spanMap.put("Group" + (i + 1), new ArrayList<Student>());
        }

        // Track current group number
        int currentEngGroup = 1;
        int currentSpanGroup = 1;

        // Add students to the groups by language
        for (int i = 0; i < allStudents.size(); i++) {
            if (allStudents.get(i).getLanguage() == Language.ENGLISH) {
                if (engMap.get("Group" + currentEngGroup).size() >= 5) {
                    currentEngGroup++;
                }
                engMap.get("Group" + currentEngGroup).add(allStudents.get(i));
            } else {
                if (spanMap.get("Group" + currentSpanGroup).size() >= 5) {
                    currentSpanGroup++;
                }
                spanMap.get("Group" + currentSpanGroup).add(allStudents.get(i));
            }
        }
        // Print the results
        System.out.println();
        printResult(engMap, Language.ENGLISH);
        printResult(spanMap, Language.SPANISH);
    }

    /**
     * This method is used to divides students on group of 5 and return a number of groups
     * @param numOfStudents This is the first parameter to div method
     * @return int This returns numbers of groups of 5 depending on a number of students
     */
    private static int div(int numOfStudents) {
        int result;
        if (numOfStudents > 0 && numOfStudents < 5)
            result = 1;
        else if (numOfStudents % 5 > 0)
            result = numOfStudents / 5 + 1;
        else
            result = numOfStudents / 5;
        return result;
    }

    /**
     * This method is used to print the list of students by studying language
     * where the list is divided into groups of 5 students.
     * @param map This is the first parameter to printResult method
     * @param lang This is the second parameter to printResult method
     */
    private static void printResult(HashMap<String, ArrayList<Student>> map, Language lang) {
        System.out.println("List of groups for " + lang + " class:");
        for (Map.Entry<String, ArrayList<Student>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":");
            printArrayList(entry.getValue());
        }
        System.out.println("***************");
    }

    /**
     * This method is used to print ArrayList
     * @param studentList This is the first parameter to printArrayList method
     */
    private static void printArrayList(List<Student> studentList) {
        studentList = sortStudents(studentList);
        for (Student student : studentList) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
    }

    /**
     * This method sort an object of List<Student> by last name and first name of students in alphabetical order
     * @param studentList This is the first parameter to printArrayList method
     * @return List<Student> Sorted list of students
     */
    private static List<Student> sortStudents(List<Student> studentList) {
        return studentList.stream().sorted(Comparator.comparing(Student::getLastName).
                thenComparing(Student::getFirstName)).collect(Collectors.toList());
    }
}
