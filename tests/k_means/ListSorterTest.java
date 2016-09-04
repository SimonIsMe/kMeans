package k_means;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListSorterTest
{
    @Test
    public void testWitEmptyList()
    {
        ListSorter listSorter = new ListSorter();

        LinkedList<double[]> list = new LinkedList<>();
        List<double[]> sortedList = listSorter.sortList(list);

        assertEquals(list.size(), sortedList.size());
        assertTrue(list != sortedList);
    }

    @Test
    public void testWitOneElementOnTheList()
    {
        ListSorter listSorter = new ListSorter();

        LinkedList<double[]> list = new LinkedList<>();
        list.add(new double[]{1, 2, 3});
        List<double[]> sortedList = listSorter.sortList(list);

        assertEquals(list.size(), sortedList.size());
        assertEquals(1.0, sortedList.get(0)[0]);
        assertEquals(2.0, sortedList.get(0)[1]);
        assertEquals(3.0, sortedList.get(0)[2]);
        assertTrue(list != sortedList);
    }

    @Test
    public void testWitFiveElementOnTheList()
    {
        ListSorter listSorter = new ListSorter();

        LinkedList<double[]> list = new LinkedList<>();
        list.add(new double[]{4, 4});
        list.add(new double[]{2, 2});
        list.add(new double[]{1, 1});
        list.add(new double[]{3, 3});
        list.add(new double[]{5, 5});
        List<double[]> sortedList = listSorter.sortList(list);

        assertEquals(list.size(), sortedList.size());
        assertEquals(1.0, sortedList.get(0)[0]);
        assertEquals(2.0, sortedList.get(1)[0]);
        assertEquals(3.0, sortedList.get(2)[0]);
        assertEquals(4.0, sortedList.get(3)[0]);
        assertEquals(5.0, sortedList.get(4)[0]);
        assertTrue(list != sortedList);
    }

    @Test
    public void testWitFiveElementOnTheListInCorrectOrder()
    {
        ListSorter listSorter = new ListSorter();

        LinkedList<double[]> list = new LinkedList<>();
        list.add(new double[]{1, 1});
        list.add(new double[]{2, 2});
        list.add(new double[]{3, 3});
        list.add(new double[]{4, 4});
        list.add(new double[]{5, 5});
        List<double[]> sortedList = listSorter.sortList(list);

        assertEquals(list.size(), sortedList.size());
        assertEquals(1.0, sortedList.get(0)[0]);
        assertEquals(2.0, sortedList.get(1)[0]);
        assertEquals(3.0, sortedList.get(2)[0]);
        assertEquals(4.0, sortedList.get(3)[0]);
        assertEquals(5.0, sortedList.get(4)[0]);
        assertTrue(list != sortedList);
    }

    @Test
    public void testWitFiveElementOnTheListInReverseOrder()
    {
        ListSorter listSorter = new ListSorter();

        LinkedList<double[]> list = new LinkedList<>();
        list.add(new double[]{5, 5});
        list.add(new double[]{4, 4});
        list.add(new double[]{3, 3});
        list.add(new double[]{2, 2});
        list.add(new double[]{1, 1});
        List<double[]> sortedList = listSorter.sortList(list);

        assertEquals(list.size(), sortedList.size());
        assertEquals(1.0, sortedList.get(0)[0]);
        assertEquals(2.0, sortedList.get(1)[0]);
        assertEquals(3.0, sortedList.get(2)[0]);
        assertEquals(4.0, sortedList.get(3)[0]);
        assertEquals(5.0, sortedList.get(4)[0]);
        assertTrue(list != sortedList);
    }
}