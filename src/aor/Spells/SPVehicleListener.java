package aor.Spells;

import org.bukkit.event.vehicle.*;

public class SPVehicleListener extends VehicleListener{
    public static SimplePlugin plugin;
    
    public SPVehicleListener(SimplePlugin instance){
        plugin=instance;
    }
	public boolean onVehicleBlockCollision=false;
	public void onVehicleBlockCollision(VehicleBlockCollisionEvent event){
		for(int i=0;i<plugin.spellOnVehicleBlockCollisionList.size();i++){
			plugin.spellList.get(plugin.spellOnVehicleBlockCollisionList.get(i)).onVehicleBlockCollision(event);
		}
	}
	public boolean onVehicleCreate=false;
	public void onVehicleCreate(VehicleCreateEvent event){
		for(int i=0;i<plugin.spellOnVehicleCreateList.size();i++){
			plugin.spellList.get(plugin.spellOnVehicleCreateList.get(i)).onVehicleCreate(event);
		}
	}
	public boolean onVehicleDamage=false;
	public void onVehicleDamage(VehicleDamageEvent event){
		for(int i=0;i<plugin.spellOnVehicleDamageList.size();i++){
			plugin.spellList.get(plugin.spellOnVehicleDamageList.get(i)).onVehicleDamage(event);
		}
	}
	public boolean onVehicleDestroy=false;
	public void onVehicleDestroy(VehicleDestroyEvent event){
		for(int i=0;i<plugin.spellOnVehicleDestroyList.size();i++){
			plugin.spellList.get(plugin.spellOnVehicleDestroyList.get(i)).onVehicleDestroy(event);
		}
	}
	public boolean onVehicleEnter=false;
	public void onVehicleEnter(VehicleEnterEvent event){
		for(int i=0;i<plugin.spellOnVehicleEnterList.size();i++){
			plugin.spellList.get(plugin.spellOnVehicleEnterList.get(i)).onVehicleEnter(event);
		}
	}
	public boolean onVehicleEntityCollision=false;
	public void onVehicleEntityCollision(VehicleEntityCollisionEvent event){
		for(int i=0;i<plugin.spellOnVehicleEntityCollisionList.size();i++){
			plugin.spellList.get(plugin.spellOnVehicleEntityCollisionList.get(i)).onVehicleEntityCollision(event);
		}
	}
	public boolean onVehicleExit=false;
	public void onVehicleExit(VehicleExitEvent event){
		for(int i=0;i<plugin.spellOnVehicleExitList.size();i++){
			plugin.spellList.get(plugin.spellOnVehicleExitList.get(i)).onVehicleExit(event);
		}
	}
	public boolean onVehicleMove=false;
	public void onVehicleMove(VehicleMoveEvent event){
		for(int i=0;i<plugin.spellOnVehicleMoveList.size();i++){
			plugin.spellList.get(plugin.spellOnVehicleMoveList.get(i)).onVehicleMove(event);
		}
	}
}