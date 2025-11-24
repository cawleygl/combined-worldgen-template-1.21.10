package bluesteel42.combinedworldgen.datagen;

import bluesteel42.combinedworldgen.entity.ModEntities;
import bluesteel42.combinedworldgen.wood.azalea.entity.AzaleaWoodModRafts;
import bluesteel42.combinedworldgen.wood.baobab.entity.BaobabWoodModBoats;
import bluesteel42.combinedworldgen.wood.cholla.entity.ChollaWoodModRafts;
import bluesteel42.combinedworldgen.wood.citrus.entity.CitrusWoodModBoats;
import bluesteel42.combinedworldgen.wood.dogwood.entity.DogwoodWoodModBoats;
import bluesteel42.combinedworldgen.wood.kapok.entity.KapokWoodModBoats;
import bluesteel42.combinedworldgen.wood.maple.entity.MapleWoodModBoats;
import bluesteel42.combinedworldgen.wood.pine.entity.PineWoodModBoats;
import bluesteel42.combinedworldgen.wood.willow.entity.WillowWoodModBoats;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider {
    public ModEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(EntityTypeTags.FALL_DAMAGE_IMMUNE).add(ModEntities.CLUCKSHROOM);

        valueLookupBuilder(EntityTypeTags.BOAT).add(AzaleaWoodModRafts.MOD_RAFT_ENTITY);
        valueLookupBuilder(EntityTypeTags.BOAT).add(BaobabWoodModBoats.MOD_BOAT_ENTITY);
        valueLookupBuilder(EntityTypeTags.BOAT).add(ChollaWoodModRafts.MOD_RAFT_ENTITY);
        valueLookupBuilder(EntityTypeTags.BOAT).add(CitrusWoodModBoats.MOD_BOAT_ENTITY);
        valueLookupBuilder(EntityTypeTags.BOAT).add(DogwoodWoodModBoats.MOD_BOAT_ENTITY);
        valueLookupBuilder(EntityTypeTags.BOAT).add(KapokWoodModBoats.MOD_BOAT_ENTITY);
        valueLookupBuilder(EntityTypeTags.BOAT).add(MapleWoodModBoats.MOD_BOAT_ENTITY);
        valueLookupBuilder(EntityTypeTags.BOAT).add(PineWoodModBoats.MOD_BOAT_ENTITY);
        valueLookupBuilder(EntityTypeTags.BOAT).add(WillowWoodModBoats.MOD_BOAT_ENTITY);
    }
}
