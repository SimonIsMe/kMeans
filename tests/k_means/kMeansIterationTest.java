package k_means;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class kMeansIterationTest
{
    @Test(expected = IllegalArgumentException.class)
    public void testFindGroupsWithZeroGroups() throws EmptyCollectionException, IllegalArgumentException
    {
        LinkedList<double[]> vectors = new LinkedList<>();
        vectors.add(new double[]{1,2,3});

        kMeansIteration kMeansIteration = new kMeansIteration(vectors);
        kMeansIteration.findGroups(0);
    }

    @Test(expected = EmptyCollectionException.class)
    public void testFindGroupsWithEmptyVectorCollection() throws EmptyCollectionException
    {
        new kMeansIteration(new LinkedList<>());
    }

    @Test
    public void testCollectionWithOneVector() throws EmptyCollectionException
    {
        LinkedList<double[]> vectors = new LinkedList<>();
        vectors.add(new double[]{1,2,3});

        kMeansIteration kMeansIteration = new kMeansIteration(vectors);
        ArrayList<List<double[]>> groups = kMeansIteration.findGroups(1).getGroupedVectors();

        assertEquals(1, groups.size());
        assertEquals(1.0, groups.get(0).get(0)[0]);
        assertEquals(2.0, groups.get(0).get(0)[1]);
        assertEquals(3.0, groups.get(0).get(0)[2]);
    }

    @Test
    public void testCollectionWithTwoVectorsAndOneGroups() throws EmptyCollectionException
    {
        LinkedList<double[]> vectors = new LinkedList<>();
        vectors.add(new double[]{1,2,3});
        vectors.add(new double[]{100,200,300});

        kMeansIteration kMeansIteration = new kMeansIteration(vectors);
        ArrayList<List<double[]>> groups = kMeansIteration.findGroups(1).getGroupedVectors();

        assertEquals(1, groups.size());
        assertEquals(1.0, groups.get(0).get(0)[0]);
        assertEquals(2.0, groups.get(0).get(0)[1]);
        assertEquals(3.0, groups.get(0).get(0)[2]);
        assertEquals(100.0, groups.get(0).get(1)[0]);
        assertEquals(200.0, groups.get(0).get(1)[1]);
        assertEquals(300.0, groups.get(0).get(1)[2]);
    }

    @Test
    public void testCollectionWithTwoVectorsAndTwoGroups() throws EmptyCollectionException
    {
        LinkedList<double[]> vectors = new LinkedList<>();
        vectors.add(new double[]{1,2,3});
        vectors.add(new double[]{100,200,300});

        kMeansIteration kMeansIteration = new kMeansIteration(vectors);
        ArrayList<List<double[]>> groups = kMeansIteration.findGroups(2).getGroupedVectors();

        assertEquals(2, groups.size());

        if (groups.get(0).get(0)[0] == 100)
        {
            assertEquals(1.0, Math.min(groups.get(0).get(0)[0], groups.get(1).get(0)[0]));
            assertEquals(2.0, Math.min(groups.get(0).get(0)[1], groups.get(1).get(0)[1]));
            assertEquals(3.0, Math.min(groups.get(0).get(0)[2], groups.get(1).get(0)[2]));
            assertEquals(100.0, Math.max(groups.get(0).get(0)[0], groups.get(1).get(0)[0]));
            assertEquals(200.0, Math.max(groups.get(0).get(0)[1], groups.get(1).get(0)[1]));
            assertEquals(300.0, Math.max(groups.get(0).get(0)[2], groups.get(1).get(0)[2]));
        }
    }

    @Test
    public void testCollectionWithFiveVectorsAndTwoGroups() throws EmptyCollectionException
    {
        LinkedList<double[]> vectors = new LinkedList<>();
        vectors.add(new double[]{1,2,3});
        vectors.add(new double[]{2,3,4});
        vectors.add(new double[]{5,6,7});
        vectors.add(new double[]{100,200,300});
        vectors.add(new double[]{101,201,301});

        kMeansIteration kMeansIteration = new kMeansIteration(vectors);
        ArrayList<List<double[]>> groups = kMeansIteration.findGroups(2).getGroupedVectors();

        assertEquals(2, groups.size());

        assertEquals(3, Math.max(groups.get(0).size(), groups.get(1).size()));
        assertEquals(2, Math.min(groups.get(0).size(), groups.get(1).size()));
    }

}