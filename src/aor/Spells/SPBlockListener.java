package aor.Spells;

import org.bukkit.event.block.*;

public class SPBlockListener extends BlockListener{
	public static SimplePlugin plugin;
	
	public SPBlockListener(SimplePlugin instance){
		plugin=instance;
	}
	public void onBlockBreak(BlockBreakEvent event){
		for(int i=0;i<plugin.spellOnBlockBreakList.size();i++){
			plugin.spellList.get(plugin.spellOnBlockBreakList.get(i)).onBlockBreak(event);
		}
	}
	public void onBlockBurn(BlockBurnEvent event){
		for(int i=0;i<plugin.spellOnBlockBurnList.size();i++){
			plugin.spellList.get(plugin.spellOnBlockBurnList.get(i)).onBlockBurn(event);
		}
	}
	public void onBlockCanBuild(BlockCanBuildEvent event){
		for(int i=0;i<plugin.spellOnBlockCanBuildList.size();i++){
			plugin.spellList.get(plugin.spellOnBlockCanBuildList.get(i)).onBlockCanBuild(event);
		}
	}
	public void onBlockDamage(BlockDamageEvent event){
		for(int i=0;i<plugin.spellOnBlockDamageList.size();i++){
			plugin.spellList.get(plugin.spellOnBlockDamageList.get(i)).onBlockDamage(event);
		}
	}
	public void onBlockDispense(BlockDispenseEvent event){
		for(int i=0;i<plugin.spellOnBlockDispenceList.size();i++){
			plugin.spellList.get(plugin.spellOnBlockDispenceList.get(i)).onBlockDispense(event);
		}
	}
	public void onBlockFromTo(BlockFromToEvent event){
		for(int i=0;i<plugin.spellOnBlockFromToList.size();i++){
			plugin.spellList.get(plugin.spellOnBlockFromToList.get(i)).onBlockFromTo(event);
		}
	}
	public void onBlockIgnite(BlockIgniteEvent event){
		for(int i=0;i<plugin.spellOnBlockIgniteList.size();i++){
			plugin.spellList.get(plugin.spellOnBlockIgniteList.get(i)).onBlockIgnite(event);
		}
	}
	public void onBlockPhysics(BlockPhysicsEvent event){
		for(int i=0;i<plugin.spellOnBlockPhysicsList.size();i++){
			plugin.spellList.get(plugin.spellOnBlockPhysicsList.get(i)).onBlockPhysics(event);
		}
	}
	public void onBlockPlace(BlockPlaceEvent event){
		for(int i=0;i<plugin.spellOnBlockPlaceList.size();i++){
			plugin.spellList.get(plugin.spellOnBlockPlaceList.get(i)).onBlockPlace(event);
		}
	}
	public void onBlockRedstoneChange(BlockRedstoneEvent event){
		for(int i=0;i<plugin.spellOnBlockRedstoneChangeList.size();i++){
			plugin.spellList.get(plugin.spellOnBlockRedstoneChangeList.get(i)).onBlockRedstoneChange(event);
		}
	}
	public void onLeavesDecay(LeavesDecayEvent event){
		for(int i=0;i<plugin.spellOnLeavesDecayList.size();i++){
			plugin.spellList.get(plugin.spellOnLeavesDecayList.get(i)).onLeavesDecay(event);
		}
	}
	public void onSignChange(SignChangeEvent event){
		for(int i=0;i<plugin.spellOnSignChangeList.size();i++){
			plugin.spellList.get(plugin.spellOnSignChangeList.get(i)).onSignChange(event);
		}
	}
	public void onSnowForm(BlockFormEvent event){
		for(int i=0;i<plugin.spellOnBlockFormList.size();i++){
			plugin.spellList.get(plugin.spellOnBlockFormList.get(i)).onBlockForm(event);
		}
	}
}