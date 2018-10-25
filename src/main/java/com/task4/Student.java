package main.java.com.task4;
/**
 *  Student class for Task #4.
 *
 *  Student class creates a Student a object with given first name and language class.
 *  This class is used in LanguageGroups class.
 *
 *  @version 1.0 10/16/2018
 *  @author Polina Bochkareva
 */

public class Student {
    private String first;
    private String last;
    public Language language;

    /** construct a new student with given fields */
    public Student(String first, String last, Language language) {
        this.first = first;
        this.last = last;
        this.language = language;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Student{" + "first='" + first + '\'' + ", last='" + last + '\'' + ", language='" + language + '\'' +
                '}';
    }
}

