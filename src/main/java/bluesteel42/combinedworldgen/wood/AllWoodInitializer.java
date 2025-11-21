package bluesteel42.combinedworldgen.wood;

import bluesteel42.combinedworldgen.wood.azalea.AzaleaWoodInitializer;
import bluesteel42.combinedworldgen.wood.baobab.BaobabWoodInitializer;
import bluesteel42.combinedworldgen.wood.cholla.ChollaWoodInitializer;
import bluesteel42.combinedworldgen.wood.citrus.CitrusWoodInitializer;
import bluesteel42.combinedworldgen.wood.dogwood.DogwoodWoodInitializer;
import bluesteel42.combinedworldgen.wood.kapok.KapokWoodInitializer;
import bluesteel42.combinedworldgen.wood.maple.MapleWoodInitializer;
import bluesteel42.combinedworldgen.wood.petrified.PetrifiedWoodInitializer;
import bluesteel42.combinedworldgen.wood.pine.PineWoodInitializer;
import bluesteel42.combinedworldgen.wood.willow.WillowWoodInitializer;

public class AllWoodInitializer {

    public static void initalizeWoodTypes() {
        AzaleaWoodInitializer.initializeWood();
        BaobabWoodInitializer.initializeWood();
        ChollaWoodInitializer.initializeWood();
        CitrusWoodInitializer.initializeWood();
        DogwoodWoodInitializer.initializeWood();
        KapokWoodInitializer.initializeWood();
        MapleWoodInitializer.initializeWood();
        PetrifiedWoodInitializer.initializeWood();
        PineWoodInitializer.initializeWood();
        WillowWoodInitializer.initializeWood();
    }

    public static void initializeWoodTypesClient() {
        AzaleaWoodInitializer.initializeWoodClient();
        BaobabWoodInitializer.initializeWoodClient();
        ChollaWoodInitializer.initializeWoodClient();
        CitrusWoodInitializer.initializeWoodClient();
        DogwoodWoodInitializer.initializeWoodClient();
        KapokWoodInitializer.initializeWoodClient();
        MapleWoodInitializer.initializeWoodClient();
        PetrifiedWoodInitializer.initializeWoodClient();
        PineWoodInitializer.initializeWoodClient();
        WillowWoodInitializer.initializeWoodClient();
    }
}
