package edu.pjatk.inn.coffeemaker;

/**
 * Created by User on 2016-01-25.
 */

import edu.pjatk.inn.coffeemaker.impl.CoffeeMaker;
import edu.pjatk.inn.coffeemaker.impl.Inventory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sorcer.test.ProjectContext;
import org.sorcer.test.SorcerTestRunner;
import sorcer.service.ContextException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
@RunWith(SorcerTestRunner.class)
@ProjectContext("examples/coffeemaker")

public class InventoryTest {

    private final static Logger logger = LoggerFactory.getLogger(CoffeeMakerTest.class);

    private CoffeeMaker coffeeMaker;
   // private Inventory inventory;

    @Before
    public void setUp() throws ContextException {
        coffeeMaker = new CoffeeMaker();
    }

    @Test
    public void testAddInventory1(){
        assertTrue(coffeeMaker.addInventory(5,3,7,2));
    }

    @Test
    public void testAddInventory2(){
        assertFalse(coffeeMaker.addInventory(-1,0,0,0));
    }

    @Test
    public void testAddInventory3(){
        assertFalse(coffeeMaker.addInventory(5,-1,0,0));
    }

    @Test
    public void testAddInventory4(){
        assertFalse(coffeeMaker.addInventory(5,3,-1,0));
    }

    @Test
    public void testAddInventory5(){
        assertFalse(coffeeMaker.addInventory(5,3,7,-1));
    }

    @Test
    public void testAddInventory6(){
        assertFalse(coffeeMaker.addInventory('a',0,0,0));
    }

    @Test
    public void testAddInventory7(){
        assertFalse(coffeeMaker.addInventory(5,'a',0,0));
    }

    @Test
    public void testAddInventory8(){
        assertFalse(coffeeMaker.addInventory(5,3,'a',0));
    }

    @Test
    public void testAddInventory9(){
        assertFalse(coffeeMaker.addInventory(5,0,0,'a'));
    }

    @Test
    public void testcheckInventory(){
        assertEquals(coffeeMaker.checkInventory().getChocolate(),15);
        assertEquals(coffeeMaker.checkInventory().getCoffee(),15);
        assertEquals(coffeeMaker.checkInventory().getMilk(),15);
        assertEquals(coffeeMaker.checkInventory().getSugar(),15);

    }
}
