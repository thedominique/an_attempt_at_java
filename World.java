import javafx.scene.paint.Color;

/**
 * A representation of a world containing a set of moving shapes. NB! The worlds
 * y-axis points downward.
 *
 * @author Anders Lindström, anderslm@kth.se 2015-09-16
 */
public class World {
	private int count = 0;
    private double width, height; // this worlds width and height

    private final Shape[] shapes; // an array of references to the shapes

    /**
     * Creates a new world, containing a pad and a set of balls. NB! The worlds
     * y-axis points downward.
     *
     * @param width the width of this world
     * @param height the height of this world
     */
    public World(double width, double height) {
        this.width = width;
        this.height = height;

        shapes = new Shape[3]; // an array of references (change to non-zero size)
        Line line = new Line(100, 100, 60, 60, Color.CHOCOLATE);
        shapes[0] = line;
        Circle circle = new Circle(60, 60, 60, Color.CHARTREUSE, false);
        System.out.println(circle.toString());
        shapes[1] = circle;
        Rectangle rectangle = new Rectangle(10, 50, 50, 10, Color.AQUA, true);
        shapes[2] = rectangle;
        // Create the actual Shape objects (sub types)
        // ....
    }

    /**
     * Sets the new dimensions, in pixels, for this world. The method could be
     * used for example when the canvas is reshaped.
     *
     * @param newWidth
     * @param newHeight
     */
    public void setDimensions(double newWidth, double newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    /**
     * Move the world one step, based on the time elapsed since last move.
     *
     * @param elapsedTimeNs the elpsed time in nanoseconds
     */
    public void move(long elapsedTimeNs) {
        // alterantive loop: for(Shape s : shapes) { ...
        for (int i = 0; i < shapes.length; i++) { 
            shapes[i].move(elapsedTimeNs);
            shapes[i].constrain(0, 0, width, height);
            if(shapes[i] instanceof FillableShape) {
            	count++;
            	FillableShape fill = (FillableShape)shapes[i];
            	if(fill.isFilled() && count == 100 || count == 1) {
            		fill.setFilled(false);
            		if(count == 100) {
            		count = 0;
            		}
            	}
            	if(count == 100 || count == 43) {
            		fill.setFilled(true);
            		if(count == 100) {
                		count = 0;
                	}
            	}
            }
        }
    }

    /**
     * Returns a copy of the list of ball references.
     * Due to the implementation of clone, a shallow copy is returned.
     *
     * @return a copy of the list of balls
     */
    public Shape[] getShapes() {
        return (Shape[]) shapes.clone();
    }
}