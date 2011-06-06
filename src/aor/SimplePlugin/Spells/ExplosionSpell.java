package aor.SimplePlugin.Spells;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import aor.SimplePlugin.SimplePlugin;
import aor.SimplePlugin.Spell;
import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.craftbukkit.CraftWorld;


public class ExplosionSpell extends Spell {

	private static final int MAXDISTANCE = 200; // Sets the maximum distance.


	public ExplosionSpell(SimplePlugin instance) // Constructor.
	{
		plugin = instance;
		spellName = "Explosion";
		spellDescription = "Causes an explosion at your target location.";
	}


	public void castSpell(Player player)
	{
		
		PlayerInventory inventory = player.getInventory();

		// REQUIRED ITEMS
		ItemStack[] requiredItems = new ItemStack[2]; // The requireditems itemstack.
		requiredItems[0] = new ItemStack(Material.ARROW, 2); // We need 2 arrows.
		requiredItems[1] = new ItemStack(Material.TNT, 1); // We need 1 TNT.
		// REQUIRED ITEMS

		if (checkInventoryRequirements(inventory, requiredItems))
		{
			removeRequiredItemsFromInventory(inventory, requiredItems); // Remove the items.

			
			Block targetBlock = player.getTargetBlock(null, MAXDISTANCE); // Select the target block.
			
			if (targetBlock.getType() != Material.AIR) // No explosions midair!
			{
				createExplosion(targetBlock, 5);
			}
		}
		
		else { player.sendMessage("Could not cast! Spell requires 2 arrows, 1 TNT!"); } // They don't have the proper items.

	}

	public void createExplosion(Block targetBlock, int size)
	{
		((CraftWorld)targetBlock.getWorld()).getHandle().createExplosion(null, targetBlock.getLocation().getX(), targetBlock.getLocation().getY(), targetBlock.getLocation().getZ(), size, false);
	}


}
