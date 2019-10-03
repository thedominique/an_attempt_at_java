import javafx.scene.paint.Color;

abstract public class FillableShape extends Shape {
	boolean filled;
	
	protected FillableShape(double x, double y, Color color, boolean filled) {
		super(x, y, color);
		this.filled = filled;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	@Override
	public String toString() {
		return "FillableShape [filled=" + filled + ", toString()=" + super.toString() + "]";
	}
	
}
