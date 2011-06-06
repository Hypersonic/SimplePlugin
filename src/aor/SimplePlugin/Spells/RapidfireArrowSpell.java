package aor.SimplePlugin.Spells;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;

import aor.SimplePlugin.SimplePlugin;
import aor.SimplePlugin.Spell;



public class RapidfireArrowSpell extends Spell {
	
	
	public static SimplePlugin plugin;
	
	private static final int MAXDISTANCE = 200; // Sets the maximum distance.


	public RapidfireArrowSpell() // Constructor.
	{
		spellName = "Rapidfire Arrow";
		spellDescription = "Quickly fires off three arrows. Needs three redstone.";
	}
	
	
	public void castSpell(Player player)
	{
		PlayerInventory inventory = player.getInventory();
		
		// REQUIRED ITEMS
		ItemStack[] requiredItems = new ItemStack[2]; // The requireditems itemstack.
		requiredItems[0] = new ItemStack(Material.ARROW, 3); // We need 3 arrows.
		requiredItems[1] = new ItemStack(Material.REDSTONE, 2); // We need 2 redstone.
		// REQUIRED ITEMS
		
		if (checkInventoryRequirements(inventory, requiredItems))
		{
			removeRequiredItemsFromInventory(inventory, requiredItems); // Remove the items.
			
			player.shootArrow();
			player.shootArrow();
			player.shootArrow();

			
			player.sendMessage("Rapidfire!"); // They have the proper items.
		
		}
		
		
		else { player.sendMessage("Could not cast! Spell requires 2 redstone, 3 arrow!"); } // They don't have the proper items.
		
	}
	
	
}
