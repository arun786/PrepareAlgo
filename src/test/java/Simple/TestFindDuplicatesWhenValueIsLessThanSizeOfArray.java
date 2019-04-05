package Simple;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestFindDuplicatesWhenValueIsLessThanSizeOfArray {


    private FindDuplicatesWhenValuesAreLessThanSizeOfArray findDuplicatesWhenValuesAreLessThanSizeOfArray;

    @Before
    public void setUp() {
        findDuplicatesWhenValuesAreLessThanSizeOfArray = new FindDuplicatesWhenValuesAreLessThanSizeOfArray();
    }


    @Test
    public void findDuplicatesWhenValueIsLessThanSizeOfArray() {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(3);
        numbers.add(3);
        numbers.add(4);
        numbers.add(4);
        List<Integer> duplicates = findDuplicatesWhenValuesAreLessThanSizeOfArray.findDuplicatesWhenValueIsLessThanSizeOfArray(numbers);

        assertTrue(3 == duplicates.get(0));
        assertTrue(4 == duplicates.get(1));

        numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(1);
        numbers.add(3);
        numbers.add(2);
        numbers.add(3);
        List<Integer> duplicates1 = findDuplicatesWhenValuesAreLessThanSizeOfArray.findDuplicatesWhenValueIsLessThanSizeOfArray(numbers);

        assertTrue(1 == duplicates1.get(0));
        assertTrue(3 == duplicates1.get(1));


    }
}
