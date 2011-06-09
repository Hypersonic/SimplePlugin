package aor.SimplePlugin.Spells;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import aor.SimplePlugin.SimplePlugin;
import aor.SimplePlugin.Spell;
import org.bukkit.block.Block;
import org.bukkit.Material;
//import org.bukkit.craftbukkit.CraftWorld;


public class ExplosionSpell extends Spell {

	private static final int MAXDISTANCE = 200; // Sets the maximum distance.


	public ExplosionSpell(SimplePlugin instance) // Constructor.
	{
		plugin = instance;
		spellName = "Explosion";
		spellDescription = "Causes an explosion at your target location.";
		shortName = "Explosion";
		ArrayList<ItemStack> requiredItems=new ArrayList<ItemStack>();
		requiredItems.add(new ItemStack(Material.ARROW, 2));
		requiredItems.add(new ItemStack(Material.TNT, 1));
		setRequiredItems(requiredItems);
	}

	public void castSpell(Player player)
	{
		
		PlayerInventory inventory = player.getInventory();

		if (checkInventoryRequirements(inventory))
		{
			 // Remove the items.

			
			Block targetBlock = player.getTargetBlock(null, MAXDISTANCE); // Select the target block.
			
			if (targetBlock.getType() != Material.AIR) // No explosions midair!
			{
				removeRequiredItemsFromInventory(inventory);
				createExplosion(targetBlock, 5);
			}
			else{
				player.sendMessage("Could not cast! Invalid block type!");
			}
		}
		else { player.sendMessage("Could not cast! Spell requires 2 arrows, 1 TNT!"); } // They don't have the proper items.

	}

	public void createExplosion(Block targetBlock, int size)
	{
		//((CraftWorld)targetBlock.getWorld()).getHandle().createExplosion(null, targetBlock.getLocation().getX(), targetBlock.getLocation().getY(), targetBlock.getLocation().getZ(), size, false);
	}


}
