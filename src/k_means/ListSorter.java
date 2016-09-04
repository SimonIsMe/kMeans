package k_means;

import java.util.LinkedList;
import java.util.List;

public class ListSorter
{
    /**
     * This method sorts list of vectors by their first values in ascending order.
     *
     * @param list  A list of vectors to sort.
     *
     * @return      Sorted list of vectors.
     */
    public List<double[]> sortList(List<double[]> list)
    {
        List<double[]> sortedList = new LinkedList<>();

        boolean isInserted;
        for (double[] vector : list)
        {
            isInserted = false;

            for (int i = 0; i < sortedList.size(); i++)
            {
                if (sortedList.get(i)[0] > vector[0])
                {
                    sortedList.add(i, vector);
                    isInserted = true;
                    break;
                }
            }

            if (!isInserted)
            {
                sortedList.add(vector);
            }
        }

        return sortedList;
    }
}
