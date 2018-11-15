package main.java.com.Module1_JavaLanguage.task2;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Triangle class for Task #2.
 * <p>
 * This program finds the uncommon elements from two Collections
 *
 * @author Polina Bochkareva
 * @version 1.1 10/15/2018
 */

public class CollectionDifference {
    /**
     * This is the main method which makes use of diff method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // create 2 Collections of ArrayList
        Collection<Character> list1 = new ArrayList<>();
        Collection<Character> list2 = new ArrayList<>();
        Collection<Character> listDiff;

        // add elements to the lists
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

        // get uncommon elements
        listDiff = diff(list1, list2);
        System.out.println(Arrays.toString(listDiff.toArray()));
    }

    /**
     * This method is used to return uncommon elements from two Collections
     *
     * @param a This is the first parameter to diff method
     * @param b This is the second parameter to diff method
     * @return TriangleType This returns Collection<Character> object
     */
    private static Collection<Character> diff(Collection<Character> a, Collection<Character> b) {
        return CollectionUtils.disjunction(a, b);
    }
}

