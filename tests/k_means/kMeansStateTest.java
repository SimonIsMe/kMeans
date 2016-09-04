package k_means;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class kMeansStateTest
{
    @Test
    public void testForEmptyListOfVectors()
    {
        kMeansState kMeansState = new kMeansState(new ArrayList<>(), new LinkedList<>());
        assertEquals(0, kMeansState.getGroupedVectors().size());
        assertEquals(0.0, kMeansState.getMeanSquareError());
    }

    @Test
    public void testForListOfVectorsWithOneVector()
    {
        double[] vector = new double[]{1, 2, 3};
        ArrayList<List<double[]>> groupedVectors = new ArrayList<>();
        groupedVectors.add(new LinkedList<>());
        groupedVectors.get(0).add(vector);

        LinkedList<double[]> anchors = new LinkedList<>();
        anchors.add(vector);

        kMeansState kMeansState = new kMeansState(groupedVectors, anchors);
        assertEquals(1, kMeansState.getGroupedVectors().size());
        assertEquals(0.0, kMeansState.getMeanSquareError());
    }

    @Test
    public void testForListOfVectorsWithThreeVectorsSplittedIntoTwoGroups()
    {
        double[] vectorA = new double[]{1, 2, 3};
        double[] vectorB = new double[]{2, 3, 4};
        double[] vectorC = new double[]{100, 200, 300};

        ArrayList<List<double[]>> groupedVectors = new ArrayList<>();
        groupedVectors.add(new LinkedList<>());
        groupedVectors.add(new LinkedList<>());
        groupedVectors.get(0).add(vectorA);
        groupedVectors.get(0).add(vectorB);
        groupedVectors.get(1).add(vectorC);

        LinkedList<double[]> anchors = new LinkedList<>();
        anchors.add(vectorA);
        anchors.add(vectorC);

        kMeansState kMeansState = new kMeansState(groupedVectors, anchors);
        assertEquals(2, kMeansState.getGroupedVectors().size());
        assertEquals(1.4999999999999998, kMeansState.getMeanSquareError());
    }
}