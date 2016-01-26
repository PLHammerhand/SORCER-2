package edu.pjatk.inn.coffeemaker;

import edu.pjatk.inn.coffeemaker.impl.CoffeeMaker;
import edu.pjatk.inn.coffeemaker.impl.Inventory;
import edu.pjatk.inn.coffeemaker.impl.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sorcer.test.ProjectContext;
import org.sorcer.test.SorcerTestRunner;
import sorcer.service.ContextException;
import sorcer.service.Exertion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static sorcer.eo.operator.*;

/**
 * Created by Marek on 2016-01-25.
 */

@RunWith(SorcerTestRunner.class)
@ProjectContext("examples/coffeemaker")
public class RecipeTest
{
    private CoffeeMaker coffeeMaker;
    private Inventory inventory;

    @Before
    public void setUp() throws ContextException
    {
        coffeeMaker = new CoffeeMaker();
        inventory = coffeeMaker.checkInventory();
    }

    @Test
    public void addRecipe1() throws Exception
    {
        Recipe r = new Recipe();
        r.setName("Coffee");
        r.setPrice(50);
        r.setAmtCoffee(3);
        r.setAmtMilk(1);
        r.setAmtSugar(1);
        r.setAmtChocolate(0);

        assertTrue(coffeeMaker.addRecipe(r));
    }

    @Test
    public void addRecipe2() throws Exception
    {
        Recipe r = new Recipe();
        r.setName("Coffee");
        r.setPrice(50);
        r.setAmtCoffee(3);
        r.setAmtMilk(1);
        r.setAmtSugar(1);
        r.setAmtChocolate(0);

        assertFalse(coffeeMaker.addRecipe(r));
    }

    @Test
    public void addRecipe3() throws Exception
    {
        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(-50);

        assertFalse(coffeeMaker.addRecipe(r));
    }

    @Test
    public void addRecipe4() throws Exception
    {
        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(50);
        r.setAmtCoffee(-3);

        assertFalse(coffeeMaker.addRecipe(r));
    }

    @Test
    public void addRecipe5() throws Exception
    {
        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee(3);
        r.setAmtMilk(-2);

        assertFalse(coffeeMaker.addRecipe(r));
    }

    @Test
    public void addRecipe6() throws Exception
    {
        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee(3);
        r.setAmtMilk(2);
        r.setAmtSugar(-2);

        assertFalse(coffeeMaker.addRecipe(r));
    }

    @Test
    public void addRecipe7() throws Exception
    {
        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee(3);
        r.setAmtMilk(2);
        r.setAmtSugar(2);
        r.setAmtChocolate(-3);

        assertFalse(coffeeMaker.addRecipe(r));
    }

    @Test
    public void addRecipe8() throws Exception
    {
        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice('a');

        assertFalse(coffeeMaker.addRecipe(r));
    }

    @Test
    public void addRecipe9() throws Exception
    {
        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee('a');

        assertFalse(coffeeMaker.addRecipe(r));
    }

    @Test
    public void addRecipe10() throws Exception
    {
        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee(3);
        r.setAmtMilk('a');

        assertFalse(coffeeMaker.addRecipe(r));
    }

    @Test
    public void addRecipe11() throws Exception
    {
        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee(3);
        r.setAmtMilk(2);
        r.setAmtSugar('a');

        assertFalse(coffeeMaker.addRecipe(r));
    }

    @Test
    public void addRecipe12() throws Exception
    {
        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee(3);
        r.setAmtMilk(2);
        r.setAmtSugar(2);
        r.setAmtChocolate('a');

        assertFalse(coffeeMaker.addRecipe(r));
    }

    @Test
    public void addRecipe13() throws Exception
    {
        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee(3);
        r.setAmtMilk(2);
        r.setAmtSugar(2);
        r.setAmtChocolate(3);

        assertTrue(coffeeMaker.addRecipe(r));
    }

    @Test
    public void addRecipe14() throws Exception
    {
        Recipe r = new Recipe();
        r.setName("Latte");
        r.setPrice(60);
        r.setAmtCoffee(3);
        r.setAmtMilk(2);
        r.setAmtSugar(2);
        r.setAmtChocolate(0);

        assertTrue(coffeeMaker.addRecipe(r));
    }

