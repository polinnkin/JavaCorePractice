// Task #3
// There is a CSV file that contains a list of contacts. Ex: Котечкин,Арнольд,123456789
// Save this list into another CSV file changing names to initials. Ex: Котечкин,А,123456789

import java.io.*;

public class SCV_File {

    public static void main(String[] args) throws IOException {
        String csvSplitter = ",";
        BufferedReader br = new BufferedReader(new FileReader("/Users/pbochkareva/IdeaProjects/JavaCorePractice/src/ContactList1.csv"));
        PrintWriter out = new PrintWriter(new File ("/Users/pbochkareva/IdeaProjects/JavaCorePractice/src/ContactList2.csv"));
        String line;
        // read from input file and write to output file
        while ((line = br.readLine()) != null) {
            String[] cols = line.split(csvSplitter);
            cols[1] = Character.toString(cols[1].charAt(0));
            out.println(cols[0] + csvSplitter + cols[1] + csvSplitter + cols[2]);
        }
        out.close();
    }
}
