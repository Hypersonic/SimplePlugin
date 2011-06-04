package aor.SimplePlugin;

import java.util.HashSet;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Location;
import org.bukkit.World;

public class SPPlayerListener extends PlayerListener {
	public static SimplePlugin plugin;

	public SPPlayerListener(SimplePlugin instance) {
		plugin = instance;
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