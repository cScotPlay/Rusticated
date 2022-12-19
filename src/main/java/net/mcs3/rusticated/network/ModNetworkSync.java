package net.mcs3.rusticated.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.network.syncher.EvaporatingSyncS2CPacket;
import net.mcs3.rusticated.network.syncher.FluidSyncS2CPacket;
import net.mcs3.rusticated.network.syncher.FluidSyncS2CPacketAdv;
import net.minecraft.resources.ResourceLocation;

public class ModNetworkSync {

    public static final ResourceLocation FLUID_SYNC = new ResourceLocation(Rusticated.MOD_ID, "fluid_sync");
    public static final ResourceLocation ADV_FLUID_SYNC = new ResourceLocation(Rusticated.MOD_ID, "adv_fluid_sync");
    public static final ResourceLocation EVAPORATING_SYNC = new ResourceLocation(Rusticated.MOD_ID, "evaporating_sync");

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(FLUID_SYNC, FluidSyncS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(ADV_FLUID_SYNC, FluidSyncS2CPacketAdv::receive);
        ClientPlayNetworking.registerGlobalReceiver(EVAPORATING_SYNC, EvaporatingSyncS2CPacket::receive);
    }
}
