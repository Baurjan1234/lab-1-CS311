package lights;

public class Main {

	public static void main(String[] args) {
		// Create HolidayLights
		HolidayLights hl = new RunningHolidayLights(5);
		System.out.println("hello");

		// Create and show HolidayLightsWindow
		HolidayLightsWindow frame = new HolidayLightsWindow(hl);
		frame.pack();
		frame.setVisible(true);
	}

}