// A generic spell class.

package aor.SimplePlugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Spell {
	
	public Spell() {} // Empty constructor.
	
	public String spellName;
	public String getName() { return spellName; }
	
	public String spellDescription;
	public String getDescription() { return spellDescription; }
	
	
	public String returnHello()
	{
		return "The spell is working!";
	}
	
	public boolean checkRequirements(Player player) { return true; } // Checks if player has the proper requirements for the spell.
	

	public void castSpell(Player player)
	{
		player.sendMessage("You're trying to cast a spell that's not set!");
	}
	
	
	public void damageItem(Material material, int amount, PlayerInventory inventory) // Damages an item in the inventory. Removes it if it's all used up.
	{ 
		ItemStack item = inventory.getItem(inventory.first(material));
		item.setDurability((short)(item.getDurability() + amount)); // Set durability + amount.
		
		if (item.getDurability() >= material.getMaxDurability())
		{ inventory.removeItem(item); } // It's used up.
	}
	
}
