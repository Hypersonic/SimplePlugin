package aor.Spells.Spells;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

import aor.Spells.Runnables.RunnableShootArrow;
import aor.Spells.SpellsMain;
import aor.Spells.Spell;



public class RapidfireSpell extends Spell {


	public static SpellsMain plugin;


	public RapidfireSpell(SpellsMain instance) // Constructor.
	{
		plugin = instance;
		spellName = "Rapidfire";
		spellDescription = "Quickly fires off eight arrows. Needs four redstone.";
		shortName = "Rapidfire";
		ArrayList<ItemStack> requiredItems=new ArrayList<ItemStack>(0);
		requiredItems.add(new ItemStack(Material.ARROW, 8));
		requiredItems.add(new ItemStack(Material.REDSTONE, 4));
		setRequiredItems(requiredItems); // We need 8 arrows and 4 redstone.
	}

	public void castSpell(Player player)
	{
		PlayerInventory inventory = player.getInventory();

		if (checkInventoryRequirements(inventory))
		{
			removeRequiredItemFromInventory(inventory, 1); // Remove the redstone.
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