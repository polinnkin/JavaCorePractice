package main.java.com.Module2_CorePlatform.task3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Palindrome class for Task #3.
 * <p>
 * This program reads from a text file, finds all phone numbers in a format +10234567890 or +1023-456-7890,
 * and writes all found phone numbers in a file using format +10234567890 and removing duplicate phone numbers.
 *
 * @author Polina Bochkareva
 * @version 1.0 11/10/2018
 */

public class PhoneNumbers {

    private static final String INPUT_FILE = "./src/main/resources/phoneNumbersIn.txt";
    private static final String OUTPUT_FILE = "./src/main/resources/phoneNumbersOut.txt";

    /**
     * This is the main method which makes use of save method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {

        File fileIn = new File(INPUT_FILE);
        Set<String> setOfNumbers = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileIn))) {
            // Regular expression for mobile number
            Pattern p = Pattern.compile("\\+[0-9]{4}(-[0-9]{3}-|[0-9]{3})[0-9]{4}");

            // BufferedReader for reading from phoneNumbersIn.txt file

            String line = br.readLine();

            while (line != null) {
                Matcher m = p.matcher(line);

                while (m.find()) {
                    // Write the mobile number to phoneNumbersOut.txt file
                    String number = m.group().replaceAll("[-]", "");
                    setOfNumbers.add(number);
                }
                line = br.readLine();
            }
            save(setOfNumbers, OUTPUT_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to save a Set object in a file
     *
     * @param obj  This is the first parameter to save method
     * @param path This is the second parameter to save method
     */
    private static void save(Set<String> obj, String path) throws Exception {
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"))) {
            for (String s : obj) {
                pw.println(s);
            }
            pw.flush();
        }
    }
}
