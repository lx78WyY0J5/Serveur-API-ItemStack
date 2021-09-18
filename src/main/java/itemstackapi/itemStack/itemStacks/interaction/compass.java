package itemstackapi.itemStack.itemStacks.interaction;

import itemstackapi.itemStack.itemStacks.liste.mainMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class compass implements Listener
{
    public void setCompassInv(Player p)
    {
        //replace by
        //si inventaire contient pas compas (material!)
        //ajouter menu
        //Si contient checker qu'il soit bien avec data tag compass
        ItemStack is = mainMenu.ItemStackCompass();
        if (!p.getInventory().containsAtLeast(is, 1))
        {
            p.getInventory().setItem(17, is);
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
        //replace by
        //si drop contient pas compas (material!) rien faire
        //Si contient checker qu'il soit bien avec data tag compass
        if (e.getDrops().contains(mainMenu.ItemStackCompass()))
        {
            e.getDrops().remove(mainMenu.ItemStackCompass());
        }
    }

    /*public void OpenCompass(Player player) throws IllegalArgumentException, IOException
    {
        Gold      gold = new Gold();
        Inventory Menu = Bukkit.createInventory(null, 9, "§6Menu§f, " + gold.GetGoldFormat(player) + " Gold");
        Menu.addItem(ItemStackIle());
        Menu.addItem(ItemStackShop());
        Menu.addItem(ItemStackShopEnchant());
        Menu.addItem(ItemStackVoyage());
        Menu.addItem(ItemStackQuest());
        player.openInventory(Menu);
    }

    @EventHandler
    public void PlayerClickCompass(InventoryClickEvent e) throws IllegalArgumentException, IOException
    {
        if ((e.getCurrentItem() != null) && (e.getCurrentItem().equals(ItemStackCompass())))
        {
            e.setCancelled(true);
            OpenCompass((Player) e.getWhoClicked());
            if (e.getSlot() != 17)
            {
                e.getWhoClicked().getInventory().setItem(e.getSlot(), new ItemStack(Material.AIR));
                Player player = (Player) e.getWhoClicked();
                player.updateInventory();
            }
        }
    }*/
}