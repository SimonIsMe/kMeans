package k_means;

import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ListComparatorTest
{

    @Test
    public void testIsTheSameListWithTwoEmptyLists()
    {
        ListComparator listComparator = new ListComparator();
        boolean result = listComparator.isTheSameList(new LinkedList<double[]>(), new LinkedList<double[]>());
        assertTrue(result);
    }

    @Test
    public void testIsTheSameListWithListsWithOneElement()
    {
        LinkedList<double[]> listA = new LinkedList<>();
        listA.add(new double[]{1, 2, 3});

        LinkedList<double[]> listB = new LinkedList<>();
        listB.add(new double[]{1, 2, 3});

        ListComparator listComparator = new ListComparator();
        boolean result = listComparator.isTheSameList(listA, listB);
        assertTrue(result);
    }

    @Test
    public void testIsTheSameListWithListsWithFiveElement()
    {
        LinkedList<double[]> listA = new LinkedList<>();
        listA.add(new double[]{1, 2, 3});
        listA.add(new double[]{10, 20, 30});
        listA.add(new double[]{100, 200, 300});
        listA.add(new double[]{1000, 2000, 3000});
        listA.add(new double[]{10000, 20000, 30000});

        LinkedList<double[]> listB = new LinkedList<>();
        listB.add(new double[]{1000, 2000, 3000});
        listB.add(new double[]{100, 200, 300});
        listB.add(new double[]{1, 2, 3});
        listB.add(new double[]{10000, 20000, 30000});
        listB.add(new double[]{10, 20, 30});

        ListComparator listComparator = new ListComparator();
        boolean result = listComparator.isTheSameList(listA, listB);
        assertTrue(result);
    }

    @Test
    public void testIsTheSameListWithDifferentListsWithThreeElement()
    {
        LinkedList<double[]> listA = new LinkedList<>();
        listA.add(new double[]{11111111, 2, 3});
        listA.add(new double[]{10, 20, 30});
        listA.add(new double[]{100, 200, 300});

        LinkedList<double[]> listB = new LinkedList<>();
        listB.add(new double[]{100, 200, 300});
        listB.add(new double[]{1, 2, 3});
        listB.add(new double[]{10, 20, 30});

        ListComparator listComparator = new ListComparator();
        boolean result = listComparator.isTheSameList(listA, listB);
        assertFalse(result);
    }

}