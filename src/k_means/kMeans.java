package k_means;

import java.util.List;

/**
 * This class is the main class. The input is a values represent vector (points), and the output is a grouped
 * sets of vectors (points)
 */
public class kMeans
{
    private final List<double[]> vectors;

    /**
     * @param vectors   A set of vectors.
     *
     * @throws EmptyCollectionException
     */
    public kMeans(List<double[]> vectors) throws EmptyCollectionException
    {
        this.vectors = vectors;
        if (this.vectors.isEmpty())
        {
            throw new EmptyCollectionException();
        }
    }

    /**
     * This method splits given set of vectors into ArrayList of list of grouped vectors.
     *
     * @param groupsNumber  Define on how many groups we will split the given set of vectors.
     *
     * @return              Object represents the best grouped sets of vectors.
     *
     * @throws IllegalArgumentException
     * @throws EmptyCollectionException
     */
    public kMeansState findGroups(int groupsNumber) throws IllegalArgumentException, EmptyCollectionException
    {
        kMeansState minState = null;

        for (int i = 0; i < this.getNumberOfIterations(); i++)
        {
            kMeansIteration iteration = new kMeansIteration(this.vectors);
            kMeansState state = iteration.findGroups(groupsNumber);

            if (i == 0)
            {
                minState = state;
                continue;
            }

            if (state.getMeanSquareError() < minState.getMeanSquareError())
            {
                minState = state;
            }
        }

        return minState;
    }

    /**
     * @return Return the number of required iterations.
     */
    private int getNumberOfIterations()
    {
        return this.vectors.size() * 2;
    }
}
