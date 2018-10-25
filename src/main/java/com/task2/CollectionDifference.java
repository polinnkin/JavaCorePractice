package main.java.com.task2;

import org.apache.commons.collections4.CollectionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
/**
 *  Triangle class for Task #2.
 *
 *  This program finds the uncommon elements from two Collections
 *
 *  @version 1.1 10/15/2018
 *  @author Polina Bochkareva
 */

public class CollectionDifference {
    /**
     * This is the main method which makes use of diff method.
     * @param args Unused.
     * @return Nothing.
     */
    public static void main(String[] args) {
        /** create lists */
        Collection<Character> list1 = new ArrayList<>();
        Collection<Character> list2 = new ArrayList<>();
        Collection<Character> listDiff ;

        /** add elements to the lists */
        list1.add('a');
        list1.add('b');
        list1.add('v');
        list1.add('c');
        list1.add('w');

        list2.add('a');
        list2.add('b');
        list2.add('c');
        list2.add('d');
        list2.add('e');

        /** get uncommon elements */
        listDiff =  diff(list1, list2);
        System.out.println(Arrays.toString(listDiff.toArray()));
    }
    /**
     * This method is used to return uncommon elements from two Collections
     * @param a This is the first parameter to diff method
     * @param b  This is the second parameter to diff method
     * @return TriangleType This returns Collection<Character> object
     */
    private static Collection<Character> diff(Collection<Character> a, Collection<Character> b) {
        Collection<Character> listDiff = CollectionUtils.disjunction(a, b);
        return listDiff;
    }
}

