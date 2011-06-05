package aor.SimplePlugin.Spells;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Slot;
import org.bukkit.Material;
import aor.SimplePlugin.Spell;



public class FlameArrowSpell extends Spell {
	
	private static final int MAXDISTANCE = 200; // Sets the maximum distance.


	public FlameArrowSpell() // Constructor.
	{
		spellName = "Flame Arrow";
//		spellDescription = "Shoots an arrow that sets stuff ON FIRE! Requires flint and steel and arrow.";
	}
	
/*	public void damageFlintAndSteel(int amount, PlayerInventory inventory)
	{
		ItemStack flintandsteel = inventory.getItem(inventory.first(Material.FLINT_AND_STEEL));
		flintandsteel.setDurability((short) (flintandsteel.getDurability() - amount)); // This doesn't function. Set the DAMAGE, not durability.
	}
*/
	
	public boolean checkRequirements(PlayerInventory inventory) // Check inventory function. I understand that this is not optimal but it is in keeping with the superclass.
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
			player.sendMessage("This would send a flame arrow, but Herbie didn't code it."); // They have the proper items.
		}
		else
		{
			player.sendMessage("Could not cast! This spell requires a flint and steel and an arrow!"); // They don't.
		}
		
	}
	
	
}
