package pets_amok;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotDogTest {
	VirtualPet underTest = new RobotDog("Jasper", "Is a Robot Dog", 40, 50, 30);

	@Test
	public void shouldReturnRobotDogName() {
		String check = underTest.getName();
		assertEquals(check, "Jasper");
	}

	@Test
	public void shouldReturnRobotDogDescription() {
		String check = underTest.getDescription();
		assertEquals(check, "Is a Robot Dog");
	}

	@Test
	public void shouldReturnRobotDogOil() {
		int check = underTest.getOil();
		assertEquals(check, 40);
	}

	@Test
	public void shouldReturnRobotDogBatteryLevel() {
		int check = underTest.getBatteryLevel();
		assertEquals(check, 50);
	}

	@Test
	public void shouldReturnRobotDogHappiness() {
		int check = underTest.getHappiness();
		assertEquals(check, 30);
	}

}