    @Test
    public void addRecipe15() throws Exception
    {
        Recipe r = new Recipe();
        r.setName("Hot Chocolate");
        r.setPrice(60);
        r.setAmtCoffee(0);
        r.setAmtMilk(2);
        r.setAmtSugar(2);
        r.setAmtChocolate(3);

        assertFalse(coffeeMaker.addRecipe(r));
    }

    @Test
    public void deleteRecipe1() throws Exception
    {
        addRecipe1();

        Recipe r = coffeeMaker.getRecipeForName("Coffee");

        assertTrue(coffeeMaker.deleteRecipe(r));
    }

    @Test
    public void deleteRecipe2() throws Exception
    {
        assertFalse(coffeeMaker.deleteRecipes());
    }

    @Test
    public void editRecipe1() throws Exception
    {
        addRecipe1();

        Recipe r = new Recipe();
        r.setName("Coffee");
        r.setPrice(50);
        r.setAmtCoffee(3);
        r.setAmtMilk(1);
        r.setAmtSugar(1);
        r.setAmtChocolate(0);

        assertTrue(coffeeMaker.editRecipe(coffeeMaker.getRecipeForName("Coffee"), r));
    }

    @Test
    public void editRecipe2() throws Exception
    {
        addRecipe1();

        Recipe r = new Recipe();
        r.setName("Coffee");
        r.setPrice(50);
        r.setAmtCoffee(3);
        r.setAmtMilk(1);
        r.setAmtSugar(1);
        r.setAmtChocolate(0);

        assertFalse(coffeeMaker.editRecipe(coffeeMaker.getRecipeForName("Coffee"), r));
    }

    @Test
    public void editRecipe3() throws Exception
    {
        addRecipe1();

        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(-60);

        assertFalse(coffeeMaker.editRecipe(coffeeMaker.getRecipeForName("Coffee"), r));
    }

    @Test
    public void editRecipe4() throws Exception
    {
        addRecipe1();

        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee(-3);

        assertFalse(coffeeMaker.editRecipe(coffeeMaker.getRecipeForName("Coffee"), r));
    }

    @Test
    public void editRecipe5() throws Exception
    {
        addRecipe1();

        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee(3);
        r.setAmtMilk(-2);

        assertFalse(coffeeMaker.editRecipe(coffeeMaker.getRecipeForName("Coffee"), r));
    }

    @Test
    public void editRecipe6() throws Exception
    {
        addRecipe1();

        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee(3);
        r.setAmtMilk(2);
        r.setAmtSugar(-2);

        assertFalse(coffeeMaker.editRecipe(coffeeMaker.getRecipeForName("Coffee"), r));
    }

    @Test
    public void editRecipe7() throws Exception
    {
        addRecipe1();

        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee(3);
        r.setAmtMilk(2);
        r.setAmtSugar(2);
        r.setAmtChocolate(-3);

        assertFalse(coffeeMaker.editRecipe(coffeeMaker.getRecipeForName("Coffee"), r));
    }

    @Test
    public void editRecipe8() throws Exception
    {
        addRecipe1();

        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice('a');

        assertFalse(coffeeMaker.editRecipe(coffeeMaker.getRecipeForName("Coffee"), r));
    }

    @Test
    public void editRecipe9() throws Exception
    {
        addRecipe1();

        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee('a');

        assertFalse(coffeeMaker.editRecipe(coffeeMaker.getRecipeForName("Coffee"), r));
    }

    @Test
    public void editRecipe10() throws Exception
    {
        addRecipe1();

        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee(3);
        r.setAmtMilk('a');

        assertFalse(coffeeMaker.editRecipe(coffeeMaker.getRecipeForName("Coffee"), r));
    }

    @Test
    public void editRecipe11() throws Exception
    {
        addRecipe1();

        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee(3);
        r.setAmtMilk(2);
        r.setAmtSugar('a');

        assertFalse(coffeeMaker.editRecipe(coffeeMaker.getRecipeForName("Coffee"), r));
    }

    @Test
    public void editRecipe12() throws Exception
    {
        addRecipe1();

        Recipe r = new Recipe();
        r.setName("Mocha");
        r.setPrice(60);
        r.setAmtCoffee(3);
        r.setAmtMilk(2);
        r.setAmtSugar(2);
        r.setAmtChocolate('a');

        assertFalse(coffeeMaker.editRecipe(coffeeMaker.getRecipeForName("Coffee"), r));
    }
}
