package src.aor.SimplePlugin.Spells;

import org.bukkit.entity.Player;
import aor.SimplePlugin.Spell;
import org.bukkit.block.Block;
import org.bukkit.Location;
import org.bukkit.Material;


public class FireballSpell extends Spell {
	
	private static final int MAXDISTANCE = 100; // Sets the maximum distance.


	public FireballSpell() // Constructor.
	{
		spellName = "Fireball";
	}
	
	
	public void castSpell(Player player)
	{
		Block targetBlock = player.getTargetBlock(null, MAXDISTANCE); // Select the target block.
		if (targetBlock.getType() != Material.AIR){ // No placing bedrock midair!
			Entity myfireball = newentity.Fireball();
			player.getWorld().createEntity(targetBlock.getLocation(),entity.Fireball); // Spawn a fireball..?
		} else {
			player.sendMessage("Invalid Target!");
		}
	