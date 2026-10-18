package com.innygr.icreatecore.api;

import java.util.Objects;
import java.util.UUID;

/**
 * Stable, Minecraft-independent representation of the player/team that owns an
 * iCreate object. Consumers should translate their native team/claim data into
 * this value at the integration boundary rather than sharing implementation
 * classes between addons.
 *
 * A null teamId means the owner is not currently associated with a team.
 */
public record OwnerIdentity(UUID ownerId, UUID teamId) {
    public OwnerIdentity {
        Objects.requireNonNull(ownerId, "ownerId");
    }

    public boolean isSameOwner(OwnerIdentity other) {
        return other != null && ownerId.equals(other.ownerId);
    }

    public boolean isSameTeam(OwnerIdentity other) {
        return other != null && teamId != null && teamId.equals(other.teamId);
    }

    /**
     * Default access rule for owner-bound resources: the owner always has
     * access; teammates share access only when both identities have the same
     * non-null team ID. Callers must apply stricter resource-specific rules
     * separately (claims, permissions, public access, etc.).
     */
    public boolean canAccessOwnedResource(OwnerIdentity resourceOwner) {
        return resourceOwner != null
                && (isSameOwner(resourceOwner) || isSameTeam(resourceOwner));
    }
}
