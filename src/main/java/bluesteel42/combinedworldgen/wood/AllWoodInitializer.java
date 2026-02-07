package bluesteel42.combinedworldgen.wood;

import bluesteel42.combinedworldgen.wood.azalea.AzaleaWoodInitializer;
import bluesteel42.combinedworldgen.wood.baobab.BaobabWoodInitializer;
import bluesteel42.combinedworldgen.wood.cholla.ChollaWoodInitializer;
import bluesteel42.combinedworldgen.wood.chorus.ChorusWoodInitializer;
import bluesteel42.combinedworldgen.wood.citrus.CitrusWoodInitializer;
import bluesteel42.combinedworldgen.wood.dogwood.DogwoodWoodInitializer;
import bluesteel42.combinedworldgen.wood.kapok.KapokWoodInitializer;
import bluesteel42.combinedworldgen.wood.maple.MapleWoodInitializer;
import bluesteel42.combinedworldgen.wood.petrified.PetrifiedWoodInitializer;
import bluesteel42.combinedworldgen.wood.pine.PineWoodInitializer;
import bluesteel42.combinedworldgen.wood.willow.WillowWoodInitializer;

public class AllWoodInitializer {

    public static void initalizeWoodTypes() {
        MapleWoodInitializer.initializeWood();
        PineWoodInitializer.initializeWood();
        KapokWoodInitializer.initializeWood();
        CitrusWoodInitializer.initializeWood();
        BaobabWoodInitializer.initializeWood();
        WillowWoodInitializer.initializeWood();
        DogwoodWoodInitializer.initializeWood();
        ChollaWoodInitializer.initializeWood();
        AzaleaWoodInitializer.initializeWood();
        ChorusWoodInitializer.initializeWood();
        PetrifiedWoodInitializer.initializeWood();
    }

    public static void initializeWoodTypesClient() {
        MapleWoodInitializer.initializeWoodClient();
        PineWoodInitializer.initializeWoodClient();
        KapokWoodInitializer.initializeWoodClient();
        CitrusWoodInitializer.initializeWoodClient();
        BaobabWoodInitializer.initializeWoodClient();
        WillowWoodInitializer.initializeWoodClient();
        DogwoodWoodInitializer.initializeWoodClient();
        ChollaWoodInitializer.initializeWoodClient();
        AzaleaWoodInitializer.initializeWoodClient();
        ChorusWoodInitializer.initializeWoodClient();
        PetrifiedWoodInitializer.initializeWoodClient();
    }
}
