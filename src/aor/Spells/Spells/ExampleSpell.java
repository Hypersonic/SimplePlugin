package aor.Spells.Spells;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import aor.Spells.SimplePlugin;
import aor.Spells.Spell;

/**
 * This spell is designed to be used as a template and example for how to use the spell API. It demonstrates the way to use runnables.
 * It is recommended that you also look at the documentation for the functions that are used, because the javadoc goes into more depth.
 * This spell sends the player a message 10 seconds after they cast the spell.
 * @author Jay
 */
public class ExampleSpell extends Spell{
	//this arraylist stores the people that have cast the spell
	public ArrayList<Player> watchedPlayers=new ArrayList<Player>();
	//note that unlike in previous APIs, the constructor is only used once and there is only one central copy of each spell.
	public ExampleSpell(SimplePlugin instance){
		//this allows for more functionality, especially the delayedRun function, because the spell must have a way to reference the main class
		plugin=instance;
		//set the description, short name and name of the spell
		spellDescription="This is an example/template spell that shows how to use the new API";
		shortName="example";
		spellName="Example Spell";
		//set the required items to use the spell. In this case 4 bones and 2 pieces of paper
		setRequiredItems(new ItemStack[]{new ItemStack(Material.BONE,4),new ItemStack(Material.PAPER,2)});
	}
	//this function is run when the player casts the spell.
	public void castSpell(Player player){
		//remove the items from the player's inventory.
		if(removeRequiredItemsFromInventory(player.getInventory())){
			//once the player has payed for the spell, they get added to the watched player list. Any player on this list will get checked for placing blocks and moving.
			watchedPlayers.add(player);
			//run the run function in 10 seconds 10*20=200. Note that this is a much better function to use than the bukkit scheduler, because if the plugin is disabled,
			//in this function everything is just called early and you don't need to deal with onDisable, although you can if you want to. The 0 is the argument that
			//the run function is called with.
			delayedRun(200,0);
		}
		else{
			//Tell the player when he/she does not have all of the required materials.
			player.sendMessage("Sorry, you do not have the necesary materials for this spell!");
		}
	}
	//although there is a delay function, it can only delay the run() function, so all necessary possibilities for what was delayed must be in this function. ex.
	//if there are multiple messages after different amounts of time, you need to find a way of storing which case must be done by storing it in the argument variable.
	public void run(Object... argument){
		//send the player that cast the spell the longest ago a message telling them that they cast the spell 10 seconds ago.
		watchedPlayers.get(0).sendMessage("You cast the example spell 10 seconds ago");
		//remove them from the list, so that the next time the function is run, the next player gets sent the message.
		watchedPlayers.remove(0);
	}
}