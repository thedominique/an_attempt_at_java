import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape{
	private double x2, y2;
	
	public Line() {
		super();
		this.x2 = 0;
		this.y2 = 0;
	}
	
	public Line(double x, double y, double x2, double y2, Color c) {
		super(x, y, c);
		this.x2 = x2;
		this.y2 = y2;
		super.setVelocity(-x / x2, y / y2);
	}
	
	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	@Override
	public void paint(GraphicsContext gc) {
		gc.setStroke(super.getColor());
	    gc.setLineWidth(5);
	    gc.strokeLine(this.getX2(), this.getY2(), this.getX(), this.getY());
	}
	
	@Override
	public void move(long elapsedTimeNs) {
		this.x2 += super.getDx();
		super.setX(super.getX() + super.getDx());
        this.y2 += super.getDy();
        super.setY(super.getY() + super.getDy());
    }
	
	@Override
	public void constrain(double x2, double y2, double worldwidth, double worldheight ) {
		// If outside the box - calculate new dx and dy
			if (this.getX2() < x2 || this.getX2() > worldwidth) {
				super.setVelocity(-super.getDx(), super.getDy());
			}
			if (this.getY2() < y2 || this.getY2() > worldheight) {
	            super.setVelocity(super.getDx(), -super.getDy());
	        }
	        if (this.getX() < x2 || this.getX() > worldwidth) {
				super.setVelocity(-super.getDx(), super.getDy());	
	        }
	        if (this.getY() < y2 || this.getY() > worldheight) {
	            super.setVelocity(super.getDx(), -super.getDy());
	        }
	  }

	@Override
	public String toString() {
		return "Line [x2=" + x2 + ", y2=" + y2 + ", toString()=" + super.toString() + "]";
	}
	
	

}