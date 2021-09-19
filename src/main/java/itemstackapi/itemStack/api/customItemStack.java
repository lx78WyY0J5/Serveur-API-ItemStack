package itemstackapi.itemStack.api;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public class customItemStack
{
    private static JavaPlugin plugin;

    public static JavaPlugin getPlugin()
    {
        return plugin;
    }

    public static NamespacedKey getKeyAsNameSpaced(customKey customKey)
    {
        return new NamespacedKey(getPlugin(), customKey.toString());
    }

    public static void setPersistentDataItemStack(ItemStack itemStack, customKey customKey)
    {
        ItemMeta                itemMeta                = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        persistentDataContainer.set(getKeyAsNameSpaced(customKey), PersistentDataType.STRING, customKey.toString());
        itemStack.setItemMeta(itemMeta);
    }

    public static void setPersistentDataItemStack(ItemStack itemStack, customKey customKey, PersistentDataType persistentDataType)
    {
        ItemMeta                itemMeta                = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        persistentDataContainer.set(getKeyAsNameSpaced(customKey), persistentDataType, customKey.toString());
        itemStack.setItemMeta(itemMeta);
    }

    public static Boolean hasPersistentDataItemStack(ItemStack itemStack, customKey customKey)
    {
        ItemMeta                itemMeta                = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        if (persistentDataContainer.has(getKeyAsNameSpaced(customKey), PersistentDataType.STRING))
        {
            if (persistentDataContainer.get(getKeyAsNameSpaced(customKey), PersistentDataType.STRING).equals(customKey.toString()))
            {
                return true;
            }
        }
        return false;
    }

    public static Boolean hasPersistentDataItemStack(ItemStack itemStack, customKey customKey, PersistentDataType persistentDataType)
    {
        ItemMeta                itemMeta                = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        if (persistentDataContainer.has(getKeyAsNameSpaced(customKey), persistentDataType))
        {
            if (persistentDataContainer.get(getKeyAsNameSpaced(customKey), persistentDataType).equals(customKey.toString()))
            {
                return true;
            }
        }
        return false;
    }

    public static Boolean isCustomItemStack(ItemStack itemStack, customKey customKey, PersistentDataType persistentDataType)
    {
        if (hasPersistentDataItemStack(itemStack, customKey.custom, persistentDataType))
        {
            return true;
        }
        return false;
    }

    public static Boolean isCustomItemStack(ItemStack itemStack, customKey customKey)
    {
        if (hasPersistentDataItemStack(itemStack, customKey.custom, PersistentDataType.STRING))
        {
            return true;
        }
        return false;
    }

    public enum customKey
    {
        custom, ile, voyage, shop, enchant, quest, compass
    }
}