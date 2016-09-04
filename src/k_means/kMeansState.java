package k_means;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class kMeansState
{
    private final ArrayList<List<double[]>> groupedVectors;
    private final LinkedList<double[]> anchors;
    private final EuclideanDistance euclideanDistance = new EuclideanDistance();
    private double meanSquareError = -1;

    /**
     * @param groupedVectors    A list of grouped vectors.
     * @param anchors           List of anchors for each group of vectors.
     */
    public kMeansState(ArrayList<List<double[]>> groupedVectors, LinkedList<double[]> anchors)
    {
        this.groupedVectors = groupedVectors;
        this.anchors = anchors;
    }

    /**
     * @return List of grouped vectors.
     */
    public ArrayList<List<double[]>> getGroupedVectors()
    {
        return this.groupedVectors;
    }

    /**
     * Returns the mean square error. If it doesn't calculated, it will be calculated.
     *
     * @return Mean square error.
     */
    public double getMeanSquareError()
    {
        if (this.meanSquareError == -1)
        {
            this.meanSquareError = this.calculateMeanSquareError();
        }

        return this.meanSquareError;
    }

    /**
     * Calculate the mean square error for all groups of vectors.
     *
     * @return          Mean square error.
     */
    private double calculateMeanSquareError()
    {
        double meanSquareError = 0;

        int i = 0;
        for (List<double[]> vectors : this.groupedVectors)
        {
            meanSquareError += this.calculateMeanSquareErrorForGroupOfVectors(vectors, this.anchors.get(i++));
        }

        return meanSquareError;
    }

    /**
     * Calculate the mean square error for a given vectors.
     *
     * @param vectors   Group of vectors.
     * @param anchor    The anchor for this group of vectors.
     *
     * @return          Mean square error.
     */
    private double calculateMeanSquareErrorForGroupOfVectors(List<double[]> vectors, double[] anchor)
    {
        double meanSquareError = 0;

        for (double[] vector : vectors)
        {
            meanSquareError += Math.pow(this.euclideanDistance.calculate(vector, anchor), 2);
        }

        return meanSquareError / vectors.size();
    }
}
