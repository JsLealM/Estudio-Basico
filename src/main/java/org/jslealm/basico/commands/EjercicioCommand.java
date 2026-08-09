package org.jslealm.basico.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EjercicioCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player){
            if (args.length != 0){
                if (args[0].equalsIgnoreCase("admin") && player.hasPermission("ejercicio.admin")){
                    adminCommand(player, args);
                    return true;
                }
                subCommands(sender, args);
                return true;
            }
            player.sendMessage(String.format("Hola, %s", player.getName()));
            return true;
        }
        return true;
    }

    private void subCommands (CommandSender sender, String[] args){
        if (args.length == 1){
            String arg = args[0].toLowerCase();
            String commands = """
                Has utilizado el argumento help
                lives -> Comando de vidas
                coins -> Comando de monedas
                """;
            switch (arg){
                case "hola" -> sender.sendMessage("Has Utilizado el Argumento hola");
                case "coins" -> {
                    if (sender instanceof Player){
                        sender.sendMessage("Has utilizado el Argumento coins");
                        return;
                    }else {
                        sender.sendMessage("El comando solo puede ser usado por jugadores");
                        return;
                    }
                }
                case "help" -> sender.sendMessage(commands);
                case "lives" -> sender.sendMessage("Has utilizado el Argumento Lives");
                case "gift" -> {
                    if (sender instanceof Player)
                        sender.sendMessage("Utiliza el argumento /help para ver los comandos disponibles");
                    else
                        sender.sendMessage("El argumento se usa de esta forma /ej gift <coins or lives> <player> <cantidad>");
                }
                default -> sender.sendMessage("Utiliza el argumento /help para ver los comandos disponibles");
        }
        return;
        }
        if (!(sender instanceof Player) && args[0].equalsIgnoreCase("gift") && args.length == 4){
            if ((args[1].equalsIgnoreCase("coins") ||args[1].equalsIgnoreCase("lives")) && !(args[2].isEmpty()) && !(args[3].isEmpty())) {
                try {
                    int cantidad = Integer.parseInt(args[3]);
                    Player player = Bukkit.getPlayer(args[2]);
                    if (player == null){
                        sender.sendMessage("El jugador no existe o no esta conectado");
                        return;
                    }
                    sender.sendMessage(String.format("""
                            Sistema: gift
                            Acción: %s
                            Jugador: %s
                            Cantidad: %d
                            """, args[1], player.getName(), cantidad));
                }catch (NumberFormatException e){
                    sender.sendMessage(String.format("Has puesto un valor erroneo en la cantidad. %s", e));
                }
            }else
                sender.sendMessage("El argumento se usa de esta forma /ej gift <coins or lives> <player> <cantidad>");
        }else
            sender.sendMessage("Utiliza el argumento /help para ver los comandos disponibles");
    }

    private void adminCommand (Player sender, String[] args){
        if (args.length != 2 || !(args[1].equalsIgnoreCase("reload"))){
            sender.sendMessage("Has utilizado el comando admin. Para recargar haz /monda admin reload");
            return;
        }
        sender.sendMessage("Configuracion recargada correctamente");
    }
}
