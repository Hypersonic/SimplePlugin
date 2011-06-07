package aor.SimplePlugin.Spells;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;

import aor.SimplePlugin.SimplePlugin;
import aor.SimplePlugin.Spell;
import aor.SimplePlugin.Runnables.RunnableBuildCactus;
import aor.SimplePlugin.Runnables.RunnableDestroyCactus;

public class SpikeWallSpell extends Spell {
	
	public SpikeWallSpell(SimplePlugin instance) // Constructor.
	{
		plugin = instance;
		spellName = "Spike Wall";
		spellDescription = "Summons a wall of cacti on command.  Needs 20 cacti, 6 sand, 3 sandstone.";
		shortName = "SpikeWall";

		setRequiredItems(new ItemStack(Material.CACTUS, 20), new ItemStack(Material.SAND, 6), new ItemStack(Material.SANDSTONE, 3)); // 20 cactus, 6 sandblock, 3 sandstone.
	}
	
	public double distanceBetween(Location locA, Location locB)
	{
		// Distance formula.
		double xdiff = locA.getX() - locB.getX();
		double ydiff = locA.getZ() - locB.getZ();
		double xdiffsq = xdiff * xdiff;
		double ydiffsq = ydiff * ydiff;
		double xyadd = xdiffsq + ydiffsq;
		return Math.sqrt(xyadd);
		// Distance formula.
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
	
	public void castSpell(Player player)
	{
		if (checkInventoryRequirements(player.getInventory()))
		{
			// Cast the spell
		}
		
		else { player.sendMessage("Could not cast! Requires 20 cacti, 6 sand, 3 sandstone."); } // They don't have the required items.
	}
	
}
