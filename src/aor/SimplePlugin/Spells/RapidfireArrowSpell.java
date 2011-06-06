package aor.SimplePlugin.Spells;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import aor.SimplePlugin.RunnableShootArrow;

import aor.SimplePlugin.SimplePlugin;
import aor.SimplePlugin.Spell;



public class RapidfireArrowSpell extends Spell {


	public static SimplePlugin plugin;


	public RapidfireArrowSpell(SimplePlugin instance) // Constructor.
	{
		plugin = instance;
		spellName = "Rapidfire Arrow";
		spellDescription = "Quickly fires off eight arrows. Needs four redstone.";
		
		setRequiredItems(new ItemStack(Material.ARROW, 8), new ItemStack(Material.REDSTONE, 4)); // We need 8 arrows and 4 redstone.
	}


	public void castSpell(Player player)
	{
		PlayerInventory inventory = player.getInventory();

		if (checkInventoryRequirements(inventory))
		{
			removeFromInventory(inventory, requiredItems.get(1)); // Remove the redstone.
			player.shootArrow(); // Shoot an arrow.
			removeFromInventory(inventory, new ItemStack(Material.ARROW, 1)); // Remove an arrow. Will remove the rest in RunnableShootArrow.
			
			for (int i = 2; i < 15; i = i + 2) // Do this 7 times.
			{
				player.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new RunnableShootArrow(player), i);
			}

			player.sendMessage("Rapidfire!"); // They have the proper items. TODO: Replace with a noise.

		}


		else { player.sendMessage("Could not cast! Spell requires 4 redstone, 8 arrow!"); } // They don't have the proper items.

	}


}
