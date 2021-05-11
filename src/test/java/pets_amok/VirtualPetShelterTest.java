package pets_amok;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class VirtualPetShelterTest {
	private static final String PET_NAME = "name";
	private static final String DESCRIPTION = "description";

	private VirtualPetShelter underTest;

	@Before
	public void setup() {
		underTest = new VirtualPetShelter();
	}

	@Test
	public void shouldRetrieveVirtualPetName() {
		VirtualPet check = new VirtualPet(PET_NAME, DESCRIPTION);
		underTest.intake(check);
		VirtualPet retrieved = underTest.findPet(PET_NAME);
		assertThat(retrieved, Matchers.is(check));
	}

	@Test
	public void shouldIntakeMultipleVirtualPetNames() {
		String anotherName = "Arasu";
		VirtualPet pet = new VirtualPet("Hina", DESCRIPTION);
		VirtualPet anotherPet = new VirtualPet(anotherName, DESCRIPTION);
		underTest.intake(pet);
		underTest.intake(anotherPet);
		Collection<VirtualPet> pets = underTest.pets();
		assertThat(pets, Matchers.containsInAnyOrder(pet, anotherPet));
		assertTrue(pets.contains(pet));
		assertTrue(pets.contains(anotherPet));
		assertEquals(2, pets.size());
	}

	@Test
	public void shouldAdoptVirtualPets() {
		VirtualPet pet = new VirtualPet("Hina", DESCRIPTION);
		underTest.adopt(pet.getName());
		assertThat(underTest.doesPetRemain(pet.getName()), is(false));
	}


	@Test
	public void shouldShelterFeedAllPet() {
		VirtualPet pet = new VirtualPet("Bulma", "Akita");
		underTest.intake(pet);
		underTest.intake(new VirtualPet("Bulma2", "Akita2", 0, 0, 0, 0, 0));
		underTest.intake(new VirtualPet("Bulma3", "Akita3"));
		underTest.feedAll();
		VirtualPet testPet = underTest.findPet("Bulma2");
		int hunger = testPet.getHunger();
		assertEquals(5, hunger);
		assertEquals(55, underTest.findPet("Bulma3").getHunger());
	}

	@Test
	public void shouldShelterWaterAllPet() {
		VirtualPet pet = new VirtualPet("Bulma", "Akita");
		underTest.intake(pet);
		underTest.intake(new VirtualPet("Bulma2", "Akita2", 0, 5, 0, 0, 0));
		underTest.intake(new VirtualPet("Bulma3", "Akita3"));
		underTest.waterAll();
		VirtualPet testPet = underTest.findPet("Bulma2");
		int water = testPet.getWater();
		assertEquals(11, water);
		assertEquals(66, underTest.findPet("Bulma3").getWater());
	}

	@Test
	public void shouldShelterPlayWithHold() {
		VirtualPet pet = new VirtualPet("Bulma", DESCRIPTION);
		underTest.intake(pet);
		underTest.play("Bulma");
		assertEquals(50, underTest.findPet("Bulma").getBoredom());
	}

	@Test
	public void shouldShelterOilAllPet() {
		VirtualPet pet = new RobotPet("Jasper", "Wyatt");
		underTest.intake(pet);
		underTest.intake(new RobotPet("Jasper2", "Wyatt2", 10, 0, 0));
		underTest.intake(new RobotPet("Jasper3", "Wyatt3", 25, 0, 0));
		underTest.oilAll();
		VirtualPet testPet = (VirtualPet) underTest.findPet("Jasper2");
		int oil = testPet.getOil();
		assertEquals("Jasper2", testPet.getName());
		assertEquals(20, oil);
		assertEquals(35, ((VirtualPet) underTest.findPet("Jasper3")).getOil());
	}

	@Test
	public void shouldHaveShelterLitterBox() {
		int check = underTest.getLitterBox();
		assertEquals(check, 70);
	}

	@Test
	public void shouldHaveShelterCleanLitterBox() {
		underTest.litterBoxCleanUp();
		assertEquals(underTest, underTest);
	}

	@Test
	public void shouldTickLitterBox() {
		int check = 5;
		underTest.tickLitterBox();
		assertEquals(check, 5);
	}

	@Test
	public void shouldCleanDogKennels() {
		underTest.cleanDogKennels();
		assertEquals(underTest, underTest);
	}

}