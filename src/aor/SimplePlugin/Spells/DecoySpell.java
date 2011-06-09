package aor.SimplePlugin.Spells;

import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Creature;

import aor.SimplePlugin.SimplePlugin;
import aor.SimplePlugin.Spell;


public class DecoySpell extends Spell {
	
	
	public static SimplePlugin plugin;
	int MAXDISTANCE = 50;
	public DecoySpell(SimplePlugin instance) // Constructor.
	{
		plugin = instance;
		spellName = "Decoy";
		spellDescription = "Spawns a cow, and causes all mobs within a 5 block radius to attack it.";
		
		setRequiredItems(new ItemStack(Material.WATER_BUCKET, 1), new ItemStack(Material.REDSTONE, 4)); // We need 1 bucket of water and 4 redstone.
	}
	
	
	public void castSpell (Player player)
	{
		PlayerInventory inventory = player.getInventory();

		if (checkInventoryRequirements(inventory))
		{
			
			Block targetBlock = player.getTargetBlock(null, MAXDISTANCE); // Select the target block.
			
			if (targetBlock.getType() != Material.AIR) // No cows midair!
			{
				LivingEntity cow = player.getWorld().spawnCreature(targetBlock.getLocation(), CreatureType.COW);
				List<Entity> nearCow = cow.getNearbyEntities(10, 10, 10);
				for (int i = 0; i < nearCow.size();i++){
					Creature currentCreature = (Creature) nearCow.get(i);
					currentCreature.setTarget(cow);
				}
			}

			
			
		} else {
			player.sendMessage("Could not cast! Spell requires 1 water bucket and 4 redstone.");
			} // They don't have the proper items.
		
	}
}
