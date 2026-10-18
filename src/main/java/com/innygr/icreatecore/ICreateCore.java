package com.innygr.icreatecore;

import com.innygr.icreatecore.api.CoreApiVersion;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bootstrap for the shared iCreate library.
 *
 * Keep this entry point free of client-only references so the library can load
 * on dedicated servers.
 */
@Mod(ICreateCore.MOD_ID)
public final class ICreateCore {
    public static final String MOD_ID = "icreate_core";
    private static final Logger LOGGER = LoggerFactory.getLogger(ICreateCore.class);

    public ICreateCore() {
        LOGGER.info("Initializing iCreate: Core API {}", CoreApiVersion.VERSION);
    }
}
