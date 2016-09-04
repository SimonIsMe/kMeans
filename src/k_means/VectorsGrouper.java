package k_means;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class is used to group vectors into groups.
 * A vector belongs to the group which has the nearest anchor.
 */
public class VectorsGrouper
{
    private final Collection<double[]> vectors;
    private final Collection<double[]> anchors;
    private final EuclideanDistance euclideanDistance = new EuclideanDistance();

    /**
     * @param vectors   A set of vectors to filter.
     * @param anchors   A set of anchors.
     *
     * @throws EmptyCollectionException
     */
    public VectorsGrouper(Collection<double[]> vectors, Collection<double[]> anchors) throws EmptyCollectionException
    {
        this.vectors = vectors;
        this.anchors = anchors;

        this.validateData();
    }

    /**
     * Validates given sets. None of them can be empty.
     *
     * @throws EmptyCollectionException
     */
    private void validateData() throws EmptyCollectionException
    {
        if (this.vectors.isEmpty())
        {
            throw new EmptyCollectionException();
        }

        if (this.anchors.isEmpty())
        {
            throw new EmptyCollectionException();
        }
    }

    /**
     * Returns grouped vectors. Each vector belongs to the group represents the nearest anchor.
     *
     * @return  List of groups of vectors.
     */
    public ArrayList<List<double[]>> getGroupedVectors()
    {
        ArrayList<List<double[]>> groupedVectors = this.getEmptyList(this.anchors.size());

        int groupIndex;
        for (double[] vector : this.vectors)
        {
            groupIndex = this.getIndexOfNearestAnchor(vector);
            groupedVectors.get(groupIndex).add(vector);
        }

        return groupedVectors;
    }

    /**
     * Makes and returns an empty list of list of vectors.
     *
     * @param size  A size of results array.
     *
     * @return      Empty list
     */
    private ArrayList<List<double[]>> getEmptyList(int size)
    {
        ArrayList<List<double[]>> groups = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            groups.add(new ArrayList<>());
        }

        return groups;
    }

    /**
     * Returns the index of the nearest anchor for a given vector.
     *
     * @param vector
     *
     * @return      An index of the nearest anchor.
     */
    private int getIndexOfNearestAnchor(double[] vector)
    {
        int indexOfNearestAnchor = 0;
        double distanceToTheNearestAnchor = 0;
        double distanceBuffer;

        int i = 0;
        for (double[] anchor : this.anchors)
        {
            if (i == 0)
            {
                distanceToTheNearestAnchor = this.euclideanDistance.calculate(vector, anchor);
                i++;
                continue;
            }

            distanceBuffer = this.euclideanDistance.calculate(vector, anchor);
            if (distanceBuffer < distanceToTheNearestAnchor)
            {
                distanceToTheNearestAnchor = distanceBuffer;
                indexOfNearestAnchor = i;
            }
            i++;
        }

        return indexOfNearestAnchor;
    }
}
