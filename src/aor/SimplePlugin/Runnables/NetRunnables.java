package aor.SimplePlugin.Runnables;


import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;

public class NetRunnables implements Runnable {

	ArrayList<Location> spawnedEntity;
	
	public NetRunnables(ArrayList<Location> ispawnedEntity){
		spawnedEntity = ispawnedEntity;
	}
	public void run(){
		for(int i = 0; i < spawnedEntity.size(); i++){
			spawnedEntity.get(i).getWorld().getBlockAt(spawnedEntity.get(i)).setType(Material.AIR);
		}
	}
}
