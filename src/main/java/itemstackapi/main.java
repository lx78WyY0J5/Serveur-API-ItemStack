package itemstackapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class main extends JavaPlugin
{
    private static Logger logger = Bukkit.getLogger();

    @Override
    public void onLoad()
    {
        logger.info("Plugin Loaded");
    }

    @Override
    public void onEnable()
    {
        logger.info("Plugin Enabled");
        registerEvents();
        registerCommands();
        lib.hook();
    }

    @Override
    public void onDisable()
    {
        logger.info("Plugin Disabled");
    }

    public void registerEvents()
    {
    }

    public void registerCommands()
    {
    }
}