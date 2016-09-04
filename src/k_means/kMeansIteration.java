package k_means;

import java.util.*;

/**
 * This class represents one iteration for k-mean algorithm.
 * The input is a values represent vector, and the output is a grouped sets of vectors.
 */
public class kMeansIteration
{
    private final List<double[]> vectors;
    private final GroupCenterFinder groupCenterFinder = new GroupCenterFinder();
    private final RandomVectorChooser randomVectorChooser = new RandomVectorChooser();
    private final ListComparator listComparator = new ListComparator();

    /**
     * @param vectors   A set of vectors.
     *
     * @throws EmptyCollectionException
     */
    public kMeansIteration(List<double[]> vectors) throws EmptyCollectionException
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
     * @return              Object represents grouped sets of vectors.
     *
     * @throws IllegalArgumentException
     * @throws EmptyCollectionException
     */
    public kMeansState findGroups(int groupsNumber) throws IllegalArgumentException, EmptyCollectionException
    {
        this.validateData(groupsNumber);

        LinkedList<double[]> anchors = this.randomVectorChooser.generateRandomPoints(this.vectors, groupsNumber);
        LinkedList<double[]> prevAnchors;

        do
        {
            ArrayList<List<double[]>> groupedVectors = this.getGroupedVectors(anchors);
            anchors = this.findMeansOfEachGroups(groupedVectors);

            prevAnchors = anchors;
        }
        while (!this.listComparator.isTheSameList(prevAnchors, anchors));

        return new kMeansState(this.getGroupedVectors(anchors), anchors);
    }

    /**
     * Check the value of groups number. It must be positive.
     *
     * @param groupsNumber  Define on how many groups we will split the given set of vectors.
     *
     * @return void
     *
     * @throws IllegalArgumentException When given value is zero or negative.
     */
    private void validateData(int groupsNumber) throws IllegalArgumentException
    {
        if (groupsNumber <= 0)
        {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This methods returns grouped vectors. Each vector is in a group related with the nearest anchor.
     *
     * @param anchors   A list of anchors.
     *
     * @return          Grouped sets of vectors.
     */
    private ArrayList<List<double[]>> getGroupedVectors(List<double[]> anchors) throws EmptyCollectionException
    {
        VectorsGrouper vectorsGrouper = new VectorsGrouper(this.vectors, anchors);
        return vectorsGrouper.getGroupedVectors();
    }

    /**
     * This method calculates the mean vector for each group of vectors. It returns mean vectors in the same
     * order as the given groups.
     *
     * @param groupedVectors Grouped sets of vectors.
     *
     * @return               A list of vectors represent mean points in the each group.
     */
    private LinkedList<double[]> findMeansOfEachGroups(ArrayList<List<double[]>> groupedVectors) throws EmptyCollectionException
    {
        LinkedList<double[]> anchors = new LinkedList<>();

        for (List<double[]> vectors : groupedVectors)
        {
            anchors.add(this.groupCenterFinder.generateCenterVector(vectors));
        }

        return anchors;
    }
}
