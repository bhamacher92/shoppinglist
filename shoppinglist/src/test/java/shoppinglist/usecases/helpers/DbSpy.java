package shoppinglist.usecases.helpers;

import java.util.HashSet;
import java.util.Set;

import dbBoundary.IDatabase;
import shared.Recipe;
import shared.ShoppingList;

public class DbSpy implements IDatabase{

    public Set<String> shoppingListNames;
    public Set<String> recipeNames;
    public ShoppingList shoppinglistReturn;
    public Recipe recipeReturn;
    public ShoppingList shoppinglistAdded;
    public Recipe recipeAdded;

    public DbSpy(){
        shoppinglistReturn=new ShoppingList();
        recipeReturn=new Recipe();
        shoppingListNames=new HashSet<String>();
        recipeNames=new HashSet<String>();
    }

    public void addRecipe(Recipe recipe){
        this.recipeAdded=recipe;
    }
    public void addShoppingList(ShoppingList shoppingList){
        this.shoppinglistAdded=shoppingList;
    }
    public Set<String> getShoppingListNames(){
        return this.shoppingListNames;
    }
    public Set<String> getRecipeNames(){
        return this.recipeNames;
    }
    public ShoppingList getShoppingList(String name){
        return this.shoppinglistReturn;
    }
    public Recipe getRecipe(String name){
        return this.recipeReturn;
    }
}