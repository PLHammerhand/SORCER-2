package edu.pjatk.inn.coffeemaker.impl;

import sorcer.core.context.ServiceContext;
import sorcer.core.exertion.ObjectBlock;
import sorcer.service.Context;
import sorcer.service.ContextException;

import java.io.Serializable;

/**
 * @author   Sarah & Mike
 */
public class Recipe implements Serializable {
	private final int WRONG_OBJECT = -1;

    private String name;
    private int price;
    private int amtCoffee;
    private int amtMilk;
    private int amtSugar;
    private int amtChocolate;
    
    public Recipe() {
    	this.name = "";
    	this.price = 0;
    	this.amtCoffee = 0;
    	this.amtMilk = 0;
    	this.amtSugar = 0;
    	this.amtChocolate = 0;
    }

	/**
	 * Returns amount of chocolate used for specified recipe.
	 *
	 * @return   Returns the amtChocolate.
	 */
    public int getAmtChocolate() {
		return amtChocolate;
	}
	/**
	 * Sets atmChocolate as an amount of chocolate necessary for the recipe.
	 *
	 * @param amtChocolate   The amtChocolate to set.
	 */
    public void setAmtChocolate(Object amtChocolate)
	{
		this.amtChocolate = WRONG_OBJECT;

		if(amtChocolate instanceof Integer)
		{
			if ((int) amtChocolate >= 0)
			{
				this.amtChocolate = (int) amtChocolate;
			}
		}
	}
	/**
	 * Returns amount of coffee used for specified recipe.
	 *
	 * @return   Returns the amtCoffee.
	 */
    public int getAmtCoffee() {
		return amtCoffee;
	}
	/**
	 * Sets amtCoffe as an amount of coffee necessary for the recipe.
	 *
	 * @param amtCoffee   The amtCoffee to set.
	 */
    public void setAmtCoffee(Object amtCoffee)
	{
		this.amtCoffee = WRONG_OBJECT;

		if(amtCoffee instanceof Integer)
		{
			if ((int)amtCoffee >= 0)
			{
				this.amtCoffee = (int)amtCoffee;
			}
		}
	}
	/**
	 * Returns amount of milk used for specified recipe.
	 *
	 * @return   Returns the amtMilk.
	 */
    public int getAmtMilk() {
		return amtMilk;
	}
    /**
	 * Sets amtMilk as an amount of milk necessary for the recipe.
	 *
	 * @param amtMilk   The amtMilk to set.
	 */
    public void setAmtMilk(Object amtMilk)
	{
		this.amtMilk = WRONG_OBJECT;

		if(amtMilk instanceof Integer)
		{
			if ((int) amtMilk >= 0)
			{
				this.amtMilk = (int) amtMilk;
			}
		}
	}
	/**
	 * Returns amount of sugar used for specified recipe.
	 *
	 * @return   Returns the amtSugar.
	 */
    public int getAmtSugar() {
		return amtSugar;
	}
    /**
	 * Sets amtSugar as an amount of milk necessary for the recipe.
	 *
	 * @param amtSugar   The amtSugar to set.
	 */
    public void setAmtSugar(Object amtSugar)
	{
		this.amtSugar = WRONG_OBJECT;

		if(amtSugar instanceof Integer)
		{
			if ((int) amtSugar >= 0)
			{
				this.amtSugar = (int) amtSugar;
			}
		}
	}
    /**
     * Returns the name of specified recipe.
     *
	 * @return   Returns the name.
	 */
    public String getName() {
		return name;
	}
    /**
     * Sets name as the name of specified recipe.
     *
	 * @param name   The name to set.
	 */
    public void setName(String name) {
    	if(name != null) {
    		this.name = name;
    	}
	}
    /**
     * Returns the price of specified recipe.
     *
	 * @return   Returns the price.
	 */
    public int getPrice() {
		return price;
	}
    /**
     * Sets price as the price of specified recipe.
     *
	 * @param price   The price to set.
	 */
    public void setPrice(Object price)
	{
		this.price = WRONG_OBJECT;

		if(price instanceof Integer)
		{
			if ((int) price >= 0)
			{
				this.price = (int) price;
			}
		}
	}
	/**
	 * Compares two recipes' names and returns true if both are the same.
	 *
	 * @param r		Recipe to compare with.
	 * @return		Returns true if both recipes' names are same.
	 */
    public boolean equals(Recipe r) {
        if((this.name).equals(r.getName())) {
            return true;
        }
        return false;
    }
	/**
	 * ToString method.
	 *
	 * @return		Returns the name.
	 */
    public String toString() {
    	return name;
    }
    /**
     * Static function that returns recipe from given context.
     *
     * @param context				Context to get the recipe.
     * @return						Recipe from the context.
     * @throws ContextException
     */
	static public Recipe getRecipe(Context context) throws ContextException {
		Recipe r = new Recipe();
		r.name = (String)context.getValue("name");
		r.price = (int)context.getValue("price");
		r.amtCoffee = (int)context.getValue("amtCoffee");
		r.amtMilk = (int)context.getValue("amtMilk");
		r.amtSugar = (int)context.getValue("amtSugar");
		r.amtChocolate = (int)context.getValue("amtChocolate");
		return r;
	}
    /**
     * Static function that returns context from given recipe.
     *
     * @param recipe				Recipe to get the context.
     * @return						Context from the recipe.
     * @throws ContextException
     */
	static public Context getContext(Recipe recipe) throws ContextException {
		Context cxt = new ServiceContext();
		cxt.putValue("name", recipe.getName());
		cxt.putValue("price", recipe.getPrice());
		cxt.putValue("amtCoffee", recipe.getAmtCoffee());
		cxt.putValue("amtMilk", recipe.getAmtMilk());
		cxt.putValue("amtSugar", recipe.getAmtSugar());
		cxt.putValue("amtChocolate", recipe.getAmtChocolate());
		return cxt;
	}


}
