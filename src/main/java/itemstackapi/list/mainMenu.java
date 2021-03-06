package itemstackapi.list;

import itemstackapi.persistentDataAPI;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class mainMenu
{
    public static ItemStack ItemStackCompass()
    {
        ItemStack is   = new ItemStack(Material.COMPASS);
        ItemMeta  meta = is.getItemMeta();
        meta.setDisplayName("§6Menu");
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(" ");
        Lore.add("§fOuvrez §7votre §fMenu");
        Lore.add("§fCommande§7 : /§6menu ");
        Lore.add(" ");
        meta.setLore(Lore);
        is.setItemMeta(meta);
        persistentDataAPI.setPersistentDataItemStack(is, persistentDataAPI.customKey.custom);
        persistentDataAPI.setPersistentDataItemStack(is, persistentDataAPI.customKey.compass);
        return is;
    }

    public static ItemStack ItemStackIle()
    {
        ItemStack is   = new ItemStack(Material.OAK_SAPLING);
        ItemMeta  meta = is.getItemMeta();
        meta.setDisplayName("§6Île");
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(" ");
        Lore.add("§7Votre menu d'§fîle");
        Lore.add("§fCommande§7 : /§6menu §2ile ");
        Lore.add(" ");
        meta.setLore(Lore);
        is.setItemMeta(meta);
        persistentDataAPI.setPersistentDataItemStack(is, persistentDataAPI.customKey.custom);
        persistentDataAPI.setPersistentDataItemStack(is, persistentDataAPI.customKey.ile);
        return is;
    }

    public static ItemStack ItemStackVoyage()
    {
        ItemStack is   = new ItemStack(Material.MINECART);
        ItemMeta  meta = is.getItemMeta();
        meta.setDisplayName("§6Voyage");
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(" ");
        Lore.add("§7Votre menu de §fvoyage");
        Lore.add("§fCommande§7 : /§6menu §2voyage ");
        Lore.add(" ");
        meta.setLore(Lore);
        is.setItemMeta(meta);
        persistentDataAPI.setPersistentDataItemStack(is, persistentDataAPI.customKey.custom);
        persistentDataAPI.setPersistentDataItemStack(is, persistentDataAPI.customKey.voyage);
        return is;
    }

    public static ItemStack ItemStackShop()
    {
        ItemStack is   = new ItemStack(Material.EMERALD);
        ItemMeta  meta = is.getItemMeta();
        meta.setDisplayName("§6Shop");
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(" ");
        Lore.add("§7Votre menu du §fshop");
        Lore.add("§fCommande§7 : /§2shop ");
        Lore.add("§fCommande§7 : /§2shop ToutVendre");
        Lore.add(" ");
        meta.setLore(Lore);
        is.setItemMeta(meta);
        persistentDataAPI.setPersistentDataItemStack(is, persistentDataAPI.customKey.custom);
        persistentDataAPI.setPersistentDataItemStack(is, persistentDataAPI.customKey.shop);
        return is;
    }

    public static ItemStack ItemStackShopEnchant()
    {
        ItemStack is   = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta  meta = is.getItemMeta();
        meta.setDisplayName("§6Shop d'enchantements");
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(" ");
        Lore.add("§7Votre menu du §fshop d'enchantements");
        Lore.add("§fCommande§7 : /§2enchantements ");
        Lore.add(" ");
        meta.setLore(Lore);
        is.setItemMeta(meta);
        persistentDataAPI.setPersistentDataItemStack(is, persistentDataAPI.customKey.custom);
        persistentDataAPI.setPersistentDataItemStack(is, persistentDataAPI.customKey.enchant);
        return is;
    }

    public static ItemStack ItemStackQuest()
    {
        ItemStack is   = new ItemStack(Material.WRITABLE_BOOK);
        ItemMeta  meta = is.getItemMeta();
        meta.setDisplayName("§6Quêtes");
        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(" ");
        Lore.add("§7Votre menu de §fquêtes");
        Lore.add("§fCommande§7 : /§2quete ");
        Lore.add(" ");
        meta.setLore(Lore);
        is.setItemMeta(meta);
        persistentDataAPI.setPersistentDataItemStack(is, persistentDataAPI.customKey.custom);
        persistentDataAPI.setPersistentDataItemStack(is, persistentDataAPI.customKey.quest);
        return is;
    }
}