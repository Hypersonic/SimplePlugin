/**
 * This is a template spell that has the most basic components of a spell, so you don't have to start from scratch every time. There are syntax errors, but they are only
 * there because they have not yet been filled in, because this is a template. It is all in a comment to avoid it from annoying people with the errors.
 * @author Jay
 */

package aor.Spells.Spells;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;

import aor.Spells.*;


public class TemplateSpell extends Spell{
	public TemplateSpell(){
		spellDescription="";
		shortName="";
		spellName="";
		setRequiredItems(new ItemStack[]{new ItemStack(Material.BONE,0),new ItemStack(Material.SLIME_BALL,0)});
	}
	public void castSpell(Player player){
		
	}
	public void run(Object... argument){
		
	}
}
