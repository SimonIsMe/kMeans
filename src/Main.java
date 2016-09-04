import window.PointsCollection;
import window.main_window.Window;

public class Main
{
    public static void main(String[] args)
    {
        PointsCollection pointsCollection = new PointsCollection();
        new Window(pointsCollection);
    }
}
