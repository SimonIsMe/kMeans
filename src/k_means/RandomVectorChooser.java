package k_means;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomVectorChooser
{
    private final Random random = new Random();

    /**
     * This method randoms anchors before the first iteration.
     *
     * @param numberOfGroups  Define on how many groups we will split the given set of vectors.
     *
     * @return              A list of anchors.
     *
     * @throws IllegalArgumentException
     */
    public LinkedList<double[]> generateRandomPoints(List<double[]> vectors, int numberOfGroups) throws IllegalArgumentException
    {
        if (vectors.size() < numberOfGroups)
        {
            throw new IllegalArgumentException();
        }

        LinkedList<double[]> generatedRandomPoints = new LinkedList<>();
        for (int index : this.generateArrayWithRandomValues(vectors.size(), numberOfGroups))
        {
            generatedRandomPoints.add(vectors.get(index));
        }

        return generatedRandomPoints;
    }

    /**
     * Method generate an array with random values from a given range.
     *
     * @param maxValue  Define the random range (0 - maxValue)
     * @param size      A size of output array.
     *
     * @return          Array with random values.
     */
    private int[] generateArrayWithRandomValues(int maxValue, int size)
    {
        int[] indexes = new int[size];
        Arrays.fill(indexes, -1);

        int randomIndex;
        for (int i = 0; i < size; i++)
        {
            do
            {
                randomIndex = this.random.nextInt(maxValue);
            }
            while (this.isInArray(randomIndex, indexes));

            indexes[i] = randomIndex;
        }

        return indexes;
    }

    /**
     * Method checks if there is a given value in the given array.
     *
     * @param value     Searched value
     * @param array     Array in which algorithm will look into.
     *
     * @return boolean
     */
    private boolean isInArray(int value, int[] array)
    {
        for (int item : array)
        {
            if (item == value)
            {
                return true;
            }
        }
        return false;
    }
}
