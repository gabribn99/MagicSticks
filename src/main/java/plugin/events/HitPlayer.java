package plugin.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import plugin.utils.Utils;

public class HitPlayer implements Listener {
    @EventHandler
    public void entrada(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            ItemStack itemInHand = ((Player) event.getDamager()).getInventory().getItemInMainHand();
            ItemMeta meta = itemInHand.getItemMeta();
            String itemName;
            if (meta != null && meta.hasDisplayName()) {
                itemName = meta.getDisplayName();
            } else {
                itemName = Utils.capitalizeFully(itemInHand.getType().getKey().getKey().toLowerCase().replace("_", " "));
            }
            effects(itemName, event.getDamager(), event.getEntity(), event.getFinalDamage());
        }
    }

    private void effects(String itemName, Entity damagerEntity, Entity damaged, double damage) {
        if (damagerEntity instanceof Player) {
            Player damager = (Player) damagerEntity;
            if (itemName.equals(ChatColor.RED + "Stick of Doom")) {
                World world = damaged.getLocation().getWorld();
                if (damaged instanceof Player) {
                    damager.sendMessage("Player");
                    int dice = (int) ((Math.random() * 6) + 1);
                    damager.sendMessage("Dado: " + dice);
                    switch (dice) {
                        case 1:
                            damager.teleport(new Location(world, 0, -150, 0));
                            damager.sendMessage(ChatColor.DARK_RED + "El destino ha decidido castigarte por abusar del poder que se te ha concedido");
                            break;
                        case 6:
                            damaged.teleport(new Location(world, 0, -150, 0));
                            damaged.sendMessage(ChatColor.GOLD + "Has sido condenado");
                            damager.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Sangre para el dios de la sangre y calaveras para el trono de las calaveras");
                            break;
                        default:
                            double increaseLife = damager.getHealth() + damage;
                            if (increaseLife > 20) {
                                increaseLife = 20;
                            }
                            damager.setHealth(increaseLife);
                            damager.sendMessage("Has sido recompensado por tu sacrificio");
                    }
                } else {
                    damager.sendMessage("Mob");
                    int dice = (int) ((Math.random() * 10) + 1);
                    damager.sendMessage("Dado: " + dice);
                    switch (dice) {
                        case 1:
                            damager.teleport(new Location(world, 0, -150, 0));
                            damager.sendMessage(ChatColor.DARK_RED + "El destino ha decidido castigarte por abusar del poder que se te ha concedido");
                            break;
                        case 10:
                            damaged.teleport(new Location(world, 0, -150, 0));
                            damaged.sendMessage(ChatColor.GOLD + "Has sido condenado");
                            damager.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Sangre para el dios de la sangre y calaveras para el trono de las calaveras");
                            break;
                        default:
                            double increaseLife = damager.getHealth() + damage;
                            if (increaseLife > 20) {
                                increaseLife = 20;
                            }
                            damager.setHealth(increaseLife);
                            damager.sendMessage("Has sido recompensado por tu sacrificio");
                    }
                }
            }
        }
    }
}
