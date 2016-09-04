package k_means;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EuclideanDistanceTest
{
    @Test
    public void testForTwoDimensionalPoints()
    {
        double[] vectorA = new double[]{5, 1};
        double[] vectorB = new double[]{8, 5};

        EuclideanDistance euclideanDistance = new EuclideanDistance();
        double distance = euclideanDistance.calculate(vectorA, vectorB);

        assertEquals(5.0, distance);
    }

    @Test
    public void testForTwoDimensionalPointsWithNegativeValues()
    {
        double[] vectorA = new double[]{2, 3};
        double[] vectorB = new double[]{-1, -1};

        EuclideanDistance euclideanDistance = new EuclideanDistance();
        double distance = euclideanDistance.calculate(vectorA, vectorB);

        assertEquals(5.0, distance);
    }

    @Test
    public void testForFourDimensionalPointsWithNegativeValues()
    {
        double[] vectorA = new double[]{1, 2, 3, 4};
        double[] vectorB = new double[]{5, 6, 7, 8};

        EuclideanDistance euclideanDistance = new EuclideanDistance();
        double distance = euclideanDistance.calculate(vectorA, vectorB);

        assertEquals(8.0, distance);
    }

    @Test
    public void testForTenDimensionalPointsWithNegativeValues()
    {
        double[] vectorA = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        double[] vectorB = new double[]{0, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        EuclideanDistance euclideanDistance = new EuclideanDistance();
        double distance = euclideanDistance.calculate(vectorA, vectorB);

        assertEquals(13.038404810405298, distance);
    }
}