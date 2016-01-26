package edu.pjatk.inn.coffeemaker;

/**
 * Created by User on 2016-01-25.
 */

import edu.pjatk.inn.coffeemaker.impl.CoffeeMaker;
import edu.pjatk.inn.coffeemaker.impl.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sorcer.test.ProjectContext;
import org.sorcer.test.SorcerTestRunner;
import sorcer.service.ContextException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SorcerTestRunner.class)
@ProjectContext("examples/coffeemaker")

public class BeverageTest {

    private final static Logger logger = LoggerFactory.getLogger(CoffeeMakerTest.class);

    private CoffeeMaker coffeeMaker;
    private Recipe espresso, mocha, macchiato, americano;
    Recipe [] r = new Recipe[4];


    @Before
    public void setUp() throws ContextException {
        coffeeMaker = new CoffeeMaker();
        assertTrue(coffeeMaker.addInventory(5,3,7,2));

        espresso = new Recipe();
        espresso.setName("espresso");
        espresso.setPrice(50);
        espresso.setAmtCoffee(6);
        espresso.setAmtMilk(1);
        espresso.setAmtSugar(1);
        espresso.setAmtChocolate(0);

        mocha = new Recipe();
        mocha.setName("mocha");
        mocha.setPrice(100);
        mocha.setAmtCoffee(8);
        mocha.setAmtMilk(1);
        mocha.setAmtSugar(1);
        mocha.setAmtChocolate(2);

        macchiato = new Recipe();
        macchiato.setName("macchiato");
        macchiato.setPrice(40);
        macchiato.setAmtCoffee(7);
        macchiato.setAmtMilk(1);
        macchiato.setAmtSugar(2);
        macchiato.setAmtChocolate(0);

        americano = new Recipe();
        americano.setName("americano");
        americano.setPrice(40);
        americano.setAmtCoffee(7);
        americano.setAmtMilk(1);
        americano.setAmtSugar(2);
        americano.setAmtChocolate(0);

        r [0] = americano;
        r [1] = mocha;
        r [2] = macchiato;
        r [3] = espresso;
    }

    @Test
    public void testPurchaseBeverage1(){
        assertEquals(coffeeMaker.makeCoffee(r[3],60),10);
    }

    @Test
    public void testPurchaseBeverage2(){
        if(coffeeMaker.makeCoffee(r[3],60)==10){
            assertEquals(coffeeMaker.makeCoffee(r[3],40), 40);
            assertEquals(coffeeMaker.checkInventory().getSugar(), 15);
            assertEquals(coffeeMaker.checkInventory().getCoffee(), 15);
            assertEquals(coffeeMaker.checkInventory().getMilk(), 15);
            assertEquals(coffeeMaker.checkInventory().getChocolate(), 15);
        }
    }

    @Test
    public void testPurchaseBeverage3(){
        Recipe myCoffee = new Recipe();
        myCoffee.setAmtCoffee(16);
        myCoffee.setAmtMilk(2);
        myCoffee.setAmtSugar(4);
        myCoffee.setAmtChocolate(5);
        myCoffee.setName("mycoffe");
        r [3] = myCoffee;

        assertEquals(coffeeMaker.makeCoffee(r[3],50),50);
    }

}
