package aor.SimplePlugin;


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

}