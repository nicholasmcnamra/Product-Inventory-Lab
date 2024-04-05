package models;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MouthpiecesTest {

    @Test
    public void setModelTest() {
        //given (1)
        String expected = "Concept";

        //when (2)
        Mouthpieces testMouthpiece = new Mouthpieces();
        testMouthpiece.setModel(expected);

        //then (3)
        Assertions.assertEquals(expected, testMouthpiece.getModel());
    }

    @Test
    public void setIdTest() {
        //given (1)
        int expected = 37204838;

        //when (2)
        Mouthpieces testMouthpiece = new Mouthpieces();
        testMouthpiece.setId(expected);

        //then (3)
        Assertions.assertEquals(expected, testMouthpiece.getId());
    }

    @Test
    public void setTypeTest() {
        //given (1)
        String expected = "Soprano";

        //when (2)
        Mouthpieces testMouthpiece = new Mouthpieces();
        testMouthpiece.setType(expected);

        //then (3)
        Assertions.assertEquals(expected, testMouthpiece.getType());
    }

    @Test
    public void setMaterialTest() {
        //given (1)
        String expected = "Rubber";

        //when (2)
        Mouthpieces testMouthpiece = new Mouthpieces();
        testMouthpiece.setMaterial(expected);

        //then (3)
        Assertions.assertEquals(expected, testMouthpiece.getMaterial());
    }

    @Test
    public void setManufacturerTest() {
        //given (1)
        String expected = "Selmer";

        //when (2)
        Mouthpieces testMouthpiece = new Mouthpieces();
        testMouthpiece.setManufacturer(expected);

        //then (3)
        Assertions.assertEquals(expected, testMouthpiece.getManufacturer());
    }

    @Test
    public void setQuantityTest() {
        //given (1)
        int expected = 75;

        //when (2)
        Mouthpieces testMouthpiece = new Mouthpieces();
        testMouthpiece.setQuantity(expected);

        //then (3)
        Assertions.assertEquals(expected, testMouthpiece.getQuantity());
    }

    @Test
    public void setPriceTest() {
        //given (1)
        double expected = 158.84;

        //when (2)
        Mouthpieces testMouthpiece = new Mouthpieces();
        testMouthpiece.setPrice(expected);

        //then (3)
        Assertions.assertEquals(expected, testMouthpiece.getPrice(), .0001);
    }

    @Test
    public void constructorTest() {
        //given (1)
        int id = 37204838;
        String manufacturer = "Selmer";
        String model = "Concept";
        String type = "Soprano";
        String material = "Rubber";
        int quantity = 75;
        double price = 158.84;

        //when (2)
        Mouthpieces testMouthpiece = new Mouthpieces(id, manufacturer, model, type, material, quantity, price);

        //then (3)
        Assertions.assertEquals(id, testMouthpiece.getId());
        Assertions.assertEquals(manufacturer, testMouthpiece.getManufacturer());
        Assertions.assertEquals(model, testMouthpiece.getModel());
        Assertions.assertEquals(type, testMouthpiece.getType());
        Assertions.assertEquals(material, testMouthpiece.getMaterial());
        Assertions.assertEquals(quantity, testMouthpiece.getQuantity());
        Assertions.assertEquals(price, testMouthpiece.getPrice());
    }
}
