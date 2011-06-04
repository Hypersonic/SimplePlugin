package aor.SimplePlugin;

import java.util.HashMap;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Location;
import org.bukkit.World;
import aor.SimplePlugin.Spell;

public class SPPlayerListener extends PlayerListener {
	public static SimplePlugin plugin;

	public SPPlayerListener(SimplePlugin instance) {
		plugin = instance;
	}

	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer(); // Set the player object.
		
		SpellBook playerBook = new SpellBook();
		
		SimplePlugin.playerBooks.put(player.getName(), playerBook); // Add to the hashmap.
		
		Spell sp = new Spell();
		
		SimplePlugin.playerBooks.get(player.getName()).registerSpell(sp);
		
//		player.getServer().broadcastMessage("Ew! You're hand's wet!");
		player.sendMessage(SimplePlugin.playerBooks.get(player.getName()).returnFirstEntry().returnHello());
		
		
	}
	
	public void onPlayerInteract(PlayerInteractEvent event) {

		Player player = event.getPlayer(); // Set the player object.
		

		
		
		// Right clicking air or a block event:
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK && player.getItemInHand().getType() == Material.GOLD_HOE) // If they right clicked with the gold hoe...
		{

			Block targetBlock = player.getTargetBlock(null, 100); // Set the targetBlock object. CHANGE THE MAX DISTANCE HERE.
			player.getWorld().strikeLightningEffect(targetBlock.getLocation()); // Strike lightning at targetBlock location.


			if (targetBlock.getType() != Material.AIR) // If they're not aiming at air...
			{
				targetBlock.setType(Material.BEDROCK); // Change the target block to obsidian.
			}

		}

	}

}