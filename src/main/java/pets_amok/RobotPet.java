package pets_amok;

public class RobotPet extends VirtualPet {
	protected int happiness;

	public RobotPet(String name, String description) {
		super(name, description);
	}

	public RobotPet(String name, String description, int oil, int batteryLevel, int happiness) {
		super(name, description);
		this.oil = oil;
		this.batteryLevel = batteryLevel;
		this.happiness = happiness;
	}
}
