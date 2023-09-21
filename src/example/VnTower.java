package example;

import arc.struct.Seq;
import mindustry.content.Blocks;
import mindustry.gen.Building;
import mindustry.world.Block;
import mindustry.world.Tile;

/**
 * VnTower
 */
public class VnTower {

    public static boolean isPatch(Tile tile) {
        return tile.floor() == Blocks.coreZone || tile.floor() == Blocks.stone || tile.floor() == Blocks.darkPanel5
                || tile.floor() == Blocks.darkPanel6;
    }

    public static boolean canBePlace(Tile tile, Block block) {
        return !tile.getLinkedTilesAs(block, new Seq<>()).contains(VnTower::isPatch);
    }
}
