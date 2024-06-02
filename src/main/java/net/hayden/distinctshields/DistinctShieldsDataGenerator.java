package net.hayden.distinctshields;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.hayden.distinctshields.datagen.ModItemTagGenerator;
import net.hayden.distinctshields.datagen.ModLanguageGenerator;
import net.hayden.distinctshields.datagen.ModModelGenerator;
import net.hayden.distinctshields.datagen.ModRecipeGenerator;
import net.hayden.distinctshields.util.ModAtlasesGen;

public class DistinctShieldsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModRecipeGenerator::new);
		pack.addProvider(ModModelGenerator::new);
		pack.addProvider(ModItemTagGenerator::new);
		pack.addProvider(ModLanguageGenerator::new);
		// custom function to generate atlases for each shield (blocks.json)
		ModAtlasesGen.generateBlocksJson();
	}
}
