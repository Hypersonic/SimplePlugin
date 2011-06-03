package aor.SimplePlugin;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;

/* Example Template
 * By Adamki11s
 * HUGE Plugin Tutorial
 */

public class SPEntityListener extends EntityListener {
	
	public static SimplePlugin plugin;
	
	public SPEntityListener(SimplePlugin instance) {
		plugin = instance;
	}

	public void onEntityDamage(EntityDamageEvent event){
		
		if(event.getEntity() instanceof Player){
		//If the entity being damaged is a player then...

			event.setCancelled(true);
		//Cancel the damage event, this will give the player unlimited health
		}
	}

}