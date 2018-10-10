import org.apache.commons.collections4.CollectionUtils;
import java.util.Collection;

// Task #2 Find the uncommon elements from two Collections

public class CollectionDifference {
    public static Collection<Character> diff(Collection<Character> a, Collection<Character> b) {
         return CollectionUtils.disjunction(a, b);
    }
}
