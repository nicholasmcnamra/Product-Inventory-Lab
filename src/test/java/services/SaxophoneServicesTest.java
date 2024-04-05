package services;
import models.Saxophones;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SaxophoneServicesTest {

    @Test
    public void saxophoneCreateTest() {
        //given (1)
        String expectedManufacturer = "Yanagisawa";
        String expectedModel = "AWO10";
        String expectedType = "Alto";
        int expectedQuantity = 8;
        double expectedPrice = 5839.0;

        //when (2)
        SaxophoneServices saxophoneServices = new SaxophoneServices();
        Saxophones testSaxophone = saxophoneServices.create(expectedManufacturer, expectedModel, expectedType, expectedQuantity, expectedPrice);

        int actualId = testSaxophone.getId();
        String actualManufacturer = testSaxophone.getManufacturer();
        String actualModel = testSaxophone.getModel();
        String actualType = testSaxophone.getType();
        int actualQuantity = testSaxophone.getQuantity();
        double actualPrice = testSaxophone.getPrice();

        //then (3)
        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedManufacturer, actualManufacturer);
        Assertions.assertEquals(expectedModel, actualModel);
        Assertions.assertEquals(expectedType, actualType);
        Assertions.assertEquals(expectedQuantity, actualQuantity);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void saxophoneFindTest() {
        SaxophoneServices saxophoneServices = new SaxophoneServices();
        Saxophones testSaxophone = saxophoneServices.create("Yanagisawa", "AWO10", "Alto", 1,5839.0);
        Assertions.assertEquals(testSaxophone, saxophoneServices.find(1));
    }

    @Test
    public void saxophoneFindAllTest() {
        SaxophoneServices saxophoneServices = new SaxophoneServices();
        Saxophones testSaxophone1 = saxophoneServices.create("Yanagisawa", "AWO10", "Alto", 1, 5839.0);
        Saxophones testSaxophone2 = saxophoneServices.create("Selmer", "Serie ii", "Soprano", 1, 5629.0);
        Saxophones[] saxophonesInStock = {testSaxophone1, testSaxophone2};
        System.out.printf("Copy: \n%d\n%s\n%s\n%s\n%d\n%.2f\n\n", saxophonesInStock[0].getId(), saxophonesInStock[0].getManufacturer(),saxophonesInStock[0].getModel(),saxophonesInStock[0].getType(), saxophonesInStock[0].getQuantity(), saxophonesInStock[0].getPrice());
        System.out.printf("Original: \n%d\n%s\n%s\n%s\n%d\n%.2f\n", saxophoneServices.findAll()[0].getId(), saxophoneServices.findAll()[0].getManufacturer(),saxophoneServices.findAll()[0].getModel(), saxophoneServices.findAll()[0].getType(), saxophoneServices.findAll()[0].getQuantity(), saxophoneServices.findAll()[0].getPrice());
        Assertions.assertEquals(saxophonesInStock[0].getId(), saxophoneServices.findAll()[0].getId());
    }

    @Test
    public void saxophoneDeleteTest() {
        SaxophoneServices saxophoneServices = new SaxophoneServices();
        Saxophones testSaxophone1 = saxophoneServices.create("Yanagisawa", "AWO10", "Alto", 1, 5839.0);
        Saxophones testSaxophone2 = saxophoneServices.create("Selmer", "Serie ii", "Soprano", 1, 5629.0);

        Assertions.assertTrue(saxophoneServices.delete(1));
    }

}
