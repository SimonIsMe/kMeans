package window.main_window;

import window.PointsCollection;

import javax.swing.*;

public class Window extends JFrame
{
    private final Canvas canvas;
    private final PopupGroupWindowActionListener popupGroupWindowActionListener;

    public Window(PointsCollection pointsCollection)
    {
        this.canvas = new Canvas(pointsCollection);
        this.popupGroupWindowActionListener = new PopupGroupWindowActionListener(this, pointsCollection);

        this.setTitle("kNN algorithm test");
        this.setSize(500, 500);
        this.setLayout(null);

        this.drawCanvas(pointsCollection);
        this.drawButton();

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void drawCanvas(PointsCollection pointsCollection)
    {
        this.canvas.setBounds(10, 10, this.canvas.getWidth(), this.canvas.getHeight());
        this.add(this.canvas);
    }

    private void drawButton()
    {
        JButton button = new JButton("Group points");
        button.setBounds(150, this.canvas.getHeight() + 20, 200, 30);
        button.addActionListener(this.popupGroupWindowActionListener);
        this.add(button);
    }

    public Canvas getCanvas()
    {
        return this.canvas;
    }
}
