package com.enderdevelopment.plugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BuildingWandListener implements Listener {
    private final Main plugin;
    private final BuildingWand buildingWand;

    public BuildingWandListener(Main plugin, BuildingWand buildingWand) {
        this.plugin = plugin;
        this.buildingWand = buildingWand;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        if (!buildingWand.isBuildingWand(event.getItem())) {
            return;
        }

        Block clickedBlock = event.getClickedBlock();
        if (clickedBlock == null) {
            return;
        }

        // Simple building logic: place a block above the clicked block
        Block targetBlock = clickedBlock.getRelative(0, 1, 0);
        if (targetBlock.getType() == Material.AIR) {
            targetBlock.setType(Material.STONE);
        }
    }
}