package aor.SimplePlugin.Spells;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import java.util.ArrayList;
import aor.SimplePlugin.*;


public class MidasTouch extends Spell{
	public ArrayList<Player> players=new ArrayList<Player>(0);
	public MidasTouch(){
		spellDescription="This spell turns every block you touch into a gold block for one minute.";
		shortName="Midas";
		spellName="Midas' Touch";
		setRequiredItems(new ItemStack(Material.GOLD_BLOCK,10));
	}
	public void castSpell(Player player){
		if(players.contains(player)){
			
		}
		else{
			
		}
	}
	public void run(){
		
	}
}