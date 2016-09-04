package window.main_window;

import window.PointsCollection;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class CanvasActionlistener implements MouseListener
{
    private final Canvas canvas;
    private final PointsCollection pointsCollection;

    public CanvasActionlistener(Canvas canvas, PointsCollection pointsCollection)
    {
        this.canvas = canvas;
        this.pointsCollection = pointsCollection;
    }

    public void mouseClicked(MouseEvent e)
    {
        this.pointsCollection.addUngrouppedVector(e.getX(), e.getY());
        this.canvas.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
