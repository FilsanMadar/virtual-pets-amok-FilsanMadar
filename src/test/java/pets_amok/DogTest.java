package pets_amok;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DogTest {
	VirtualPet underTest = new Dog("Bulma", "Is a dog", 20, 30, 40, 50, 40);

	@Test
	public void shouldReturnDogName() {
		String check = underTest.getName();
		assertEquals(check, "Bulma");
	}

	@Test
	public void shouldReturnDogDescription() {
		String check = underTest.getDescription();
		assertEquals(check, "Is a dog");
	}

	@Test
	public void shouldReturnDogHunger() {
		int check = underTest.getHunger();
		assertEquals(check, 20);
	}

	@Test
	public void shouldReturnDogWater() {
		int check = underTest.getWater();
		assertEquals(check, 30);
	}

	@Test
	public void shouldReturnDogBoredom() {
		int check = underTest.getBoredom();
		assertEquals(check, 40);
	}

	@Test
	public void shouldReturnDogWaste() {
		int check = underTest.getWaste();
		assertEquals(check, 50);
	}

	@Test
	public void shouldReturnDogHappiness() {
		int check = underTest.getHappiness();
		assertEquals(check, 40);
	}

	@Test
	public void shouldReturnAFiltyDogKennel() {
		int check = underTest.getFilthyDogKennel();
		assertEquals(check, 50);
	}

	@Test
	public void shouldCleanUpDogKennel() {
		underTest.cleanKennel();

	}
}
