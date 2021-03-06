package com.zakangroth.restservicesdemo.dto;

import com.zakangroth.restservicesdemo.model.Recipe;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RecipeDto {

    private Long id;
    private String name;
    private String picture;
    private String description;
    private Set<RecipeIngredientDto> ingredients = new HashSet<>();
    private Set<String> instructions = new HashSet<>();

    /**
     *  Mandatory for Spring
     */
    public RecipeDto() {

    }

    public RecipeDto(Recipe recipe) {
        this.id = recipe.getId();
        this.name = recipe.getName();
        this.picture = recipe.getPicture();
        this.description = recipe.getDescription();
        this.ingredients = recipe.getIngredients().stream().map(RecipeIngredientDto::new).collect(Collectors.toSet());
        this.instructions = recipe.getInstructions();
    }

    public Recipe toRecipe() {
        Recipe recipe = new Recipe();
        recipe.setId(this.id);
        recipe.setName(this.name);
        recipe.setPicture(this.picture);
        recipe.setDescription(this.description);
        recipe.setIngredients(this.getIngredients().stream().map(RecipeIngredientDto::toRecipeIngredient).collect(Collectors.toSet()));
        recipe.setInstructions(this.instructions);
        return recipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<RecipeIngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<RecipeIngredientDto> ingredientDtos) {
        this.ingredients = ingredientDtos;
    }

    public Set<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(Set<String> instructions) {
        this.instructions = instructions;
    }
}
