package models;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

public class SaxophonesTest {

    @Test
    public void setModelTest() {
        //given (1)
        String expected = "AWO10";

        //when (2)
        Saxophones testSaxophone = new Saxophones();
        testSaxophone.setModel(expected);

        //then (3)
        Assert.assertEquals(expected, testSaxophone.getModel());
    }

    @Test
    public void setIdTest() {
        //given (1)
        int expected = 27190345;

        //when (2)
        Saxophones testSaxophone = new Saxophones();
        testSaxophone.setId(expected);

        //then (3)
        Assert.assertEquals(expected, testSaxophone.getId());
    }

    @Test
    public void setTypeTest() {
        //given (1)
        String expected = "Alto";

        //when (2)
        Saxophones testSaxophone = new Saxophones();
        testSaxophone.setType(expected);

        //then (3)
        Assert.assertEquals(expected, testSaxophone.getType());
    }

    @Test
    public void setManufacturerTest() {
        //given (1)
        String expected = "Yanagisawa";

        //when (2)
        Saxophones testSaxophone = new Saxophones();
        testSaxophone.setManufacturer(expected);

        //then (3)
        Assert.assertEquals(expected, testSaxophone.getManufacturer());
    }

    @Test
    public void setQuantityTest() {
        //given (1)
        int expected = 8;

        //when (2)
        Saxophones testSaxophone = new Saxophones();
        testSaxophone.setQuantity(expected);

        //then (3)
        Assert.assertEquals(expected, testSaxophone.getQuantity());
    }

    @Test
    public void setPriceTest() {
        //given (1)
        double expected = 5839.0;

        //when (2)
        Saxophones testSaxophone = new Saxophones();
        testSaxophone.setPrice(expected);

        //then (3)
        Assert.assertEquals(expected, testSaxophone.getPrice(), .0001);
    }

}

