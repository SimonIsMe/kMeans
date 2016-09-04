package k_means;

import java.util.Collection;
import java.util.List;

public class GroupCenterFinder
{
    /**
     * This method returns a mean vector for given set of vectors.
     *
     * @param vectors   A set of vectors.
     *
     * @return          A mean vector.
     *
     * @throws EmptyCollectionException
     */
    public double[] generateCenterVector(List<double[]> vectors) throws EmptyCollectionException
    {
        this.validateData(vectors);

        double[] center = new double[vectors.get(0).length];
        for (double[] vector : vectors)
        {
            for (int i = 0; i < center.length; i++)
            {
                center[i] += vector[i];
            }
        }

        for (int i = 0; i < center.length; i++)
        {
            center[i] = center[i] / vectors.size();
        }

        return center;
    }

    /**
     * This method validate correctness of given set of vectors.
     * The given set should not be empty.
     *
     * @param vectors   A set of vectors.
     *
     * @return void
     *
     * @throws EmptyCollectionException
     */
    private void validateData(Collection<double[]> vectors) throws EmptyCollectionException
    {
        if (vectors.isEmpty())
        {
            throw new EmptyCollectionException();
        }
    }
}
