package window.group_window;

import window.PointsCollection;
import window.main_window.Window;

import javax.swing.*;

public class GroupWindow extends JFrame
{
    private final Window window;
    private final PointsCollection pointsCollection;
    private final FindGroupsActionListener findGroupsActionListener;
    private final JLabel label = new JLabel("Choose number of groups:");
    private final JSpinner spinner = new JSpinner();
    private final JButton button = new JButton("Find groups!");

    public GroupWindow(Window window, PointsCollection pointsCollection)
    {
        this.window = window;
        this.pointsCollection = pointsCollection;
        this.findGroupsActionListener = new FindGroupsActionListener(pointsCollection, window.getCanvas(), this);

        this.setTitle("Split points for groups");
        this.setSize(300, 100);
        this.setLayout(null);

        this.drawLabel();
        this.drawInput();
        this.drawButton();

        this.setVisible(true);
    }

    public int getChosenGroups()
    {
        return (int) this.spinner.getValue();
    }

    private void drawLabel()
    {
        this.label.setBounds(20, 20, 200, 30);
        this.add(this.label);
    }

    private void drawInput()
    {
        this.pointsCollection.countAll();
        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, this.pointsCollection.countAll(), 1);

        this.spinner.setModel(spinnerModel);
        this.spinner.setBounds(220, 20, 50, 30);
        this.add(this.spinner);
    }

    private void drawButton()
    {
        this.button.setBounds(50, 60, 200, 30);
        this.button.addActionListener(this.findGroupsActionListener);
        this.add(this.button);
    }
}
