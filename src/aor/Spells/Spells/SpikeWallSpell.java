package aor.Spells.Spells;


import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;

import aor.Spells.Runnables.RunnableBuildWallCactus;
import aor.Spells.Spells;
import aor.Spells.Spell;

public class SpikeWallSpell extends Spell {

	public SpikeWallSpell(Spells instance) // Constructor.
	{
		plugin = instance;
		spellName = "Spike Wall";
		spellDescription = "Summons a wall of cacti on command.  Needs 35 cacti, 9 sand, 8 sandstone.";
		shortName = "SpikeWall";
		ArrayList<ItemStack> requiredItems=new ArrayList<ItemStack>();
		requiredItems.add(new ItemStack(Material.CACTUS, 35));
		requiredItems.add(new ItemStack(Material.SAND, 9));
		requiredItems.add(new ItemStack(Material.SANDSTONE, 8));
		setRequiredItems(requiredItems);
	}
	
	public Block[] blockSquare(Location center)
	{
		Block[] blocks = new Block[8];

		World world = center.getWorld();

		blocks[1] = world.getBlockAt(center.getBlockX(), center.getBlockY(), center.getBlockZ() + 2);
		blocks[2] = world.getBlockAt(blocks[1].getLocation().getBlockX() + 2, blocks[1].getLocation().getBlockY(), blocks[1].getLocation().getBlockZ());
		blocks[3] = world.getBlockAt(blocks[1].getLocation().getBlockX() - 2, blocks[1].getLocation().getBlockY(), blocks[1].getLocation().getBlockZ());
		blocks[4] = world.getBlockAt(center.getBlockX() + 2, center.getBlockY(), center.getBlockZ());
		blocks[5] = world.getBlockAt(blocks[4].getLocation().getBlockX(), blocks[4].getLocation().getBlockY(), blocks[4].getLocation().getBlockZ() - 2);
		blocks[0] = world.getBlockAt(center.getBlockX(), center.getBlockY(), center.getBlockZ() - 2);
		blocks[6] = world.getBlockAt(blocks[0].getLocation().getBlockX() - 2, blocks[0].getLocation().getBlockY(), blocks[0].getLocation().getBlockZ());
		blocks[7] = world.getBlockAt(center.getBlockX() - 2, center.getBlockY(), center.getBlockZ());

		return blocks;

	}



	public void castSpell(Player player)
	{
		if (checkInventoryRequirements(player.getInventory()))
		{
			
			removeFromInventory(player.getInventory(), new ItemStack(Material.SAND, 1)); // Take out the extra items.
			removeFromInventory(player.getInventory(), new ItemStack(Material.CACTUS, 3)); // Take out the extra items.
			
			Block[] blocks = blockSquare(new Location(player.getWorld(), player.getLocation().getBlockX(), player.getLocation().getBlockY() - 1, player.getLocation().getBlockZ())); // Get the block square.

			int b = 0; // The first cactus goes up immediately.

			for (int i = 0; i < blocks.length; i++)
			{
				player.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new RunnableBuildWallCactus(blocks[i], player, plugin), b);
				b = b + 2; // Once every 0.1 seconds.
			}
		}

		else { player.sendMessage("Could not cast! Requires 35 cacti, 9 sand, 8 sandstone."); } // They don't have the required items.
	}
	
	

}
