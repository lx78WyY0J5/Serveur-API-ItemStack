package itemstackapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class lib
{
    private static JavaPlugin plugin;

    private static Logger logger = Bukkit.getLogger();

    public static JavaPlugin getPlugin()
    {
        return plugin;
    }

    public static void setPlugin(JavaPlugin plugin)
    {
        lib.plugin = plugin;
        logger.info("Plugin hook is set");
    }

    public static void hook()
    {
        menuapi.lib.setPlugin(main.getPlugin(main.class));
    }
}