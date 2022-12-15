package net.mcs3.elixiremporium.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.network.syncher.FluidSyncS2CPacket;
import net.mcs3.elixiremporium.network.syncher.FluidSyncS2CPacketAdv;
import net.minecraft.resources.ResourceLocation;

public class ModNetworkSync {

    public static final ResourceLocation FLUID_SYNC = new ResourceLocation(ElixirEmporium.MOD_ID, "fluid_sync");
    public static final ResourceLocation ADV_FLUID_SYNC = new ResourceLocation(ElixirEmporium.MOD_ID, "adv_fluid_sync");

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(FLUID_SYNC, FluidSyncS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(ADV_FLUID_SYNC, FluidSyncS2CPacketAdv::receive);
    }
}
