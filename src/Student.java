public class Student {
    private String first;        // first name
    private String last;         // last name
    public Language language;     // language class


    // construct a new student with given fields
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
        return "Student{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    enum Language {
        ENGLISH, SPANISH
    }
}

