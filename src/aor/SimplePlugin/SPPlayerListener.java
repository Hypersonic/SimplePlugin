package aor.SimplePlugin;


import java.util.HashSet;


import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Location;
import org.bukkit.World;

/* Example Template
 * By Adamki11s
 * HUGE Plugin Tutorial
 */

public class SPPlayerListener extends PlayerListener {
	public static SimplePlugin plugin;
	
	public SPPlayerListener(SimplePlugin instance) {
		plugin = instance;
	}
	
	/*public boolean clickedWithHoe(PlayerInteractEvent event) { // The function clickedWithHoe.
		return event.getPlayer().getItemInHand().getType() == Material.GOLD_HOE;
	}*/
	
	
	

	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			/// Blah blah blah
			//Player player = event.getPlayer();
			//player.sendMessage("You just right clicked something! Congratz!");
			if (event.getPlayer().getItemInHand().getType() == Material.GOLD_HOE && event.getPlayer().getTargetBlock(null, 200).getType() != Material.AIR) {
				event.getPlayer().getTargetBlock(null, 200).setType(Material.BEDROCK); // Set the material to bedrock 'cause they got a GOLD HOE!
		
				World world = event.getPlayer().getWorld();
				world.strikeLightningEffect(event.getPlayer().getTargetBlock(null, 200).getLocation());
				
			}
			
			
		}
	}
	
/*	public void onPlayerMove(PlayerMoveEvent event){
		
		Player player = event.getPlayer();
		Location playerLoc = player.getLocation();
		
		player.sendMessage("Your X Coordinates : " + playerLoc.getX());
		player.sendMessage("Your Y Coordinates : " + playerLoc.getY());
		player.sendMessage("Your Z Coordinates : " + playerLoc.getZ());
	}
	*/

}