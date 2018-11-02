package main.java.com.Module1_JavaLanguage.task3;

import java.io.*;
/**
 *  SCV_File class for Task #3
 *
 *  This program reads a list of contacts from a CSV file where data has following format: Котечкин,Арнольд,123456789 ;
 *  It save this list into another CSV file changing names to initials. Ex: Котечкин,А,123456789 .
 *
 *  @version 1.1 10/12/2018
 *  @author Polina Bochkareva
 */
public class SCV_File {
    private static final String INPUT_FILE = "./src/main/resources/in.csv";
    private static final String OUTPUT_FILE = "./src/main/resources/out.csv";
    private static String csvSplitter = ",";
    private static String line;
    /**
     * This is the main method which reads a list of from a CSV file and writes into another CSV file
     *  changing format of list content.
     * @param args Unused.
     * @return Nothing.
     */
    public static void main(String[] args) throws IOException {
        File inputFile = new File(INPUT_FILE);
        PrintWriter out = new PrintWriter(new File(OUTPUT_FILE));

        if (inputFile.exists()){
            BufferedReader br = new BufferedReader(new FileReader(inputFile));

            /** read from input file and write to output file */
            if (br.readLine() == null) {
                System.out.println(INPUT_FILE + " file is empty");
            }
            else {
                while ((line = br.readLine()) != null) {
                    String[] cols = line.split(csvSplitter);
                    cols[1] = Character.toString(cols[1].charAt(0));
                    System.out.println(cols[0] + csvSplitter + cols[1] + csvSplitter + cols[2]);
                    out.println(cols[0] + csvSplitter + cols[1] + csvSplitter + cols[2]);
                }
                out.close();
            }
        }
        else {
            System.out.println("Couldn't find " + INPUT_FILE + " file in the directory.");
        }
    }
}
