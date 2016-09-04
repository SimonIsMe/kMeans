package window.main_window;


import window.group_window.GroupWindow;
import window.PointsCollection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PopupGroupWindowActionListener implements ActionListener
{
    private final Window window;
    private final PointsCollection pointsCollection;

    public PopupGroupWindowActionListener(Window window, PointsCollection pointsCollection)
    {
        this.window = window;
        this.pointsCollection = pointsCollection;
    }

    public void actionPerformed(ActionEvent e)
    {
        new GroupWindow(this.window, this.pointsCollection);
    }
}
