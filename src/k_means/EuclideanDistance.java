package k_means;

/**
 * This class is helpful, when we want to calculate the Euclidean distance.
 */
public class EuclideanDistance
{

    /**
     * Calculates a distance between two vectors.
     *
     * @param vectorA
     * @param vectorB
     *
     * @return      A distance between given vectors.
     */
    public double calculate(double vectorA[], double vectorB[])
    {
        double distance = 0;

        for (int i = 0; i < vectorA.length; i++)
        {
            distance += Math.pow(vectorA[i] - vectorB[i] , 2);
        }

        return Math.sqrt(distance);
    }
}
