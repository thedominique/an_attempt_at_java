import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Circle extends FillableShape {
	double diameter;
	
	public Circle(double x, double y, double diameter, Color color, boolean filled) {
		super(x, y, color, filled);
		this.diameter = diameter;
		super.setVelocity(1, 2);
	}
	
	public double getDiameter() {
		return diameter;
	}
	
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	@Override
	public void paint(GraphicsContext gc) {   
		gc.setFill(Color.TRANSPARENT);
		if(super.filled == true) {
			gc.setFill(this.getColor());
		}
		gc.setStroke(this.getColor());
		gc.strokeOval(super.getX(), super.getY(), this.diameter, this.diameter);
		gc.fillOval(super.getX(), super.getY(), this.diameter, this.diameter);
	}
	@Override
	public void move(long elapsedTimeNs) {
		super.setX(super.getX() + super.getDx());
		super.setY(super.getY() + super.getDy());
    }
	@Override
	public void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        // If outside the box - calculate new dx and dy
		if (super.getX() < boxX || super.getX() > boxWidth) {
			super.setVelocity(-super.getDx(), super.getDy());
		}
		if (super.getY() < boxY || super.getY() > boxHeight) {
            super.setVelocity(super.getDx(), -super.getDy());
        }
		if (super.getX() + diameter > boxWidth) {
			super.setVelocity(-super.getDx(), super.getDy());	
        }
        if (super.getY() + diameter > boxHeight) {
            super.setVelocity(super.getDx(), -super.getDy());
        }
    }

	@Override
	public String toString() {
		return "Circle [diameter=" + diameter + ", filled=" + filled + ", toString()=" + super.toString() + "]";
	}
	
}
