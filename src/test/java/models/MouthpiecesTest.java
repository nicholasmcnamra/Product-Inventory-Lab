package models;

import org.junit.Assert;
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
        Assert.assertEquals(expected, testMouthpiece.getModel());
    }

    @Test
    public void setIdTest() {
        //given (1)
        int expected = 37204838;

        //when (2)
        Mouthpieces testMouthpiece = new Mouthpieces();
        testMouthpiece.setId(expected);

        //then (3)
        Assert.assertEquals(expected, testMouthpiece.getId());
    }

    @Test
    public void setTypeTest() {
        //given (1)
        String expected = "Soprano";

        //when (2)
        Mouthpieces testMouthpiece = new Mouthpieces();
        testMouthpiece.setType(expected);

        //then (3)
        Assert.assertEquals(expected, testMouthpiece.getType());
    }

    @Test
    public void setMaterialTest() {
        //given (1)
        String expected = "Rubber";

        //when (2)
        Mouthpieces testMouthpiece = new Mouthpieces();
        testMouthpiece.setMaterial(expected);

        //then (3)
        Assert.assertEquals(expected, testMouthpiece.getMaterial());
    }

    @Test
    public void setManufacturerTest() {
        //given (1)
        String expected = "Selmer";

        //when (2)
        Mouthpieces testMouthpiece = new Mouthpieces();
        testMouthpiece.setManufacturer(expected);

        //then (3)
        Assert.assertEquals(expected, testMouthpiece.getManufacturer());
    }

    @Test
    public void setQuantityTest() {
        //given (1)
        int expected = 75;

        //when (2)
        Mouthpieces testMouthpiece = new Mouthpieces();
        testMouthpiece.setQuantity(expected);

        //then (3)
        Assert.assertEquals(expected, testMouthpiece.getQuantity());
    }

    @Test
    public void setPriceTest() {
        //given (1)
        double expected = 158.84;

        //when (2)
        Mouthpieces testMouthpiece = new Mouthpieces();
        testMouthpiece.setPrice(expected);

        //then (3)
        Assert.assertEquals(expected, testMouthpiece.getPrice(), .0001);
    }
}
