package aor.SimplePlugin;

import org.bukkit.event.vehicle.VehicleListener;

public class SPVehicleListener extends VehicleListener{
    public static SimplePlugin plugin;
    
    public SPVehicleListener(SimplePlugin instance){
        plugin=instance;
    }
}