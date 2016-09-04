package window.main_window;

import window.PointsCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Canvas extends JPanel
{
    private final PointsCollection pointsCollection;

    public Canvas(PointsCollection pointsCollection)
    {
        this.pointsCollection = pointsCollection;
        this.addMouseListener(new CanvasActionlistener(this, this.pointsCollection));
    }

    public Dimension getDimension()
    {
        return new Dimension(480, 430);
    }

    public int getWidth()
    {
        return (int) this.getDimension().getWidth();
    }

    public int getHeight()
    {
        return (int) this.getDimension().getHeight();
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);

        g2.setColor(Color.gray);
        g2.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);

        this.drawPoints(g2, pointsCollection.getListOfUngroupedVectors(), Color.black);

        Color[] colors = this.getColors(this.pointsCollection.getGrouppedVectors().size());
        int colorI = 0;
        for (List<double[]> groupOfVector : this.pointsCollection.getGrouppedVectors())
        {
            this.drawPoints(g2, groupOfVector, colors[colorI++]);
            if (colorI == colors.length)
            {
                colorI = 0;
            }
        }
    }

    private void drawPoints(Graphics2D g2, List<double[]> points, Color color)
    {
        g2.setColor(color);
        g2.setStroke(new BasicStroke(2));

        for (double[] point : points)
        {
            g2.drawLine(
                    (int) point[0] - 5,
                    (int) point[1] - 5,
                    (int) point[0] + 5,
                    (int) point[1] + 5
            );
            g2.drawLine(
                    (int) point[0] - 5,
                    (int) point[1] + 5,
                    (int) point[0] + 5,
                    (int) point[1] - 5
            );
        }
    }

    private Color[] getColors(int limit)
    {
        Color[] colors = new Color[5];

        colors[0] = Color.red;
        colors[1] = Color.green;
        colors[2] = Color.blue;
        colors[3] = Color.pink;
        colors[4] = Color.gray;

        return colors;
    }
}
