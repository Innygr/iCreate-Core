# iCreate: Core

The shared, content-free API and code library for the iCreate mod series.

## Compatibility

- Minecraft **1.21.1**
- NeoForge **21.1.251**
- Java **21**
- Mod ID: `icreate_core`
- License: MIT
- Current mod version: `0.1.0-alpha`
- Current API line: `0.1.x`

## Purpose

Core is intended to hold stable, reusable infrastructure shared by:
- [iCreate: Order Networking](https://github.com/Innygr/iCreate-Order-Networking)
- [iCreate: Missile Tech](https://github.com/Innygr/iCreate-Missile-Tech)
- [iCreate: Robotics](https://github.com/Innygr/iCreate-Robotics)

Core is a **library/API**, not a content mod. It should not register gameplay blocks, items, recipes, or creative tabs merely to expose shared code.

## Public API

- `CoreApiVersion`: API-line compatibility helper.
- `OwnerIdentity`: immutable player/team identity with explicit owner and same-team access helpers. A missing team ID never grants team-shared access.

These are small primitives, not a replacement for Minecraft permissions, FTB Teams, claims, or each resource's own authorization rules. Addons should adapt their own identity data at their integration boundary. Keep API changes deliberate and covered by tests.

## Design rules

1. Keep common code safe to load on a dedicated server.
2. Do not introduce dependencies between the three feature mods through Core.
3. Keep third-party integrations optional and isolated behind compatibility checks.
4. Move code into Core only when there is a real shared use case.
5. Version the public API deliberately and document compatibility changes.
6. Keep Core's dependency footprint small; Create-specific helpers belong in optional integration layers.

## Build and artifacts

With Java 21 and Gradle 8.14.3:

```sh
gradle build --no-daemon
```

GitHub Actions builds on pushes and pull requests and uploads the JAR as a short-lived workflow artifact. That artifact is for development testing, not a stable Modrinth release. Core is still an early alpha library; consumer addons should not require it until a matching Core release is published and tested.

## Alpha limitations

- API surface is intentionally small and may change.
- No in-game content is added.
- A successful CI build is not a substitute for client and dedicated-server smoke tests.

## License

MIT. See [LICENSE](LICENSE).
