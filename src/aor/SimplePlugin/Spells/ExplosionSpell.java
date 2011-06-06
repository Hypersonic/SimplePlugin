package aor.SimplePlugin.Spells;

import org.bukkit.entity.Player;
import aor.SimplePlugin.Spell;
import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.craftbukkit.CraftWorld;


public class ExplosionSpell extends Spell {
	
	private static final int MAXDISTANCE = 200; // Sets the maximum distance.


	public ExplosionSpell() // Constructor.
	{
		spellName = "Explosion";
		spellDescription = "Causes an explosion at your target location.";
	}
	
	
	public void castSpell(Player player)
	{
		Block targetBlock = player.getTargetBlock(null, MAXDISTANCE); // Select the target block.
		if (targetBlock.getType() != Material.AIR) // No placing bedrock midair!
		{
			createExplosion(targetBlock, 5);
			
		}
		
	}
	
	public void createExplosion(Block targetBlock, int size)
	{
		((CraftWorld)targetBlock.getWorld()).getHandle().createExplosion(null, targetBlock.getLocation().getX(), targetBlock.getLocation().getY(), targetBlock.getLocation().getZ(), size, false);
	}
	
	
}
