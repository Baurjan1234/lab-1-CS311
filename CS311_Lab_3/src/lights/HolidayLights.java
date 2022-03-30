package lights;

import java.util.List;

public interface HolidayLights {

	public List<Light> next();

	public List<Light> nextCount();

	public List<Light> before();
	// public int getLength();

}