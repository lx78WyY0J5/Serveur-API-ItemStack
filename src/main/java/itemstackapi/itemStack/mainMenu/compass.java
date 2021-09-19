package itemstackapi.itemStack.mainMenu;

import itemstackapi.itemStack.api.customItemStack;
import itemstackapi.itemStack.list.mainMenu;
import menu.api.customInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.ArrayList;

public class compass implements Listener
{
    public ArrayList<Integer> listPose()
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

    public boolean playerHasCompass(Player p)
    {
        for (int i : listPose())
        {
            if (customItemStack.hasPersistentDataItemStack(p.getInventory().getItem(i), customItemStack.customKey.compass) && p.getInventory().getItem(i).equals(mainMenu.ItemStackCompass()))
            {
                return true;
            }
        }
        return false;
    }

    public int getPlayerCompassSlot(Player p)
    {
        //return this value by default while no config for this
        return 9;
    }

    public void setCompassInv(Player p)
    {
        if (!playerHasCompass(p))
        {
            p.getInventory().setItem(getPlayerCompassSlot(p), mainMenu.ItemStackCompass());
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

    public static void OpenCompass(Player player) throws IllegalArgumentException, IOException
    {
        //Gold      gold = new Gold();
        //Inventory       Menu            = Bukkit.createInventory(null, 9, "§6Menu" /*+ "§f, " + gold.GetGoldFormat(player) + " Gold"*/);
        customInventory customInventory = new customInventory(menu.api.customInventory.CustomInventoryType.MENU, 9, "§6Menu");
        customInventory.getInventory().addItem(mainMenu.ItemStackIle());
        customInventory.getInventory().addItem(mainMenu.ItemStackShop());
        customInventory.getInventory().addItem(mainMenu.ItemStackShopEnchant());
        customInventory.getInventory().addItem(mainMenu.ItemStackVoyage());
        customInventory.getInventory().addItem(mainMenu.ItemStackQuest());
        player.openInventory(customInventory.getInventory());
    }

    @EventHandler
    public void PlayerClickCompass(InventoryClickEvent e) throws IllegalArgumentException, IOException
    {
        if (e.getCurrentItem() != null)
        {
            if (customItemStack.hasPersistentDataItemStack(e.getCurrentItem(), customItemStack.customKey.compass))
            {
                e.setCancelled(true);
                OpenCompass((Player) e.getWhoClicked());

                if (!e.getCurrentItem().equals(mainMenu.ItemStackCompass()))
                {
                    e.getWhoClicked().getInventory().setItem(e.getSlot(), mainMenu.ItemStackCompass());
                }

                if (!listPose().contains(e.getSlot()))
                {
                    Player p = (Player) e.getWhoClicked();
                    p.getInventory().setItem(e.getSlot(), new ItemStack(Material.AIR));
                    setCompassInv(p);
                    p.updateInventory();
                }
            }
        }
    }
}