

<h1 align="center">DeathDropEraser</h1>
<p align="center">
  <strong>A Spigot plugin for controlling item and XP drops on player death.</strong>
</p>

<p align="center">
  <a href="link_to_releases">
    <img src="https://img.shields.io/github/v/release/Darkxx14/DeathDropEraser?color=blue&label=Release&style=flat-square" alt="Release">
  </a>
  <a href="link_to_license">
    <img src="https://img.shields.io/github/license/Darkxx14/DeathDropEraser?color=blue&label=License&style=flat-square" alt="License">
  </a>
</p>

---

## Overview

DeathDropEraser is a Spigot plugin designed to give server administrators precise control over item and XP drops upon player death. Whether you need to disable drops completely or toggle them dynamically, this plugin provides the flexibility to tailor the experience for your server.

### Features

- **Drop Control**: Easily manage drops on player death.
- **Command-Based**: Intuitive commands for toggling settings.
- **Configuration Options**: Customize settings to suit your server's needs.

## Commands

- `/dde` - Displays commands help.
- `/dde reload` - Reloads the plugin configuration.
- `/dde enable` - Enables item and XP drops on player death.
- `/dde disable` - Disables item and XP drops on player death.

## Permissions

- `dde.admin` - Required to use DeathDropEraser commands.
  - Grants access to `/dde reload`, `/dde enable`, and `/dde disable`.

## Installation

1. Download the plugin JAR file from the [releases page](link_to_releases).
2. Place the JAR file into your server's `plugins` folder.
3. Start or reload your server.

## Configuration

Customize the plugin behavior via the configuration file located at `plugins/DeathDropEraser/config.yml`.

Example configuration:
```yaml
# Configuration for DeathDropEraser
dropsEnabled: true
# Add more configuration options here
