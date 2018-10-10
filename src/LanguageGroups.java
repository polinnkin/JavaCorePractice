// Task $4
// There is a list of students.
// Each student has a first name, last name and studying language.
// This program divides the list of students into groups of 5 people by studying language.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LanguageGroups {

    public static void main(String[] args) {

        // Create students
        Student st1 = new Student("Jane", "Ostin", Student.Language.SPANISH);
        Student st2 = new Student("Lane", "Bryce", Student.Language.ENGLISH);
        Student st3 = new Student("Jude", "Sting", Student.Language.ENGLISH);
        Student st4 = new Student("Mike", "Dre", Student.Language.SPANISH);
        Student st5 = new Student("Cris", "Je", Student.Language.ENGLISH);
        Student st6 = new Student("Elon", "Musk", Student.Language.SPANISH);
        Student st7 = new Student("Jahn", "Ostin", Student.Language.SPANISH);
        Student st8 = new Student("Ann", "Bryce", Student.Language.ENGLISH);
        Student st9 = new Student("Jude", "Lin", Student.Language.ENGLISH);
        Student st10 = new Student("Steve", "Dre", Student.Language.SPANISH);
        Student st11 = new Student("Carl", "Je", Student.Language.ENGLISH);
        Student st12 = new Student("Sir", "Le", Student.Language.SPANISH);

        // add students to arrayList
        ArrayList<Student> allStudents = new ArrayList<Student>();

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
        int coundSpan = 0;

        for (int i = 0; i < allStudents.size(); i++) {
            if(allStudents.get(i).getLanguage() == Student.Language.ENGLISH){
                countEng++;
            }
            else coundSpan++;
        }

        // Count how many groups of 5 is going to be.
        int countEngGroup = div(countEng);
        int countSpanGroup = div(coundSpan);

        // Create groups for ENGLISH class
        HashMap<String, ArrayList<Student>> engMap = new HashMap<>();
        for (int i = 0; i < countEngGroup; i++) {
            engMap.put("Group" + (i+1), new ArrayList<Student>());
        }

        // Create groups for SPANISH class
        HashMap<String, ArrayList<Student>> spanMap = new HashMap<>();
        for (int i = 0; i < countSpanGroup; i++) {
            spanMap.put("Group" + (i+1), new ArrayList<Student>());
        }

        // Track current group number
        int currentEngGroup = 1;
        int currentSpanGroup = 1;

        // Add students to the groups by language
        for (int i = 0; i < allStudents.size(); i++) {
            if (allStudents.get(i).getLanguage() == Student.Language.ENGLISH) {
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
        printResult(engMap, Student.Language.ENGLISH);
        printResult(spanMap, Student.Language.SPANISH);

    }

    // Divide students on group of 5 and return a number of groups
    static int div(int numOfStudents){
        int result;
        if(numOfStudents > 0 && numOfStudents < 5)
            result = 1;
        else if (numOfStudents  %  5 > 0 )
            result = numOfStudents / 5 + 1;
        else
            result = numOfStudents / 5;
        return result;

    }

    static void printResult(HashMap <String, ArrayList<Student>> map, Student.Language lang){

        System.out.println("List of groups for " + lang + " class:");
        for (Map.Entry<String, ArrayList<Student>> entry : map.entrySet()) {
            System.out.println(entry.getKey()+ ":");
            printArrayList(entry.getValue());
        }
        System.out.println("***************");
    }

    static void printArrayList(ArrayList<Student> list){
        for(Student student : list) {
            System.out.println(student.getFirst() + " " + student.getLast());
        }
    }
}
