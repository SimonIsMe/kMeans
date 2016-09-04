package window;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PointsCollection
{
    private ArrayList<List<double[]>> groupsOfVectors = new ArrayList<>();
    private final List<double[]> ungroupedVectors = new LinkedList<>();

    public void addUngrouppedVector(int x, int y)
    {
        this.ungroupedVectors.add(new double[]{x, y});
    }

    public List<double[]> getListOfUngroupedVectors()
    {
        return this.ungroupedVectors;
    }

    public ArrayList<List<double[]>> getGrouppedVectors()
    {
        return this.groupsOfVectors;
    }

    public int countAll()
    {
        int count = ungroupedVectors.size();

        for (List<double[]> vectorGroup : this.groupsOfVectors)
        {
            count += vectorGroup.size();
        }

        return count;
    }

    public void clearAll()
    {
        this.groupsOfVectors.clear();
    }

    public void setGroupedPoints(ArrayList<List<double[]>> groupedPoints)
    {
        this.groupsOfVectors = groupedPoints;
    }
}
