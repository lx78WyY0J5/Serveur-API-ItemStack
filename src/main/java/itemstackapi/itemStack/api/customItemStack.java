package itemstackapi.itemStack.api;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.java.JavaPlugin;

public class customItemStack
{
    private static JavaPlugin plugin;

    public static JavaPlugin getPlugin()
    {
        return plugin;
    }

    public static PersistentDataContainer getPersistentDataContainer(ItemStack itemStack)
    {
        return itemStack.getItemMeta().getPersistentDataContainer();
    }

    public void test()
    {

    }


    public static Boolean isCustomItemStack(ItemStack itemStack)
    {
        return false;
    }

    //make this as enum like for menuAPI
    public enum key
    {

    }

    //make this as enum like for menuAPI
    NamespacedKey namespacedKey = new NamespacedKey(getPlugin(), "");


}