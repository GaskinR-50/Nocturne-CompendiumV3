package com.example.finalchance;



public class Recipe {
    String name;
    String recipe;

    public Recipe(String name, String recipe){
        this.name= name;
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }


}
