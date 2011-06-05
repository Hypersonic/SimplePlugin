package aor.SimplePlugin.Spells;

import org.bukkit.entity.Player;
import aor.SimplePlugin.Spell;
import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;


public class BedrockLightningSpell extends Spell {
	
	private static final int MAXDISTANCE = 200; // Sets the maximum distance.


	public BedrockLightningSpell() // Constructor.
	{
		spellName = "Bedrock Lightning";
	}
	
	public void castSpell(Player player)
	{
		Block targetBlock = player.getTargetBlock(null, MAXDISTANCE); // Select the target block.
		if (targetBlock.getType() != Material.AIR) // No placing bedrock midair!
		{
			player.getworld().spawnCreature(targetBlock.getLocation(),CreatureType.CREEPER);
			player.getworld().spawnCreature(targetBlock.getLocation(),CreatureType.GHAST);
			player.getWorld().strikeLightning(targetBlock.getLocation()); // And strike lightning!
		}
	}
}
