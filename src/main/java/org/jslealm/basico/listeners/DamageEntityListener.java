package org.jslealm.basico.listeners;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Locale;

public class DamageEntityListener implements Listener {
    @EventHandler
    public void onDamageEntity (EntityDamageByEntityEvent event){
        Entity entity = event.getDamager();
        if (entity.getType() == EntityType.PLAYER){
            Player player = (Player) entity;
            Entity victima = event.getEntity();
            player.sendMessage(String.format("Has golpeado a la entidad %s", victima.getType()));
        }
    }

    @EventHandler
    public void onBlockBreak (BlockBreakEvent event){
        Player player = event.getPlayer();
        Block bloque = event.getBlock();
        player.sendMessage(String.format("El Mondaliano %s ha picado %s",player.getName(), bloque.getType()));
    }

    @EventHandler
    public void onEntityDeath (EntityDeathEvent event){
        Entity victima = event.getEntity();
        if (event.getDamageSource().getDirectEntity() instanceof Player player){
            Bukkit.broadcastMessage(String.format("El Mondaliano %s ha matado %s", player.getName(), victima.getType()));
        }else if (event.getDamageSource().getDirectEntity() != null){
            Bukkit.broadcastMessage(String.format("La entidad %s ha muerto por %s", victima.getType(),event.getDamageSource().getDirectEntity().getType()));
        }else {
            Bukkit.broadcastMessage(String.format("La entidad %s ha muerto por %s", victima.getType(), event.getDamageSource().getDamageType().getTranslationKey()));
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        Entity entityDamage = event.getDamageSource().getDirectEntity();
        Entity entity = event.getEntity();
        if (entity instanceof Player player && entityDamage != null){
            double damage = event.getDamage();
            player.sendMessage(String.format("El Mondaliano %s ha recibido %.1f de %s", player.getName(), damage, entityDamage.getType()));
        }
        if (entity instanceof Player player && entityDamage == null){
            double damage = event.getDamage();
            String damageType = event.getDamageSource().getDamageType().getTranslationKey().toUpperCase();
            player.sendMessage(String.format("El Mondaliano %s ha recibido %.1f de %s", player.getName(), damage, damageType));
        }
    }
}
