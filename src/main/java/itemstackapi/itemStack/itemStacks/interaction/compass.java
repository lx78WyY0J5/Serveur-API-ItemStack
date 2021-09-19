package itemstackapi.itemStack.itemStacks.interaction;

import itemstackapi.itemStack.api.customItemStack;
import itemstackapi.itemStack.itemStacks.liste.mainMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.ArrayList;

public class compass implements Listener
{
    public static ArrayList<Integer> listPose()
    {
        ArrayList<Integer> listPose = new ArrayList<>();
        listPose.add(9);
        listPose.add(17);
        listPose.add(27);
        listPose.add(35);
        listPose.add(36);
        listPose.add(44);
        return listPose;
    }

    public void setCompassInv(Player p)
    {
        if (!p.getInventory().containsAtLeast(mainMenu.ItemStackCompass(), 1))
        {
            p.getInventory().setItem(17, mainMenu.ItemStackCompass());
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        setCompassInv(e.getPlayer());
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e)
    {
        setCompassInv(e.getPlayer());
    }

    @EventHandler
    public void CompassDrop(PlayerDeathEvent e) throws IOException
    {
        if (e.getDrops().contains(mainMenu.ItemStackCompass()))
        {
            e.getDrops().remove(mainMenu.ItemStackCompass());
        }
    }

    public void OpenCompass(Player player) throws IllegalArgumentException, IOException
    {
        //Gold      gold = new Gold();
        Inventory Menu = Bukkit.createInventory(null, 9, "§6Menu" /*+ "§f, " + gold.GetGoldFormat(player) + " Gold"*/);
        Menu.addItem(mainMenu.ItemStackIle());
        Menu.addItem(mainMenu.ItemStackShop());
        Menu.addItem(mainMenu.ItemStackShopEnchant());
        Menu.addItem(mainMenu.ItemStackVoyage());
        Menu.addItem(mainMenu.ItemStackQuest());
        player.openInventory(Menu);
    }

    @EventHandler
    public void PlayerClickCompass(InventoryClickEvent e) throws IllegalArgumentException, IOException
    {
        if (e.getCurrentItem() != null)
        {
            if (customItemStack.hasPersistentDataItemStack(e.getCurrentItem(), customItemStack.customKey.compass))
            {
                e.setCancelled(true);
                // OpenCompass((Player) e.getWhoClicked());
                if (!e.getCurrentItem().equals(mainMenu.ItemStackCompass()))
                {
                    //set itemClicked to normal/new itemStack
                }
                if (!listPose().contains(e.getSlot()))
                {
                    Player p = (Player) e.getWhoClicked();
                    p.getInventory().setItem(e.getSlot(), new ItemStack(Material.AIR));
                    p.updateInventory();
                    setCompassInv(p);
                }
            }
        }
    }
}