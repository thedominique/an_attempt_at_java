import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends FillableShape{
	private double width, height;
	public Rectangle(double x, double y, double width, double height, Color color, boolean fill) {
		super(x, y, color, fill);
		this.width = width;
		this.height = height;
		super.setVelocity(2, 1);
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	@Override
	public void paint(GraphicsContext gc) {
		gc.setFill(Color.TRANSPARENT);
		if(super.filled == true) {
			gc.setFill(this.getColor());
		}
		gc.setStroke(getColor());
		gc.fillRect(super.getX(), super.getY(), this.height, this.width);        
		gc.strokeRect(super.getX(), super.getY(), this.height, this.width);
		System.nanoTime();
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
		if (super.getX() + this.getHeight() > boxWidth) {
			super.setVelocity(-super.getDx(), super.getDy());	
        }
        if (super.getY() + this.getWidth() > boxHeight) {
            super.setVelocity(super.getDx(), -super.getDy());
        }
    }
	
}
