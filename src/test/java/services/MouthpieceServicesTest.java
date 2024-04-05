package services;
import models.Mouthpieces;
import models.Saxophones;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MouthpieceServicesTest {

    @Test
    public void mouthpieceCreateTest() {
        //given (1)
        String expectedManufacturer = "Selmer";
        String expectedModel = "Concept";
        String expectedType = "Soprano";
        String expectedMaterial = "Rubber";
        int expectedQuantity = 1;
        double expectedPrice = 158.84;

        //when (2)
        MouthpieceServices mouthpieceServices = new MouthpieceServices();
        Mouthpieces testMouthpiece = mouthpieceServices.create(expectedManufacturer, expectedModel, expectedType, expectedMaterial, expectedQuantity, expectedPrice);

        int actualId = testMouthpiece.getId();
        String actualManufacturer = testMouthpiece.getManufacturer();
        String actualModel = testMouthpiece.getModel();
        String actualType = testMouthpiece.getType();
        String actualMaterial = testMouthpiece.getMaterial();
        int actualQuantity = testMouthpiece.getQuantity();
        double actualPrice = testMouthpiece.getPrice();

        //then (3)
        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedManufacturer, actualManufacturer);
        Assertions.assertEquals(expectedModel, actualModel);
        Assertions.assertEquals(expectedType, actualType);
        Assertions.assertEquals(expectedMaterial, actualMaterial);
        Assertions.assertEquals(expectedQuantity, actualQuantity);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void mouthpieceFindTest() {
        MouthpieceServices mouthpieceServices = new MouthpieceServices();
        Mouthpieces testMouthpiece = mouthpieceServices.create("Selmer", "Concept", "Soprano", "Rubber", 1, 158.84);
        Assertions.assertEquals(testMouthpiece, mouthpieceServices.find(1));
    }

    @Test
    public void mouthpieceFindAllTest() {
        MouthpieceServices mouthpieceServices = new MouthpieceServices();
        Mouthpieces testMouthpiece1 = mouthpieceServices.create("Selmer", "Concept", "Soprano", "Rubber", 1, 158.84);
        Mouthpieces testMouthpiece2 = mouthpieceServices.create("Eugene Rousseau", "6R", "Baritone", "Rubber", 1, 149);
        Mouthpieces[] mouthpiecesInStock = {testMouthpiece1, testMouthpiece2};
        System.out.printf("Copy: \n%d\n%s\n%s\n%s\n%d\n%.2f\n\n", mouthpiecesInStock[0].getId(), mouthpiecesInStock[0].getManufacturer(),mouthpiecesInStock[0].getModel(),mouthpiecesInStock[0].getType(), mouthpiecesInStock[0].getQuantity(), mouthpiecesInStock[0].getPrice());
        System.out.printf("Original: \n%d\n%s\n%s\n%s\n%d\n%.2f\n", mouthpieceServices.findAll()[0].getId(), mouthpieceServices.findAll()[0].getManufacturer(),mouthpieceServices.findAll()[0].getModel(), mouthpieceServices.findAll()[0].getType(), mouthpieceServices.findAll()[0].getQuantity(), mouthpieceServices.findAll()[0].getPrice());
        Assertions.assertEquals(mouthpiecesInStock[0].getId(), mouthpieceServices.findAll()[0].getId());
    }

    @Test
    public void mouthpieceDeleteTest() {
        MouthpieceServices mouthpieceServices = new MouthpieceServices();
        Mouthpieces testMouthpiece1 = mouthpieceServices.create("Selmer", "Concept", "Soprano", "Rubber", 1, 158.84);
        Mouthpieces testMouthpiece2 = mouthpieceServices.create("Eugene Rousseau", "6R", "Baritone", "Rubber", 1, 149);

        Assertions.assertTrue(mouthpieceServices.delete(1));
    }
}
