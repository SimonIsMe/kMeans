package k_means;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class VectorsGrouperTest
{
    @Test(expected = EmptyCollectionException.class)
    public void testEmptyVectorsListException() throws EmptyCollectionException
    {
        LinkedList<double[]> vectors = new LinkedList<>();
        vectors.add(new double[]{1, 2, 3});

        new VectorsGrouper(new LinkedList<>(), vectors);
    }

    @Test(expected = EmptyCollectionException.class)
    public void testEmptyAnchorListException() throws EmptyCollectionException
    {
        LinkedList<double[]> vectors = new LinkedList<>();
        vectors.add(new double[]{1, 2, 3});

        new VectorsGrouper(vectors, new LinkedList<>());
    }

    @Test(expected = EmptyCollectionException.class)
    public void testEmptyVectorAndAnchorListsException() throws EmptyCollectionException
    {
        new VectorsGrouper(new LinkedList<>(), new LinkedList<>());
    }

    @Test
    public void testGroupSetWithOneVector() throws EmptyCollectionException
    {
        LinkedList<double[]> vectors = new LinkedList<>();
        vectors.add(new double[]{1, 2, 3});

        LinkedList<double[]> anchors = new LinkedList<>();
        anchors.add(new double[]{30, 5, 123});

        VectorsGrouper vectorsGrouper = new VectorsGrouper(vectors, anchors);
        List<List<double[]>> groupedVectors = vectorsGrouper.getGroupedVectors();

        assertEquals(1, groupedVectors.size());
        assertEquals(1, groupedVectors.get(0).size());
    }

    @Test
    public void testGroupSetWithTwoVectorAndTwoAnchors() throws EmptyCollectionException
    {
        LinkedList<double[]> vectors = new LinkedList<>();
        vectors.add(new double[]{1, 2, 3});
        vectors.add(new double[]{100, 200, 300});

        LinkedList<double[]> anchors = new LinkedList<>();
        anchors.add(new double[]{2, 3, 4});
        anchors.add(new double[]{101, 201, 301});

        VectorsGrouper vectorsGrouper = new VectorsGrouper(vectors, anchors);
        List<List<double[]>> groupedVectors = vectorsGrouper.getGroupedVectors();

        assertEquals(2, groupedVectors.size());
        assertEquals(1, groupedVectors.get(0).size());
        assertEquals(1, groupedVectors.get(1).size());
    }

    @Test
    public void testGroupSetWithFourVectorAndTwoAnchors() throws EmptyCollectionException
    {
        LinkedList<double[]> vectors = new LinkedList<>();
        vectors.add(new double[]{1, 2, 3});
        vectors.add(new double[]{2, 3, 4});
        vectors.add(new double[]{5, 6, 7});
        vectors.add(new double[]{100, 200, 300});

        LinkedList<double[]> anchors = new LinkedList<>();
        anchors.add(new double[]{2, 3, 4});
        anchors.add(new double[]{101, 201, 301});

        VectorsGrouper vectorsGrouper = new VectorsGrouper(vectors, anchors);
        List<List<double[]>> groupedVectors = vectorsGrouper.getGroupedVectors();

        assertEquals(2, groupedVectors.size());
        assertEquals(3, groupedVectors.get(0).size());
        assertEquals(1, groupedVectors.get(1).size());
    }
}