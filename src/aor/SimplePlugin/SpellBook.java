package aor.SimplePlugin;

import java.util.ArrayList;
import aor.SimplePlugin.Spell;

public class SpellBook {
	ArrayList<Spell> spellRegistry = new ArrayList<Spell>();
	
	public void registerSpell(Spell sp){
		spellRegistry.add(sp);
	}
	
	public Spell selectNextSpell(){
		//TODO: Spell scrolling
	}
}
