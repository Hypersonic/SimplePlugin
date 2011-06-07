package aor.SimplePlugin.Spells;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import aor.SimplePlugin.SimplePlugin;
import aor.SimplePlugin.Spell;

public class SpikeSpell extends Spell {
	public SpikeSpell(SimplePlugin instance) // Constructor.
	{
		plugin = instance;
		spellName = "Spikes";
		spellDescription = "Summons a cactus on command. Needs 4 cacti, 1 sand.";
		shortName = "Spikes";
		
		setRequiredItems(new ItemStack(Material.CACTUS, 4), new ItemStack(Material.SAND, 1)); // 1 cactus, 1 sandblock.
	}

	public void castSpell(Player player)
	{
		if (checkInventoryRequirements(player.getInventory())) // They have the required items.
		{
			removeRequiredItemsFromInventory(player.getInventory());
			
			
			
			player.sendMessage("SPIKES SPIKES SPIKES BABY");
		
		}
		
		else
		{
			
			player.sendMessage("Could not cast! Requires 4 cacti and 1 sand.");
			
		}
		
		/*
		Block targetBlock = player.getTargetBlock(null, 30); // Select the target block.
		if (targetBlock.getType() != Material.AIR) // No placing bedrock midair!
		{
			
			Location loc = targetBlock.getLocation();
			(player.getWorld().getBlockAt(loc)).setType(Material.SAND);

			for (int i = 0; i < 3;i++)
			{
				loc.setY(loc.getY()+1);
				(player.getWorld().getBlockAt(loc)).setType(Material.CACTUS);
			}
			player.getWorld().getBlockAt(loc);
			
		}
	*/	
	}

}
