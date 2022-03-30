package lights;

import java.util.ArrayList;
import java.util.List;

public class RunningHolidayLights implements HolidayLights {

	public int length;
	public int k = 0;
	public int count = 0;
	public int be = 4;

	public ArrayList<Light> lights;

	public RunningHolidayLights(int length) {
		this.length = length;
	}

	public List<Light> next() {
		lights = new ArrayList<Light>();
		for (int i = 0; i < this.length; i++) {
			Light light = new Light();

			light.randomChange();
			lights.add(light);
		}
		lights.get(k++).setOn(true);

		if (k >= this.length)
			k = 0;

		return lights;
	}

	public List<Light> nextCount() {
		lights = new ArrayList<Light>();
		// ColoredLight lightColor = new ColoredLight(Color.GREEN);
		for (int i = 0; i < this.length; i++) {
			Light light = new Light();
			lights.add(light);
		}
		lights.get(count++).setOn(true);
		if (count >= this.length)
			count = 0;

		return lights;
	}

	public List<Light> before() {
		lights = new ArrayList<Light>();
		for (int i = 0; i < this.length; i++) {
			Light light = new Light();
			lights.add(light);
		}
		lights.get(be--).setOn(true);
		if (be == -1)
			be = 4;

		return lights;
	}

	public int getLength() {
		return this.length;
	}
}