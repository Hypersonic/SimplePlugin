package aor.Spells.Runnables;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import aor.Spells.Runnables.RunnableBuildCactus;
import aor.Spells.Runnables.RunnableDestroyCactus;
import aor.Spells.Spells;

public class RunnableBuildFortCactus implements Runnable {

	public Block targetBlock;
	public Player player;
	public Spells plugin;

	public RunnableBuildFortCactus (Block i_targetBlock, Player i_player, Spells instance)
	{
		targetBlock = i_targetBlock;
		player = i_player;
		plugin = instance;
	}

	public void run()
	{
		if (canPlaceCactus(targetBlock)) // If the space is compatible with a cactus
		{
			Material originalTargetMaterial = targetBlock.getType();
			boolean sandstoneSupport = false;
			
			if (targetBlock.getRelative(0, -1, 0).getType() == Material.AIR) // if said cactus would fall apart
			{
				targetBlock.getRelative(0, -1, 0).setType(Material.SANDSTONE); // Place a sandstone support
				removeFromInventory(player.getInventory(), new ItemStack(Material.SANDSTONE, 1)); // Only charge for sandstone if they needed it.
				sandstoneSupport = true; // Set the sandstonesupport variable.
			}
			
			targetBlock.setType(Material.SAND); // Set the target block to sand.
			
			int b = 0; // The first event happens immediately.
			
			for (int i = 1; i <= 3; i++) // For each space above it
			{
				
				player.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new RunnableBuildCactus(targetBlock.getRelative(0, i, 0)), b);
				
				b = b + 1; // The cacti are built once every 0.1 seconds (2 server ticks).
			}
			
			player.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new RunnableDestroyCactus(targetBlock, originalTargetMaterial, sandstoneSupport), 400); // We will destroy cactus in 20 seconds.
			
			
			removeFromInventory(player.getInventory(), new ItemStack(Material.CACTUS, 3)); // Take out the needed items.
			removeFromInventory(player.getInventory(), new ItemStack(Material.SAND, 1));
			
		}
		else { } // Just don't place a cactus there.
	}
	
	public boolean canPlaceCactus(Block targetBlock) // Identical to SpikeSpell.java's.
	{
		if (targetBlock.getType() == Material.CACTUS)
		{
			return false; // Cannot spawn cactus on cactus.
		}

		if (targetBlock.getType() == Material.BEDROCK)
		{
			return false; // Cannot spawn cactus on bedrock.
		}

		for (int i = 1; i <= 3; i++) // For each space above the block...
		{
			if (targetBlock.getRelative(0, i, 0).getType() == Material.AIR) { } // If it's air do nothing
			else { return false; } // Otherwise you can't place a cactus.
		}

		for (int i = 1; i <= 3; i++) // For each space left of the block...
		{
			if (targetBlock.getRelative(1, i, 0).getType() == Material.AIR) { } // If it's air do nothing
			else { return false; } // Otherwise you can't place a cactus.
		}

		for (int i = 1; i <= 3; i++) // For each space right of the block...
		{
			if (targetBlock.getRelative(-1, i, 0).getType() == Material.AIR) { } // If it's air do nothing
			else { return false; } // Otherwise you can't place a cactus.
		}

		for (int i = 1; i <= 3; i++) // For each space in front of the block...
		{
			if (targetBlock.getRelative(0, i, 1).getType() == Material.AIR) { } // If it's air do nothing
			else { return false; } // Otherwise you can't place a cactus.
		}

		for (int i = 1; i <= 3; i++) // For each space behind the block...
		{
			if (targetBlock.getRelative(0, i, -1).getType() == Material.AIR) { } // If it's air do nothing
			else { return false; } // Otherwise you can't place a cactus.
		}

		return true; // If nothing turned up.
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
