package be.jackdaw.fatchicken.event;

import be.jackdaw.fatchicken.FatChickenMod;
import be.jackdaw.fatchicken.capability.FatCap;
import be.jackdaw.fatchicken.tag.Fatties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FatChickenMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AttachEventHandler {

    @SubscribeEvent
    public static void onAttach(AttachCapabilitiesEvent<Entity> event) {
        if (Fatties.hasFatCap(event.getObject().getType())) {
            event.addCapability(FatCap.KEY, new FatCap());
        }
    }
}
