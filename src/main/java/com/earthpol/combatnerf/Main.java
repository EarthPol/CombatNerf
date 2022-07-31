package com.earthpol.combatnerf;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.gmail.goosius.siegewar.utils.SiegeWarDistanceUtil;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    private static Main instance;
    private static Logger log = Bukkit.getLogger();
    public static final String PREFIX = ChatColor.of("#3fb78d").toString() + ChatColor.BOLD + "E" + ChatColor.of("#57c28a").toString() + ChatColor.BOLD + "a" + ChatColor.of("#6fcd85").toString() + ChatColor.BOLD + "r" + ChatColor.of("#88d880").toString() + ChatColor.BOLD + "t" + ChatColor.of("#a3e27a").toString() + ChatColor.BOLD + "h" + ChatColor.of("#beeb75").toString() + ChatColor.BOLD + "P" + ChatColor.of("#dcf371").toString() + ChatColor.BOLD + "o" + ChatColor.of("#fafa6e").toString() + ChatColor.BOLD + "l" + ChatColor.WHITE + " • " + ChatColor.RESET + "§6";
    public static final String DISCORD = "https://discord.gg/earthpol";

    private ProtocolManager protocolManager;

    public static Main getInstance(){ return instance; }

    @Override
    public void onEnable() {
        instance = this;
        protocolManager = ProtocolLibrary.getProtocolManager();
        compilePacketListeners();
    }

    public void compilePacketListeners(){
        protocolManager.addPacketListener(new PacketAdapter(this,
                ListenerPriority.NORMAL,
                PacketType.Play.Server.ENTITY_EFFECT) {
            @Override
            public void onPacketSending(PacketEvent event) {
                if (event.getPacketType() == PacketType.Play.Server.ENTITY_EFFECT){
                    Player player = event.getPlayer();

                    //Remove Invisibility in SiegeWar Zone
                    if(player.hasPotionEffect(PotionEffectType.INVISIBILITY) && SiegeWarDistanceUtil.isLocationInActiveSiegeZone(player.getLocation())){
                        player.removePotionEffect(PotionEffectType.INVISIBILITY);
                    }

                    //Remove Blindness in Siege War Zone
                    if(player.hasPotionEffect(PotionEffectType.BLINDNESS) && SiegeWarDistanceUtil.isLocationInActiveSiegeZone(player.getLocation())){
                        player.removePotionEffect(PotionEffectType.BLINDNESS);
                    }

                    //Remove Poison in Siege War Zone
                    if(player.hasPotionEffect(PotionEffectType.POISON) && SiegeWarDistanceUtil.isLocationInActiveSiegeZone(player.getLocation())){
                        player.removePotionEffect(PotionEffectType.POISON);
                    }

                    //Remove Slowness in Siege War Zone
                    if(player.hasPotionEffect(PotionEffectType.SLOW) && SiegeWarDistanceUtil.isLocationInActiveSiegeZone(player.getLocation())){
                        player.removePotionEffect(PotionEffectType.SLOW);
                    }

                    //Remove Slow Digging in Siege War Zone
                    if(player.hasPotionEffect(PotionEffectType.SLOW_DIGGING) && SiegeWarDistanceUtil.isLocationInActiveSiegeZone(player.getLocation())){
                        player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
                    }

                    //Remove Haste in Siege War Zone
                    if(player.hasPotionEffect(PotionEffectType.FAST_DIGGING) && SiegeWarDistanceUtil.isLocationInActiveSiegeZone(player.getLocation())){
                        player.removePotionEffect(PotionEffectType.FAST_DIGGING);
                    }

                    //Remove Wither in Siege War Zone
                    if(player.hasPotionEffect(PotionEffectType.WITHER) && SiegeWarDistanceUtil.isLocationInActiveSiegeZone(player.getLocation())){
                        player.removePotionEffect(PotionEffectType.WITHER);
                    }

                    //Remove Hunger in Siege War Zone
                    if(player.hasPotionEffect(PotionEffectType.HUNGER) && SiegeWarDistanceUtil.isLocationInActiveSiegeZone(player.getLocation())){
                        player.removePotionEffect(PotionEffectType.HUNGER);
                    }

                    //Remove Health Boost in Siege War Zone
                    if(player.hasPotionEffect(PotionEffectType.HEALTH_BOOST) && SiegeWarDistanceUtil.isLocationInActiveSiegeZone(player.getLocation())){
                        player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                    }

                    //Remove Nausea in Siege War Zone
                    if(player.hasPotionEffect(PotionEffectType.CONFUSION) && SiegeWarDistanceUtil.isLocationInActiveSiegeZone(player.getLocation())){
                        player.removePotionEffect(PotionEffectType.CONFUSION);
                    }

                    //Remove Saturation Boost in Siege War Zone
                    if(player.hasPotionEffect(PotionEffectType.SATURATION) && SiegeWarDistanceUtil.isLocationInActiveSiegeZone(player.getLocation())){
                        player.removePotionEffect(PotionEffectType.SATURATION);
                    }

                    //Remove Damage Resistance in Siege War Zone
                    if(player.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE) && SiegeWarDistanceUtil.isLocationInActiveSiegeZone(player.getLocation())){
                        player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                    }

                    //Remove Levitation
                    if(player.hasPotionEffect(PotionEffectType.LEVITATION) && SiegeWarDistanceUtil.isLocationInActiveSiegeZone(player.getLocation())){
                        player.removePotionEffect(PotionEffectType.LEVITATION);
                    }

                    //Remove increased strength in Siege War Zone
                    if(player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE) && SiegeWarDistanceUtil.isLocationInActiveSiegeZone(player.getLocation())){
                        if(Objects.requireNonNull(player.getPotionEffect(PotionEffectType.INCREASE_DAMAGE)).getAmplifier() > 1){
                            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                        }
                    }

                }
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
