package carTrip;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private Car car;

    @Before
    public void setUp(){
        this.car=new Car("Audi",60,10,8);
    }
    @Test
    public void testConstructor(){
        Assert.assertNotNull(car);
    }
    @Test
    public void testGetModel(){
        String expectedModel="Audi";
        Assert.assertEquals(expectedModel,car.getModel());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetModelInvalid(){
        car.setModel(null);
    }
    @Test
    public void testSetModelValid(){
        car.setModel("BMW");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetModelWhenIsEmpty(){
        car.setModel("");
    }
    @Test
    public void testGetTankCapacity(){
       double expectedTC=60;
       Assert.assertEquals(expectedTC,car.getTankCapacity(),0.00);
    }
    @Test
    public void testSetTankCapacity(){
        car.setTankCapacity(60);
    }
    @Test
    public void testGetFuelAmount(){
        double expected=10;
        Assert.assertEquals(expected,car.getFuelAmount(),0.0);
    }
    @Test
    public void testSetFuelAmountValid(){
        car.setFuelAmount(10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetFuelAmountInvalid(){
        car.getTankCapacity();
        car.setFuelAmount(100);
    }
    @Test
    public void testGetFuelConsumptionPerKm(){
        Assert.assertEquals(8,car.getFuelConsumptionPerKm(),0.00);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetFuelConsumptionWhenIsLessThan0(){
        car.setFuelConsumptionPerKm(-12);
    }
    @Test
    public void testSetFuelConsumptionWhenIsValid(){
        car.setFuelConsumptionPerKm(12);
    }
    @Test(expected = IllegalStateException.class)
    public void testDriveInvalid(){
        //tripcons=distance*8  //5*8=40
        //fuelAmount<trip
        //10<40
        car.drive(5);
    }
    @Test
    public void testDriveIsValid(){
        car.drive(1);
    }
    @Test
    public void testDriveIsValid2(){
        Assert.assertEquals("Have a nice trip",car.drive(1));
    }
    @Test(expected = IllegalStateException.class)
    public void refuelInvalid(){
        //total=10+amount
        //total>tankcapacity(60)
        car.refuel(100);
    }
    @Test
    public void refuelValid(){
        car.refuel(20);
    }



}