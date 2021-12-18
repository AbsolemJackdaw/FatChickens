package be.jackdaw.fatchicken.event;

import be.jackdaw.fatchicken.FatChickenMod;
import be.jackdaw.fatchicken.capability.FatCap;
import be.jackdaw.fatchicken.entity.FatChicken;
import be.jackdaw.fatchicken.entity.FatPig;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.StaticTagHelper;
import net.minecraft.tags.StaticTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Pig;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = FatChickenMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AttachEventHandler {
    public static final Tag.Named<EntityType<?>> FATTIES =
            EntityTypeTags.createOptional(new ResourceLocation(FatChickenMod.MODID + ":fatcap"));

    @SubscribeEvent
    public static void onAttach(AttachCapabilitiesEvent<Entity> event) {
        if (FATTIES.contains(event.getObject().getType())) {
            event.addCapability(FatCap.KEY, new FatCap());
        }
    }
}
