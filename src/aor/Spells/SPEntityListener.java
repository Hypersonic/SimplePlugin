package aor.Spells;

import org.bukkit.event.entity.*;
import org.bukkit.event.painting.*;

public class SPEntityListener extends EntityListener{
	public static SpellsMain plugin;
	
	public SPEntityListener(SpellsMain instance){
		plugin=instance;
	}
	public void onCreatureSpawn(CreatureSpawnEvent event){
		for(int i=0;i<plugin.spellOnCreatureSpawnList.size();i++){
			plugin.spellList.get(plugin.spellOnCreatureSpawnList.get(i)).onCreatureSpawn(event);
		}
	}
	public void onCreeperPower(CreeperPowerEvent event){
		for(int i=0;i<plugin.spellOnCreeperPowerList.size();i++){
			plugin.spellList.get(plugin.spellOnCreeperPowerList.get(i)).onCreeperPower(event);
		}
	}
	public void onEntityCombust(EntityCombustEvent event){
		for(int i=0;i<plugin.spellOnEntityCombustList.size();i++){
			plugin.spellList.get(plugin.spellOnEntityCombustList.get(i)).onEntityCombust(event);
		}
	}
	public void onEntityDamage(EntityDamageEvent event){
		for(int i=0;i<plugin.spellOnEntityDamageList.size();i++){
			plugin.spellList.get(plugin.spellOnEntityDamageList.get(i)).onEntityDamage(event);
		}
	}
	public void onEntityDeath(EntityDeathEvent event){
		for(int i=0;i<plugin.spellOnEntityDeathList.size();i++){
			plugin.spellList.get(plugin.spellOnEntityDeathList.get(i)).onEntityDeath(event);
		}
	}
	public void onEntityExplode(EntityExplodeEvent event){
		for(int i=0;i<plugin.spellOnEntityExplodeList.size();i++){
			plugin.spellList.get(plugin.spellOnEntityExplodeList.get(i)).onEntityExplode(event);
		}
	}
	public void onEntityInteract(EntityInteractEvent event){
		for(int i=0;i<plugin.spellOnEntityInteractList.size();i++){
			plugin.spellList.get(plugin.spellOnEntityInteractList.get(i)).onEntityInteract(event);
		}
	}
	public void onEntityPortalEnter(EntityPortalEnterEvent event){
		for(int i=0;i<plugin.spellOnEntityPortalEnterList.size();i++){
			plugin.spellList.get(plugin.spellOnEntityPortalEnterList.get(i)).onEntityPortalEnter(event);
		}
	}
	public void onEntityTame(EntityTameEvent event){
		for(int i=0;i<plugin.spellOnEntityTameList.size();i++){
			plugin.spellList.get(plugin.spellOnEntityTameList.get(i)).onEntityTame(event);
		}
	}
	public void onEntityTarget(EntityTargetEvent event){
		for(int i=0;i<plugin.spellOnEntityTargetList.size();i++){
			plugin.spellList.get(plugin.spellOnEntityTargetList.get(i)).onEntityTarget(event);
		}
	}
	public void onExplosionPrime(ExplosionPrimeEvent event){
		for(int i=0;i<plugin.spellOnExplosionPrimeList.size();i++){
			plugin.spellList.get(plugin.spellOnExplosionPrimeList.get(i)).onExplosionPrime(event);
		}
	}
	public void onPaintingBreak(PaintingBreakEvent event){
		for(int i=0;i<plugin.spellOnPaintingBreakList.size();i++){
			plugin.spellList.get(plugin.spellOnPaintingBreakList.get(i)).onPaintingBreak(event);
		}
	}
	public void onPaintingPlace(PaintingPlaceEvent event){
		for(int i=0;i<plugin.spellOnPaintingPlaceList.size();i++){
			plugin.spellList.get(plugin.spellOnPaintingPlaceList.get(i)).onPaintingPlace(event);
		}
	}
	public void onPigZap(PigZapEvent event){
		for(int i=0;i<plugin.spellOnPigZapList.size();i++){
			plugin.spellList.get(plugin.spellOnPigZapList.get(i)).onPigZap(event);
		}
	}
}