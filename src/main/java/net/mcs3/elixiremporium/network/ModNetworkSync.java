package net.mcs3.elixiremporium.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.impl.screenhandler.client.ClientNetworking;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.network.syncher.FluidSyncS2CPacket;
import net.minecraft.resources.ResourceLocation;

public class ModNetworkSync {

    public static final ResourceLocation FLUID_SYNC = new ResourceLocation(ElixirEmporium.MOD_ID, "fluid_sync");

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(FLUID_SYNC, FluidSyncS2CPacket::receive);
    }
}
