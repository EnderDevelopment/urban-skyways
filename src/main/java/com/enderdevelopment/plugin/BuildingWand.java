package com.enderdevelopment.plugin;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class BuildingWand {
    private final Main plugin;
    private final NamespacedKey wandKey;

    public BuildingWand(Main plugin) {
        this.plugin = plugin;
        this.wandKey = new NamespacedKey(plugin, "building_wand");
    }

    public ItemStack createWand() {
        ItemStack wand = new ItemStack(Material.STICK);
        ItemMeta meta = wand.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("Building Wand");
            meta.getPersistentDataContainer().set(wandKey, PersistentDataType.BYTE, (byte) 1);
            wand.setItemMeta(meta);
        }
        return wand;
    }

    public boolean isBuildingWand(ItemStack item) {
        if (item == null || item.getType() != Material.STICK) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        if (meta == null) {
            return false;
        }
        Byte value = meta.getPersistentDataContainer().get(wandKey, PersistentDataType.BYTE);
        return value != null && value == 1;
    }
}