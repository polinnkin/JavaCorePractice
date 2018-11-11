package main.java.com.Module1_JavaLanguage.task4;

/**
 * Student class for Task #4.
 * <p>
 * Student class creates a Student a object with given first name and language class.
 * This class is used in LanguageGroups class.
 *
 * @author Polina Bochkareva
 * @version 1.0 10/16/2018
 */

public class Student {
    public Language language;
    private String first;
    private String last;

    /**
     * construct a new student with given fields
     */
    public Student(String first, String last, Language language) {
        this.first = first;
        this.last = last;
        this.language = language;
    }

    public String getFirstName() {
        return first;
    }

    public void setFirstName(String first) {
        this.first = first;
    }

    public String getLastName() {
        return last;
    }

    public void setLastName(String last) {
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

