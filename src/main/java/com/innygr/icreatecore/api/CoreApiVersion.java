package com.innygr.icreatecore.api;

/**
 * Version information for the public iCreate Core API.
 *
 * Keep this separate from the mod release version: implementation releases may
 * change without necessarily changing the public API contract.
 */
public final class CoreApiVersion {
    /**
     * Initial API line. Bump deliberately when the public API contract changes.
     */
    public static final String VERSION = "0.1.0";

    private CoreApiVersion() {
    }

    /**
     * Returns whether a consumer's required API line matches this API's major
     * and minor version. This is intentionally conservative until the project
     * adopts a more detailed compatibility policy.
     */
    public static boolean supports(String requiredVersion) {
        if (requiredVersion == null || requiredVersion.isBlank()) {
            return false;
        }

        String[] current = VERSION.split("\\.");
        String[] required = requiredVersion.trim().split("\\.");
        if (current.length < 2 || required.length < 2) {
            return VERSION.equals(requiredVersion.trim());
        }

        return current[0].equals(required[0]) && current[1].equals(required[1]);
    }
}
