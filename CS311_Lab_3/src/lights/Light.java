package lights;

public class Light {

	public boolean isOn;

	public Light() {
		this(false);
		// this(true);
	}

	public Light(boolean isOn) {
		this.isOn = isOn;
	}

	public boolean isOn() {
		return this.isOn;
		// return true;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	/**
	 * Randomly changes this light to be on or off.
	 */
	public void randomChange() {
		if (Math.random() < .5) {
			this.setOn(true);
		} else {
			this.setOn(false);
		}
	}

}