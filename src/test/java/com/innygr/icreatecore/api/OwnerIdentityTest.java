package com.innygr.icreatecore.api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class OwnerIdentityTest {
    @Test
    void ownerCanAccessOwnResource() {
        OwnerIdentity owner = new OwnerIdentity(UUID.randomUUID(), null);
        assertTrue(owner.canAccessOwnedResource(owner));
    }

    @Test
    void teammatesCanAccessSharedResource() {
        UUID team = UUID.randomUUID();
        OwnerIdentity resourceOwner = new OwnerIdentity(UUID.randomUUID(), team);
        OwnerIdentity teammate = new OwnerIdentity(UUID.randomUUID(), team);
        assertTrue(teammate.canAccessOwnedResource(resourceOwner));
    }

    @Test
    void unrelatedPlayersCannotAccessResource() {
        OwnerIdentity resourceOwner = new OwnerIdentity(UUID.randomUUID(), UUID.randomUUID());
        OwnerIdentity stranger = new OwnerIdentity(UUID.randomUUID(), UUID.randomUUID());
        assertFalse(stranger.canAccessOwnedResource(resourceOwner));
    }

    @Test
    void nullTeamDoesNotGrantSharedAccess() {
        OwnerIdentity first = new OwnerIdentity(UUID.randomUUID(), null);
        OwnerIdentity second = new OwnerIdentity(UUID.randomUUID(), null);
        assertFalse(first.canAccessOwnedResource(second));
    }

    @Test
    void nullOwnerIsRejected() {
        assertThrows(NullPointerException.class, () -> new OwnerIdentity(null, null));
    }
}
