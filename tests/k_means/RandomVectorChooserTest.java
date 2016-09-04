package k_means;

import org.junit.Test;

import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;

public class RandomVectorChooserTest
{

    @Test
    public void testGenerateRandomPointsForEmptyList() throws Exception
    {
        RandomVectorChooser randomVectorChooser = new RandomVectorChooser();
        LinkedList<double[]> randomPoints = randomVectorChooser.generateRandomPoints(new LinkedList<>(), 0);

        assertEquals(0, randomPoints.size());
    }

    @Test
    public void testGenerateRandomPointsForOneElementList() throws Exception
    {
        LinkedList<double[]> list = new LinkedList<>();
        list.add(new double[]{1, 2, 3});

        RandomVectorChooser randomVectorChooser = new RandomVectorChooser();
        LinkedList<double[]> randomPoints = randomVectorChooser.generateRandomPoints(list, 1);

        assertEquals(1, randomPoints.size());
        assertEquals(1.0, randomPoints.get(0)[0]);
    }

    @Test
    public void testGenerateRandomPointsForFiveElementList() throws Exception
    {
        LinkedList<double[]> list = new LinkedList<>();
        list.add(new double[]{1, 1});
        list.add(new double[]{2, 2});
        list.add(new double[]{3, 3});
        list.add(new double[]{4, 4});
        list.add(new double[]{5, 5});

        RandomVectorChooser randomVectorChooser = new RandomVectorChooser();
        LinkedList<double[]> randomPoints = randomVectorChooser.generateRandomPoints(list, 3);

        assertEquals(3, randomPoints.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateRandomPointsForTooManyGroupsRequest() throws Exception
    {
        LinkedList<double[]> list = new LinkedList<>();
        list.add(new double[]{1, 1});
        list.add(new double[]{2, 2});
        list.add(new double[]{3, 3});
        list.add(new double[]{4, 4});
        list.add(new double[]{5, 5});

        RandomVectorChooser randomVectorChooser = new RandomVectorChooser();
        LinkedList<double[]> randomPoints = randomVectorChooser.generateRandomPoints(list, 17);

        assertEquals(3, randomPoints.size());
    }
}