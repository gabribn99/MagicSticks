package plugin.recipes;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class CraftingRecipes {
    Plugin plugin;

    public CraftingRecipes(Plugin plugin) {
        this.plugin = plugin;
    }

    public ShapedRecipe getKnockbackStick() {
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Knockback Stick");
        item.setItemMeta(meta);
        item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 400);

        NamespacedKey key = new NamespacedKey(plugin, "knockback_stick");
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" B ", "BSB", " B ");
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('B', Material.SLIME_BLOCK);
        return recipe;
    }

    public ShapedRecipe getStickOfDOOM() {
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Stick of Doom");
        item.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(plugin, "doom_stick");
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" F ", "ESN");
        recipe.setIngredient('F', Material.WITHER_ROSE);
        recipe.setIngredient('E', Material.ENDER_PEARL);
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('N', Material.NETHER_STAR);

        return recipe;
    }
}
