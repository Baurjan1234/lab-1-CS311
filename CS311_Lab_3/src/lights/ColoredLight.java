package lights;

import java.awt.Color;

public class ColoredLight extends Light {

	public Color color;

	public ColoredLight(Color colors) {
		super();
		this.color = colors;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color c) {
		this.color = c;
	}

	@Override
	public void randomChange() {
		super.randomChange();
	}

}