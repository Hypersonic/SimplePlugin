package aor.SimplePlugin.Spells;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import aor.SimplePlugin.Spell;



public class RapidfireArrowSpell extends Spell {
	
	private static final int MAXDISTANCE = 200; // Sets the maximum distance.


	public RapidfireArrowSpell() // Constructor.
	{
		spellName = "Rapidfire Arrow";
		spellDescription = "Quickly fires off three arrows. Needs three redstone.";
	}
	
	public boolean checkRequirements(PlayerInventory inventory) // TODO: Move this to the superclass entirely.
	{	
		if (inventory.contains(Material.FLINT_AND_STEEL) && inventory.contains(Material.ARROW))
		{ return true; } // They have the proper items.
		else
		{ return false; } // They don't.
	}
	
	public void castSpell(Player player)
	{
		PlayerInventory inventory = player.getInventory();
		
		if (checkRequirements(inventory)) // The reason we don't put it here is because there may be more than just inventory requirements in the future.
		{
			
			damageItem(Material.FLINT_AND_STEEL, 2, inventory);
			ItemStack arrowStack = new ItemStack(Material.ARROW, 2);
			removeFromInventory(inventory,arrowStack);
			
			Arrow arrow = player.shootArrow();
			
			
			
			
			
			player.sendMessage("This would send a flame arrow, but Herbie didn't code it."); // They have the proper items.
		
		}
		
		
		else { player.sendMessage("Could not cast! This spell needs flint and steel and an arrow!"); } // They don't have the proper items.
		
	}
	
	
}
