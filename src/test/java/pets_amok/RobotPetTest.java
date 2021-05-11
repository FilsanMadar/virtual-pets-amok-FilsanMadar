package pets_amok;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RobotPetTest {

	private static final String PET_NAME = "RoboMax";
	private static final String DESCRIPTION = "description";
	private static final int OIL = 30;
	private static final int BATTERY_LEVEL = 40;
	private static final int HAPPINESS = 30;

	private VirtualPet underTest;

	@Before
	public void setup() {

		underTest = new RobotPet(PET_NAME, DESCRIPTION, OIL, BATTERY_LEVEL, HAPPINESS);
	}

	@Test
	public void shouldReturnName() {
		String check = underTest.getName();
		assertEquals(check, PET_NAME);
	}

	@Test
	public void shouldReturnDescription() {
		String check = underTest.getDescription();
		assertEquals(check, DESCRIPTION);
	}

	@Test
	public void shouldReturnNameDescriptionOilingBatteryLevelAndHappiness() {
		assertNotNull(underTest);
	}

	@Test
	public void shouldReturnOil() {
		int check = underTest.getOil();
		assertEquals(30, check);
	}

	@Test
	public void shouldReturnBatteryLevel() {
		int check = underTest.getBatteryLevel();
		assertEquals(check, 40);
	}

	@Test
	public void shouldReturnHappiness() {
		int check = underTest.getHappiness();
		assertEquals(check, 30);
	}

}
