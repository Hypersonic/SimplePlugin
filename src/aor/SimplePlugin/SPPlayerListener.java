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

/* Example Template
 * By Adamki11s
 * HUGE Plugin Tutorial
 */
public class SPPlayerListener extends PlayerListener {
    public static SimplePlugin plugin;
    public static Map<Player, int> currentSpell = new HashMap<Player, int>();
    public SPPlayerListener(SimplePlugin instance) {
        plugin = instance;
    }
    /*public boolean clickedWithHoe(PlayerInteractEvent event) { // The function clickedWithHoe.
        return event.getPlayer().getItemInHand().getType() == Material.GOLD_HOE;
    }*/
    public void onPlayerInteract(PlayerInteractEvent event) {
        /// Blah blah blah
        Player player = event.getPlayer();
        //player.sendMessage("You just right clicked something! Congratz!");
    	if(!currentSpell.containsKey(player){
               currentSpell.put(player,0);
         }
    	//Right clicking with golden hoe
        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)&&player.getItemInHand().getType() == Material.GOLD_HOE && player.getTargetBlock(null, 256).getType() != Material.AIR) {
			player.getTargetBlock(null, 256).setType(Material.BEDROCK); // Set the material to bedrock 'cause they got a GOLD HOE!
			player.getWorld().strikeLightningEffect(event.getPlayer().getTargetBlock(null, 256).getLocation());
        }
        
        //Left clicking with golden hoe
        if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK)&&player.getItemInHand().getType() == Material.GOLD_HOE && player.getTargetBlock(null, 256).getType() != Material.AIR){
        	player.sendMessage("DaDadadaaaaaaa!");
        }
    }
    
/*  public void onPlayerMove(PlayerMoveEvent event){
        
        Player player = event.getPlayer();
		Location playerLoc = player.getLocation();
		
		player.sendMessage("Your X Coordinates : " + playerLoc.getX());
		player.sendMessage("Your Y Coordinates : " + playerLoc.getY());
		player.sendMessage("Your Z Coordinates : " + playerLoc.getZ());
	}
	*/

}