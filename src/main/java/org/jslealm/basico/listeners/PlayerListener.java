package org.jslealm.basico.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(String.format("Bienvenido al servidor, %s es un nuevo Mondaliano",player.getName()));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        event.setQuitMessage(String.format("El Jugador %s salio del servidor. Guardando su Progreso", player.getName()));
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        Player player = event.getEntity().getPlayer();
        if (player != null)
            event.setDeathMessage(String.format("El Mondaliano %s ha perdido una vida. Felicitenlo...", player.getName()));
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(String.format("Has perdido una vida. Ahora tienes %d. Vales Monda PA", 2));
    }


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Action action = event.getAction();
        Player player = event.getPlayer();
        if (event.getMaterial() == Material.DIAMOND){
            player.sendMessage("Has usado el diamante de la suerte");
        }else {
            switch (action){
                case LEFT_CLICK_AIR -> player.sendMessage("Has hecho click izquierdo en el aire.");
                case RIGHT_CLICK_AIR -> player.sendMessage("Has hecho click derecho en el aire.");
                case LEFT_CLICK_BLOCK -> player.sendMessage(String.format("Has hecho click izquierdo en  %s", event.getClickedBlock().getType()));
                case RIGHT_CLICK_BLOCK -> player.sendMessage(String.format("Has hecho click derecho en  %s", event.getClickedBlock().getType()));
                default -> player.sendMessage("Hola soy un mensaje");
            }
        }
    }

}
