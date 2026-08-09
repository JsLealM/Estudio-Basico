package org.jslealm.basico;

import org.bukkit.plugin.java.JavaPlugin;
import org.jslealm.basico.commands.EjercicioCommand;
import org.jslealm.basico.commands.MtoolsCommand;
import org.jslealm.basico.commands.PrincipalCommand;
import org.jslealm.basico.listeners.DamageEntityListener;
import org.jslealm.basico.listeners.PlayerListener;

public final class Basico extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("[Basico] Plugin Iniciado!");
        registerCommand();
        registerListeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerListeners (){
        var pm = getServer().getPluginManager();
        pm.registerEvents(new DamageEntityListener(), this);
        pm.registerEvents(new PlayerListener(), this);
    }

    private void registerCommand (){
        getCommand("monda").setExecutor(new PrincipalCommand());
        getCommand("ejercicio").setExecutor(new EjercicioCommand());
        getCommand("mtools").setExecutor(new MtoolsCommand());
    }
}


    /* Formas de Crear Comandos
    1. Comando Clase Anonima
    2. Comando por Metodo
    3. Comando por Clase
     */

    /* COMANDO POR CLASE ANONIMA

    @Override
    public void onEnable() {
        getLogger().info("[Basico] Plugin Iniciado!");
        getCommand("anonimo").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                if (sender instanceof Player){
                    Player p = (Player) sender;
                    p.sendMessage("Has Ejecutado un comando como instancia anonima");
                }
                return true;
            }
        });
    }
    */

//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//        if (command.getName().equalsIgnoreCase("metodo")) {
//            if (sender instanceof Player){
//                Player p = (Player) sender;
//                p.sendMessage(ChatColor.GREEN + "Metodo del comando");
//            }
//        }
//        return true;
//    }

//        getCommand("anonimo").setExecutor(new CommandExecutor() {
//            @Override
//            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//                if (sender instanceof Player){
//                    Player p = (Player) sender;
//                    p.sendMessage("Has Ejecutado un comando como instancia anonima");
//                }
//                return true;
//            }
//        });