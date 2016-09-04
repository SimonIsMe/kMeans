package window.group_window;

import k_means.EmptyCollectionException;
import k_means.kMeans;
import k_means.kMeansState;
import window.PointsCollection;
import window.main_window.Canvas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FindGroupsActionListener implements ActionListener
{
    private final PointsCollection pointsCollection;
    private final Canvas canvas;
    private final GroupWindow groupWindow;


    public FindGroupsActionListener(PointsCollection pointsCollection, Canvas canvas, GroupWindow groupWindow)
    {
        this.pointsCollection = pointsCollection;
        this.canvas = canvas;
        this.groupWindow = groupWindow;
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            kMeans kMeans = new kMeans(this.pointsCollection.getListOfUngroupedVectors());
            kMeansState state = kMeans.findGroups(this.groupWindow.getChosenGroups());
            ArrayList<List<double[]>> groupedPoints = state.getGroupedVectors();

            this.pointsCollection.clearAll();
            this.pointsCollection.setGroupedPoints(groupedPoints);
        }
        catch (EmptyCollectionException exception)
        {
            exception.printStackTrace();
        }

        this.canvas.repaint();
    }
}
