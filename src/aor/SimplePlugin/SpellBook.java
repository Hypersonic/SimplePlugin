package aor.SimplePlugin;

import java.util.ArrayList;
import aor.SimplePlugin.Spell;

public class SpellBook { // TODO: In constructor initialize all dah spells.
	ArrayList<Spell> spellRegistry = new ArrayList<Spell>();
	
	

	
	
	public void registerSpell(Spell sp){
		spellRegistry.add(sp);
	}
	
	public Spell returnFirstEntry()
	{
		return spellRegistry.get(0);
	}
	
	

	/*
 	public Spell selectNextSpell(){
		//TODO: Spell scrolling
	}
	 */
}
