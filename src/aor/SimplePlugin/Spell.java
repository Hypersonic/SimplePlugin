// A generic spell class.

package aor.SimplePlugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.Inventory;
import java.util.ArrayList;

public class Spell {
	
	public static SimplePlugin plugin;
	
	public Spell() { } // Empty constructor.

	public String spellName;
	public String getName() { return spellName; }

	public String spellDescription;
	public String getDescription() { return spellDescription; }
	
	public String shortName;
	public String getShortName() { return shortName; }


	public String returnHello()
	{
		return "The spell is working!";
	}

	public ArrayList<ItemStack[]> requiredItems = new ArrayList<ItemStack[]>(); // The required items arraylist of arrays.
	
	public void setRequiredItems(ArrayList<ItemStack[]> items)
	{
		for (int i = 0; i < items.size()/2; i++) {
			requiredItems.add(items.get(i));
		}
	}
	
	public boolean checkInventoryRequirements(PlayerInventory inventory) // Checks if player has the proper requirements for the spell.
	{
		for (int i = 0; i < requiredItems.size(); i++) // The loop for the requiredItems arraylist.
		{
			if (!inventory.contains(new ItemStack(requiredItems.get(i)[0].getType()), requiredItems.get(i)[0].getAmount())) {
				return false;
			}  // If it doesn't return false.
		}
		return true; // If all conditions were met.
	}
	
	public boolean removeRequiredItemsFromInventory(PlayerInventory inventory)
	{
		if(checkInventoryRequirements(inventory)){
			for (int i = 0; i < requiredItems.size(); i++) // The loop for the requiredItems arraylist.
			{
				if(requiredItems.get(0)[1].getType()==Material.AIR){
					inventory.remove(requiredItems.get(0)[0]);
				}
				else{
					for(int amountRemaining=requiredItems.get(i)[0].getAmount();amountRemaining>0;){
						if(inventory.getItem(inventory.first(requiredItems.get(i)[0])).getAmount()>=requiredItems.get(i)[0].getAmount()){
							inventory.getItem(inventory.first(requiredItems.get(i)[0])).setAmount(inventory.getItem(inventory.first(requiredItems.get(i)[0])).getAmount()-amountRemaining);
							amountRemaining=0;
						}
						else if(inventory.getItem(inventory.first(requiredItems.get(i)[0])).getAmount()<requiredItems.get(i)[0].getAmount()){
							amountRemaining-=inventory.getItem(inventory.first(requiredItems.get(i)[0])).getAmount();
							inventory.remove(inventory.first(requiredItems.get(i)[0]));
						}
						inventory.setItem(inventory.first(requiredItems.get(i)[0]), requiredItems.get(i)[1]);// Remove the items.
					}
				}
			}
			return true;
		}
		return false;
	}
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
	
	//There is already a built in bukkit function that does this! inventory.remove(ItemStack);
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
