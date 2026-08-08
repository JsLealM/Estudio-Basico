package org.jslealm.basico.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrincipalCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Los comandos solo pueden ser ejecutados por un jugador");
            return true;
        }
        Player jugador =  (Player) sender;
        jugador.sendMessage("Has Ejecutado un comando");
        return true;
    }
}
