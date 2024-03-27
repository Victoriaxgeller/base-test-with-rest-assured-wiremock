import api.swagger.fake.model.Pet;
import org.junit.jupiter.api.*;
import api.swagger.fake.steps.PetSteps;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetTest {

    PetSteps petSteps = new PetSteps();

    private final int TEST_PET_ID = 24;
    private final String TEST_PET_NAME = "Cooper";
    private final String TEST_PET_NAME_UPD = "Lucie";
    private final String TEST_PET_STATUS = "available";
    private final String TEST_PET_STATUS_UPD = "unavailable";


    @Test
    @Tag("flacky")
    @Order(2)
    public void getPetById() {
        Pet responsePet = petSteps.getPetById(TEST_PET_ID);

        assertAll(
                "Grouped Assertions of Pet",
                () -> assertEquals(TEST_PET_ID, responsePet.getId(), "Pet id should be " + TEST_PET_ID),
                () -> assertEquals(TEST_PET_NAME, responsePet.getName(), "Pet's name should be " + TEST_PET_NAME),
                () -> assertEquals(TEST_PET_STATUS, responsePet.getStatus(), "Pet' status should be " + TEST_PET_STATUS)
        );
    }

    @Test
    @Order(1)
    public void createNewPetTest() {
        Pet pet = new Pet();
        pet.setName(TEST_PET_NAME);
        pet.setId(TEST_PET_ID);
        pet.setStatus(TEST_PET_STATUS);

        Pet responsePet = petSteps.addNewPet(pet);
        assertAll(
                "Grouped Assertions of Pet",
                () -> assertEquals(TEST_PET_ID, responsePet.getId(), "Pet id should be " + TEST_PET_ID),
                () -> assertEquals(TEST_PET_NAME, responsePet.getName(), "Pet's name should be " + TEST_PET_NAME),
                () -> assertEquals(TEST_PET_STATUS, responsePet.getStatus(), "Pet' status should be " + TEST_PET_STATUS));
    }

    @Test
    @Order(3)
    public void updatePetTest() {
        Pet pet = new Pet();
        pet.setId(27);
        pet.setName(TEST_PET_NAME_UPD);
        pet.setStatus(TEST_PET_STATUS_UPD);

        Pet responsePet = petSteps.updatePet(pet);
        assertAll(
                "Grouped Assertions of Pet",
                () -> assertEquals(TEST_PET_ID, responsePet.getId(), "Pet id should be " + 27),
                () -> assertEquals(TEST_PET_NAME_UPD, responsePet.getName(), "Pet's name should be " + TEST_PET_NAME_UPD),
                () -> assertEquals(TEST_PET_STATUS_UPD, responsePet.getStatus(), "Pet' status should be " + TEST_PET_STATUS_UPD)
        );
    }

}
