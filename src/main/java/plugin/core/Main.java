package plugin.core;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.events.HitPlayer;
import plugin.recipes.CraftingRecipes;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        setRecipes();
        setEvents();
        Bukkit.getConsoleSender().sendMessage("Magic Sticks está activado");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("Magic Sticks está desactivado");
    }

    public void setEvents() {
        getServer().getPluginManager().registerEvents(new HitPlayer(), this);
    }

    public void setRecipes() {
        CraftingRecipes craftingRecipes = new CraftingRecipes(this);

        List<Recipe> recipes = new ArrayList<>();
        recipes.add(craftingRecipes.getKnockbackStick());
        recipes.add(craftingRecipes.getStickOfDOOM());

        recipes.forEach(recipe -> Bukkit.addRecipe(recipe));
    }
}
