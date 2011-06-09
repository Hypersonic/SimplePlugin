package aor.SimplePlugin;

import org.bukkit.event.block.BlockListener;

public class SPBlockListener extends BlockListener{
	public static SimplePlugin plugin;
	
	public SPBlockListener(SimplePlugin instance){
		plugin=instance;
	}
}