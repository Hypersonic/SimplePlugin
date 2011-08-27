package aor.Spells.Spells;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import aor.Spells.SpellsMain;
import aor.Spells.Spell;

/**
 * This spell is designed to be used as a template and example for how to use the spell API. It demonstrates the way to use runnables with listeners.
 * Before looking at this example, you should look at the other example spell
 * It is recommended that you also look at the documentation for the functions that are used, because the javadoc goes into more depth.
 * This spell sends the player a message whenever he or she breaks a block and sends him/her the coordinates of the block. The spell runs out after 60 seconds.
 * @author Jay
 */
public class ExampleSpell2 extends Spell{
	//this arraylist stores the people that have cast the spell
	public ArrayList<Player> watchedPlayers=new ArrayList<Player>();
	//note that unlike in previous APIs, the constructor is only used once and there is only one central copy of each spell.
	public ExampleSpell2(SpellsMain instance){
		//this allows for more functionality, especially the delayedRun function, because the spell must have a way to reference the main class
		plugin=instance;
		//set the description, short name and name of the spell
		spellDescription="This is another example/template spell that shows how to use the new API";
		shortName="example2";
		spellName="Example Spell 2";
		//set the required items to use the spell.
		setRequiredItems(new ItemStack[]{new ItemStack(Material.WOOL,6),new ItemStack(Material.LOG,2)});
		//this enables the onBlockBreak event. This make the onBlockBreak function automatically run when a block has been broken. Changing this later will have no affect
		//on the spell.
		onBlockBreak=true;
	}
	//this function is run when the player casts the spell.
	public void castSpell(Player player){
		//remove the items from the player's inventory.
		if(removeRequiredItemsFromInventory(player.getInventory())){
			//make sure the player has not already cast the spell
			if(!watchedPlayers.contains(player)){
				//once the player has payed for the spell, they get added to the watched player list. Any player on this list will get checked for placing blocks and moving.
				watchedPlayers.add(player);
				//run the run function in 60 seconds 60*20=1200. Note that this is a much better function to use than the bukkit scheduler, because if the plugin is disabled,
				//in this function everything is just called early and you don't need to deal with onDisable, although you can if you want to. The 0 is the argument that
				//the run function is called with.
				delayedRun(1200,0);
			}
			else{
				//tell the player that he/she has already cast the spell.
				player.sendMessage("You have already cast the spell!");
			}
		}
		else{
			//Tell the player when he/she does not have all of the required materials.
			player.sendMessage("Sorry, you do not have the necesary materials for this spell!");
		}
	}
	//although there is a delay function, it can only delay the run() function, so all necesary possibilities for what was delayed must be in this function. However, we have
	//set up a delayedRun function that takes arguments, making it easier to run different things. It is recommended that you use a switch with the argument to determine
	//what to do, if you are in a situation where you might want multiple run functions.
	public void run(Object... argument){
		//send the player that cast the spell the longest ago a message telling them that the spell has expired.
		watchedPlayers.get(0).sendMessage("Example Spell 2 has expired!"+argument);
		//remove them from the list, so that the next time the function is run, the next player gets sent the message.
		watchedPlayers.remove(0);
	}
	//runs whenever a player breaks a block. The block break event stores the player and block and allows it to be cancelled
	public void onBlockBreak(BlockBreakEvent event){
		//check if the player cast the spell in the last minute
		if(watchedPlayers.contains(event.getPlayer())){
			//if the player did, tell them that they did and send them the x, y and z coordinates.
			event.getPlayer().sendMessage("You just broke a block! The coordinates were:");
			event.getPlayer().sendMessage("X: "+event.getBlock().getX()+"Y: "+event.getBlock().getX()+"Y: "+event.getBlock().getZ());
		}
	}
}