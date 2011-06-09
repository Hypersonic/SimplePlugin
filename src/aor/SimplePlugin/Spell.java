// A generic spell class.

package aor.SimplePlugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import java.util.ArrayList;

public class Spell implements Runnable{
	
	public static SimplePlugin plugin;
	
	public Spell() { } // Empty constructor.

	public String spellName;
	public String getName() { return spellName; }

	public String spellDescription;
	public String getDescription() { return spellDescription; }
	
	public String shortName;
	public String getShortName() { return shortName; }

	public ArrayList<ItemStack> requiredItems = new ArrayList<ItemStack>(); // The required items arraylist of arrays.
	
	public void setRequiredItems(ArrayList<ItemStack> items)
	{
		for (int i = 0; i < items.size()/2; i++) {
			requiredItems.add(items.get(i));
		}
	}
	public void run(){
		
	}
	public void delayedRun(int time){
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin,this, (long)time);
	}
	public boolean checkInventoryRequirements(PlayerInventory inventory) // Checks if player has the proper requirements for the spell.
	{
		for (int i = 0; i < requiredItems.size(); i++) // The loop for the requiredItems arraylist.
		{
			if (!inventory.contains(requiredItems.get(i).getType(), requiredItems.get(i).getAmount())) {
				return false;
			}  // If it doesn't return false.
		}
		return true; // If all conditions were met.
	}
	public boolean removeRequiredItemFromInventory(PlayerInventory inventory,int index){
		if(requiredItems.size()>index){
				return removeFromInventory(inventory,requiredItems.get(index))!=-1;
		}
		return false;
	}
	public boolean removeRequiredItemsFromInventory(PlayerInventory inventory)
	{
		if(checkInventoryRequirements(inventory)){
			for (int i = 0; i < requiredItems.size(); i++) // The loop for the requiredItems arraylist.
			{
				removeFromInventory(inventory,requiredItems.get(0));
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
	public void replaceInInventory(PlayerInventory inventory, ItemStack itemToRemove, ItemStack itemToReplaceWith){
		addItemToIndex(inventory,itemToReplaceWith,removeFromInventory(inventory,itemToRemove));
	}
	public boolean addItemSafely(PlayerInventory inventory, ItemStack item){
		if(inventory.firstEmpty()!=-1){
			addItemToIndex(inventory,item,inventory.firstEmpty());
			return true;
		}
		return false;
	}
	public void addItemToIndex(PlayerInventory inventory, ItemStack item,int index){
		inventory.setItem(index, item);
	}
	public int removeFromInventory(PlayerInventory inventory, ItemStack item) { // Removes an itemstack from the inventory. Use this for quantities of items.
		int amountLeft=item.getAmount();
		while(amountLeft>0){
			int firstFound=inventory.first(item.getType());
			if(inventory.getItem(firstFound).getAmount()>=amountLeft){
				inventory.getItem(firstFound).setAmount(inventory.getItem(firstFound).getAmount()-amountLeft);
				amountLeft=0;
				return firstFound;
			}
			else{
				amountLeft-=inventory.getItem(inventory.first(item.getType())).getAmount();
				inventory.clear(inventory.first(item.getType()));
			}
		}
		return -1;
	}
}
