package aor.SimplePlugin;

import org.bukkit.event.entity.EntityListener;

public class SPEntityListener extends EntityListener{
	public static SimplePlugin plugin;
	
	public SPEntityListener(SimplePlugin instance){
		plugin=instance;
	}
}