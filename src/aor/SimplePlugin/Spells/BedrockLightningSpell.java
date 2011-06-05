package aor.SimplePlugin.Spells;

import org.bukkit.entity.Player;
import aor.SimplePlugin.Spell;
import org.bukkit.block.Block;
import org.bukkit.Material;


public class BedrockLightningSpell extends Spell {
	
	private static final int MAXDISTANCE = 200; // Sets the maximum distance.


	public BedrockLightningSpell() // Constructor.
	{
		spellName = "Bedrock Lightning";
		spellDescription = "Strikes lightning on a block, changing it to bedrock.";
	}
	
	
	public void castSpell(Player player)
	{
		Block targetBlock = player.getTargetBlock(null, MAXDISTANCE); // Select the target block.
		if (targetBlock.getType() != Material.AIR) // No placing bedrock midair!
		{
			targetBlock.setType(Material.BEDROCK); // Turn it to bedrock!
			player.getWorld().strikeLightningEffect(targetBlock.getLocation()); // And strike lightning (fake)!
			
		}
		
	}
	
	
}
