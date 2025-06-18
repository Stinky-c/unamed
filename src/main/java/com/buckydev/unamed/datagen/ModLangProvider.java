package com.buckydev.unamed.datagen;

import com.buckydev.unamed.Unamed;
import com.buckydev.unamed.r.AllBlocks;
import com.buckydev.unamed.r.AllItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLangProvider extends LanguageProvider {

    public ModLangProvider(PackOutput output) {
        super(output, Unamed.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addItem(AllItems.EXAMPLE_ITEM, "Example Item");
        this.addBlock(AllBlocks.EXAMPLE_BLOCK, "Example Block");

    }
}
