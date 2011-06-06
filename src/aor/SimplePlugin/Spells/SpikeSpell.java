package aor.SimplePlugin.Spells;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import aor.SimplePlugin.SimplePlugin;
import aor.SimplePlugin.Spell;

public class SpikeSpell extends Spell {
	public SpikeSpell(SimplePlugin instance) // Constructor.
	{
		plugin = instance;
		spellName = "Spikes";
		spellDescription = "Summons a six block wide cactus wall where you point.";
	}

	public void castSpell(Player player)
	{
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
		
	}

}
