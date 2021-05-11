package pets_amok;

import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		VirtualPetShelter pets = new VirtualPetShelter();

		Dog dog1 = new Dog("Bulma", "Black Lab", 40, 50, 60, 40, 60);
		Dog dog2 = new Dog("Arasu", "Pitbull.", 50, 40, 50, 50, 50);
		Dog dog3 = new Dog("Blue", "Rottwieler.", 60, 60, 60, 60, 80);
		Dog dog4 = new Dog("Hera", "Just an old Dog.", 70, 80, 80, 60, 50);

		Cat cat1 = new Cat("Tara", "A Maincoon.", 50, 40, 50, 70, 40);
		Cat cat2 = new Cat("Hina", "An Alley Cat.", 50, 40, 50, 70, 30);
		Cat cat3 = new Cat("Fluffy", "A Tabby Cat", 50, 40, 50, 60, 70);
		Cat cat4 = new Cat("Hegwig", "Just an old Cat.", 50, 40, 50, 80, 40);

		RobotDog robo1 = new RobotDog("Jasper", "Bee boo Beep, Robot Dog", 50, 60, 70);
		RobotDog robo2 = new RobotDog("Wyatt", "Robot Dog that needs oil.", 40, 50, 60);
		RobotDog robo3 = new RobotDog("Chuck", "Hi Tech Robot Dog.", 70, 40, 80);
		RobotDog robo4 = new RobotDog("Charlie", "Crime fighting dog", 50, 60, 40);

		pets.add(dog1);
		pets.add(dog2);
		pets.add(dog3);
		pets.add(dog4);

		pets.add(cat1);
		pets.add(cat2);
		pets.add(cat3);
		pets.add(cat4);

		pets.add(robo1);
		pets.add(robo2);
		pets.add(robo3);
		pets.add(robo4);

		String decision = "";
		while (!decision.equalsIgnoreCase("Yes")) {

			System.out.println("  ***Thank you for visiting your local shelter***\n");
			System.out.println("    That houses forsaken Dog's, Cat's & RoboPets.");
			System.out.println("       This is the status of the Shelter Pet's \n");

			System.out.println("\t\t     **DOGS**\n");
			System.out.println("Name\t|Hunger\t|Thirst\t|Boredom |Waste  |Happiness");
			System.out.println("--------|-------|-------|--------|-------|---------");
			System.out.println(pets.dogStatus());
			for (VirtualPet pet : pets.pets()) {
				if (pet instanceof Dog) {
					if (((Dog) pet).getFilthyDogKennel() >= 75) {
						System.out.println(pet.getName() + " needs his kennel cleaned out.");
						System.out.println("Need to do something about the dog kennel(s).\n");
					}
				}
			}

			System.out.println("\n\t\t    **CATS**\n");
			System.out.println("Name\t|Hunger\t|Thirst\t|Boredom |Happiness");
			System.out.println("--------|-------|-------|--------|---------");
			System.out.println(pets.catStatus());
			System.out.println("Shelter recommends not letting the Litter Box go above 100.");
			System.out.println("Nothing will happen of course. It just virtually stinks from time to time.\n");
			System.out.println("Shelter Litter Box Level: " + pets.getLitterBox() + "\n");

			System.out.println("\n\t    **ROBO DOGS**\n");
			System.out.println("Name\t|Oil\t|Battery |Happiness");
			System.out.println("--------|-------|--------|---------");
			System.out.println(pets.roboStatus());
			System.out.println("\nWhat would you like to do next?\n");

			System.out.println("1. Feed Dogs & Cats.");
			System.out.println("2. Water Dogs & Cats.");
			System.out.println("3. Oil & Charge Robot Dogs.");
			System.out.println("4. Play with a Shelter Pet.");
			System.out.println("5. Adopt a pet.");
			System.out.println("6. Admit a pet.");
			System.out.println("7. Clean all Dog cages.");
			System.out.println("8. Clean the Shelter Litter Box.");
			System.out.println("9. Quit");

			String optionEntered = input.nextLine();
			if (optionEntered.equals("1")) {
				pets.feedAll();
				System.out.println("You fed all the Dog's & Cat's in the Shelter food.\n");

			} else if (optionEntered.equals("2")) {
				pets.waterAll();
				System.out.println("You gave all the Dog's & Cat's in the Shelter water.\n");

			} else if (optionEntered.equals("3")) {
				pets.oilAll();
				System.out.println("The Robo Pets looked a bit sluggish.");
				System.out.println("Thanks for the assist on helping them stay well lubricated.\n");

			} else if (optionEntered.equals("4")) {
				System.out.println("\nWhich Shelter Pet would you like to take on a walk today? \n");
				System.out.println("Just a reminder: ");
				System.out.println("Taking Robot Dogs on a walk will decrease their Oil and Battery Levels. \n");
				System.out.println(pets.option5Display());
				String petName = input.nextLine();
				petName = petName.substring(0, 1).toUpperCase() + petName.substring(1).toLowerCase();
				pets.play(petName);
				System.out.println("You took " + petName + " for a walk to the field to play.\n");

			} else if (optionEntered.equals("5")) {
				System.out.println("You've chosen to adopt a pet.");
				System.out.println("Which pet would you like to adopt?\n");
				System.out.println(pets.option5Display());
				String petName = input.nextLine();

				if (!pets.doesPetRemain(petName)) {
					System.out.println("This Dog does not exist.");
				} else {
					pets.adopt(petName);
					System.out.println("Congrats on adopting your new Shelter baby: \n" + petName + "!");
				}

			} else if (optionEntered.equals("6")) {
				System.out.println("What type of pet are your surrendering?\n");
				System.out.println("Dog? Cat? Robot Dog?");
				String petDecision = input.nextLine();

				if (petDecision.equalsIgnoreCase("Dog")) {
					System.out.println("Enter the name of the Dog being surrendered: ");
					String newPetName = input.nextLine();

					System.out.println("Enter a description for the Dog being surrendered: ");
					String newPetDescription = input.nextLine();

					pets.add(new Dog(newPetName, newPetDescription, 50, 50, 50, 50, 50));
					System.out.println("Your Dog will sure miss you.");
					System.out.println("Thanks admitting your Dog instead of discarding your Dog elsewhere...\n");

				} else if (petDecision.equalsIgnoreCase("Cat")) {
					System.out.println("Enter the name of the Cat being surrendered: ");
					String newPetName = input.nextLine();

					System.out.println("Enter a description for the Cat being surrendered: ");
					String newPetDescription = input.nextLine();

					pets.add(new Cat(newPetName, newPetDescription, 50, 50, 50, 50, 50));
					System.out.println("Your Cat will sure miss you.");
					System.out.println("Thanks admitting your pet instead of discarding your Cat elsewhere...\n");

				} else if (petDecision.equalsIgnoreCase("Robot Dog")) {
					System.out.println("Enter the name of the Robot Dog that you are surrendering.");
					String newPetName = input.nextLine();

					System.out.println("Enter a description for the Robot Dog being surrendered: ");
					String newPetDescription = input.nextLine();

					pets.add(new RobotDog(newPetName, newPetDescription, 50, 50, 50));
					System.out.println("Your Robot Pet will sure miss you.");
					System.out.println("Thanks admitting your pet instead of discarding your Robot Pet elsewhere...\n");
				}

			} else if (optionEntered.equals("7")) {
				System.out.println("Would you like to clean the Dog Kennels?");
				System.out.println("Yes or No");
				String newDecision = input.nextLine();
				if (newDecision.equalsIgnoreCase("Yes")) {
					pets.cleanDogKennels();
					System.out.println("Thanks for cleaning the Kennels!");
				} else if (newDecision.equalsIgnoreCase("No")) {
					System.out.println("Are you sure?");
					System.out.println("Some of the Kennels look like they need it.\n");
				}

			} else if (optionEntered.equals("8")) {
				System.out.println("Would you like to clean the Shelter Litter Box now?");
				System.out.println("Yes or No");
				String newDecision = input.nextLine();
				if (newDecision.equalsIgnoreCase("Yes")) {
					pets.litterBoxCleanUp();
					System.out.println("That litter box really needed it.");
					System.out.println("Thank you.\n");
				} else if (newDecision.equalsIgnoreCase("No")) {
					System.out.println("Are you sure? Are you really sure?");
					System.out.println("It seems to be getting full...\n");
				}

			} else if (optionEntered.equals("9")) {
				System.out.println("Are you sure you wish to quit the game?");
				System.out.println("Enter Yes or No");
				decision = input.nextLine();

				if (decision.equalsIgnoreCase("Yes")) {
					System.out.println("You have quit the game...");

				} else {
					decision.equalsIgnoreCase("No");
					System.out.println("Glad you are still with us.");
					System.out.println("The pets will be pleased that you stayed for a while longer.\n");
				}
			}
			pets.tickPets();
		}
		input.close();
	}
}