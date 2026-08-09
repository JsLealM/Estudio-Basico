package org.jslealm.basico.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MtoolsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0){
            showMenu(sender);
            return true;
        }
        subCommands(sender, args);
        return true;
    }

    private void subCommands (CommandSender sender, String[] args){
        switch (args[0].toLowerCase()){
            case "help" -> showMenu(sender);
            case "player" -> playerCommand(sender, args);
            case "admin" -> adminCommand(sender, args);
            default -> sender.sendMessage("Comando desconocido. Utiliza /mtools help.");
        }
    }

    private void adminCommand(CommandSender sender, String[] args) {
        if (args.length != 2 || !args[1].equalsIgnoreCase("reload")){
            sender.sendMessage("Uso: /mtools admin reload");
            return;
        }
        if (sender instanceof Player player && !player.hasPermission("mtools.admin")){
            player.sendMessage("No tienes permiso para utilizar este comando");
            return;
        }
        sender.sendMessage("Configuracion recargada correctamente");
    }

    private void playerCommand (CommandSender sender, String[] args){
        if (args.length != 2){
            sender.sendMessage("Uso: /mtools player <jugador>");
            return;
        }
        Player player = Bukkit.getPlayer(args[1]);
        if (player == null){
            sender.sendMessage("El jugador no existe o no esta conectado");
            return;
        }
        sender.sendMessage(String.format("""
                === Player Info ===
                Jugador : %s
                Estado: ONLINE
                """, player.getName()));
    }

    private void showMenu (CommandSender sender){
        sender.sendMessage("""
                === Mondaland Tools ===
                /mtools help
                /mtools player <jugador>
                /mtools admin reload
                """);
    }
}