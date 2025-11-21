package bluesteel42.combinedworldgen.world.tree;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.azalea.tree.AzaleaTrunkPlacer;
import bluesteel42.combinedworldgen.wood.maple.tree.ShortMapleTreeFoliagePlacer;
import bluesteel42.combinedworldgen.wood.maple.tree.TallMapleTreeFoliagePlacer;
import bluesteel42.combinedworldgen.wood.willow.tree.WillowTrunkPlacer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTreeBuilders {
    public static final FoliagePlacerType<TallMapleTreeFoliagePlacer> TALL_MAPLE_TREE_FOLIAGE_PLACER =
            Registry.register(
                    Registries.FOLIAGE_PLACER_TYPE,
                    Identifier.of(CombinedWorldgen.MOD_ID, "tall_maple_tree_foliage_placer"),
                    new FoliagePlacerType<>(TallMapleTreeFoliagePlacer.CODEC)
            );
    public static final FoliagePlacerType<ShortMapleTreeFoliagePlacer> SHORT_MAPLE_TREE_FOLIAGE_PLACER =
            Registry.register(
                    Registries.FOLIAGE_PLACER_TYPE,
                    Identifier.of(CombinedWorldgen.MOD_ID, "short_maple_tree_foliage_placer"),
                    new FoliagePlacerType<>(ShortMapleTreeFoliagePlacer.CODEC)
            );
    public static final TrunkPlacerType<NotchedTrunkPlacer> NOTCHED_TRUNK_PLACER =
            Registry.register(
                    Registries.TRUNK_PLACER_TYPE,
                    Identifier.of(CombinedWorldgen.MOD_ID, "notched_trunk_placer"),
                    new TrunkPlacerType<>(NotchedTrunkPlacer.CODEC)
            );
    public static final TrunkPlacerType<WillowTrunkPlacer> WILLOW_TRUNK_PLACER =
            Registry.register(
                    Registries.TRUNK_PLACER_TYPE,
                    Identifier.of(CombinedWorldgen.MOD_ID, "willow_trunk_placer"),
                    new TrunkPlacerType<>(WillowTrunkPlacer.CODEC)
            );
    public static final TrunkPlacerType<AzaleaTrunkPlacer> AZALEA_TRUNK_PLACER =
            Registry.register(
                    Registries.TRUNK_PLACER_TYPE,
                    Identifier.of(CombinedWorldgen.MOD_ID, "azalea_trunk_placer"),
                    new TrunkPlacerType<>(AzaleaTrunkPlacer.CODEC)
            );
    public static final TreeDecoratorType<NotchedTrunkBeehiveTreeDecorator> NOTCHED_TRUNK_BEEHIVE_TREE_DECORATOR =
            Registry.register(
                    Registries.TREE_DECORATOR_TYPE,
                    Identifier.of(CombinedWorldgen.MOD_ID, "notched_trunk_beehive_tree_decorator"),
                    new TreeDecoratorType<>(NotchedTrunkBeehiveTreeDecorator.CODEC)
            );
    public static final TreeDecoratorType<HangingMushroomTreeDecorator> HANGING_MUSHROOM_TREE_DECORATOR =
            Registry.register(
                    Registries.TREE_DECORATOR_TYPE,
                    Identifier.of(CombinedWorldgen.MOD_ID, "hanging_mushroom_tree_decorator"),
                    new TreeDecoratorType<>(HangingMushroomTreeDecorator.CODEC)
            );

    public static void initialize() {

    }
}
