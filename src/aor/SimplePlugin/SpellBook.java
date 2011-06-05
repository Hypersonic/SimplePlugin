package aor.SimplePlugin;

import java.util.ArrayList;
import aor.SimplePlugin.Spell;
import org.bukkit.entity.Player;

public class SpellBook { // TODO: In constructor initialize all dah spells.
	ArrayList<Spell> spellRegistry = new ArrayList<Spell>();
	
	public int index = 0;
	
	
	public void registerSpell(Spell sp){
		spellRegistry.add(sp);
	}
	
	public Spell returnFirstEntry()
	{
		return spellRegistry.get(0);
	}
	
	public Spell getCurrentSpell()
	{
		return spellRegistry.get(index);
	}
	

 	public Spell nextSpell(Player player)
 	{
 		if (index != spellRegistry.size() - 1) { index++; } // Remember indexes start at 0.
 		else { index = 0; }
 		player.sendMessage("Selected spell: " + getCurrentSpell().getName()); // Print Selected spell: (spell name)
 		return getCurrentSpell();
	}

}
