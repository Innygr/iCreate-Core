# iCreate: Core

The shared, content-free API and code library for the iCreate mod series.

## Project targets

- Minecraft **1.21.1**
- NeoForge **21.1.251**
- Java **21**
- Mod ID: `icreate_core`
- License: MIT

## Purpose

iCreate: Core is intended to hold stable, reusable infrastructure shared by:

- [iCreate: Order Networking](https://github.com/Innygr/iCreate-Order-Networking)
- [iCreate: Missile Tech](https://github.com/Innygr/iCreate-Missile-Tech)
- [iCreate: Robotics](https://github.com/Innygr/iCreate-Robotics)

Core is a **library/API**, not a content mod. It should not register gameplay blocks, items, recipes, or creative tabs merely to expose shared code.

## Design rules

1. Keep common code safe to load on a dedicated server.
2. Do not introduce dependencies between the three feature mods through Core.
3. Keep third-party integrations optional and isolated behind compatibility checks.
4. Move code into Core only when there is a real shared use case.
5. Version the public API deliberately and document compatibility changes.
6. Keep Core's dependency footprint small; Create-specific helpers should be added only when they can be isolated cleanly.

## Current foundation

- NeoForge mod entry point and metadata
- API version marker (`CoreApiVersion`)
- Java 21 / Gradle build configuration
- GitHub Actions build workflow

This is an initial scaffold, **not yet a complete shared API**. The next step is to review the three mod codebases and migrate genuinely reusable interfaces and utilities, then add tests and verify the build in CI.

## Building

With Java 21 and Gradle 8.14.3 installed:

```sh
gradle build --no-daemon
```

The CI workflow runs the same build on pushes and pull requests to `main`.
