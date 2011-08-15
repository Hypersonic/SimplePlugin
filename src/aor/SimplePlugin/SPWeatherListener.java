package aor.SimplePlugin;

import org.bukkit.event.weather.*;

public class SPWeatherListener extends WeatherListener{
    public static SimplePlugin plugin;
    
    public SPWeatherListener(SimplePlugin instance){
        plugin=instance;
    }
    public void onLightningStrike(LightningStrikeEvent event){
		for(int i=0;i<plugin.spellOnLightningStrikeList.size();i++){
			plugin.spellList.get(plugin.spellOnLightningStrikeList.get(i)).onLightningStrike(event);
		}
	}
    public void onThunderChange(ThunderChangeEvent event){
		for(int i=0;i<plugin.spellOnThunderChangeList.size();i++){
			plugin.spellList.get(plugin.spellOnThunderChangeList.get(i)).onThunderChange(event);
		}
	}
    public void onWeatherChange(WeatherChangeEvent event){
		for(int i=0;i<plugin.spellOnWeatherChangeList.size();i++){
			plugin.spellList.get(plugin.spellOnWeatherChangeList.get(i)).onWeatherChange(event);
		}
	}
}