package aor.Spells.Spells;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import aor.Spells.Runnables.NetRunnables;
import aor.Spells.SpellsMain;
import aor.Spells.Spell;

public class NetSpell extends Spell {

	public static SpellsMain plugin;
	int MAXDISTANCE = 50;

	public NetSpell(SpellsMain instance) // Constructor.
	{
		plugin = instance;
		spellName = "Net";
		spellDescription = "Freezes all entities within 10 blocks of the player for 10 seconds.";
		shortName = "Net";


		setRequiredItems(new ItemStack(Material.STRING, 10)); // We need 10 string.
	}

	public void castSpell(Player player) {
		PlayerInventory inventory = player.getInventory();

		if (checkInventoryRequirements(inventory)) {
			removeRequiredItemsFromInventory(inventory); // Remove the items.

			List<Entity> nearbyEntities = player.getNearbyEntities(10, 10, 10);
			ArrayList<Location> blockLocs = new ArrayList<Location>();
			for (int i = 0; i < nearbyEntities.size(); i++) {
				Entity currentCreature = nearbyEntities.get(i);
				if (!(currentCreature instanceof Player || currentCreature instanceof Item)) // You can't freeze players or items with this spell.
				{
					Location loc = currentCreature.getLocation();
					blockLocs.add(loc);
					loc.getWorld().getBlockAt(loc).setType(Material.WEB);
					loc.add(0, 1, 0);
					for (int q = 0; q < 10; q++){
						loc.getWorld().playEffect(loc, Effect.SMOKE, 31, 1000);
					}
					loc.getWorld().playEffect(loc, Effect.EXTINGUISH, 10, 1000);

				}
			}
			Location smokeLoc = player.getLocation();
			for (int i = -10; i < 10; i++){
				for (int q = -5; q < 5; q++){
					smokeLoc.add(1, q,0);
				//	smokeLoc.getWorld().playEffect(smokeLoc, Effect.SMOKE, 31, 1000);
				//	smokeLoc.getWorld().playEffect(smokeLoc, Effect.EXTINGUISH, 10, 1000);

					smokeLoc = player.getLocation();
					
				}
			}
			
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new NetRunnables(blockLocs), 200L);

		} else {
			player.sendMessage("Could not cast! Spell requires 10 string.");
		} // They don't have the proper items.

	}
}
