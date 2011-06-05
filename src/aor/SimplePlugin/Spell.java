// A generic spell class.

package aor.SimplePlugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.Inventory;

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

	public void removeFromInventory(Inventory inventory, ItemStack item) { // Removes an itemstack from the inventory. Use this for quantities of items. Based on code by nisovin.
		int amt = item.getAmount();
		ItemStack[] items = inventory.getContents();
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null && items[i].getType() == item.getType() && items[i].getDurability() == item.getDurability()) {
				if (items[i].getAmount() > amt) {
					items[i].setAmount(items[i].getAmount() - amt);
					break;
				} else if (items[i].getAmount() == amt) {
					items[i] = null;
					break;
				} else {
					amt -= items[i].getAmount();
					items[i] = null;
				}
			}
		}
		inventory.setContents(items);
	}


}
