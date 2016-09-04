package k_means;

import java.util.List;

public class ListComparator
{
    private final ListSorter listSorter = new ListSorter();

    /**
     * Porównuje wartości w obu listach i na taj podstawie sprawdza, czy listy są identyczne.
     *
     * Porównuje wartości, a NIE wskaźniki!!!
     */
    public boolean isTheSameList(List<double[]> listA, List<double[]> listB)
    {
        double[][] sortedListA = this.getListAsArray(this.listSorter.sortList(listA));
        double[][] sortedListB = this.getListAsArray(this.listSorter.sortList(listB));

        for (int i = 0; i < sortedListA.length; i++)
        {
            for (int k = 0; k < sortedListA[i].length; k++)
            {
                if (sortedListA[i][k] != sortedListB[i][k])
                {
                    return false;
                }
            }
        }

        return true;
    }

    private double[][] getListAsArray(List<double[]> list)
    {
        if (list.isEmpty())
        {
            return new double[0][0];
        }

        double[][] array = new double[list.size()][list.get(0).length];

        int i = 0;
        for (double[] vector : list)
        {
            array[i++] = vector;
        }

        return array;
    }


}
