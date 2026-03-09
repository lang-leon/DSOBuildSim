# DSOBuildSim

A build simulator for the MMORPG **Drakensang Online** that allows
players to test different equipment and build combinations and see the
resulting character stats.

The application consists of a **Java Spring Boot backend** that performs
stat calculations and a planned **Angular frontend** that provides an
interactive web interface.

------------------------------------------------------------------------

## Features

The simulator calculates character stats based on multiple game systems
from **Drakensang Online**.

### Equipment

-   Unique items
-   Mythic items
-   Set items
-   Soul companion system items
-   Automatic **set bonus application**

### Enhancements

-   Gems (socketed in items)
-   Runes
-   Jewels
-   Dragonstones

### Other Systems

-   Pets
-   Essences
-   Buffs
    -   Tonics
    -   Physics

Players can freely combine equipment and enhancements to see the **final
calculated character stats** for their character.

------------------------------------------------------------------------

## Architecture

The project follows a **backend + frontend architecture**.

    DSOBuildSim
    ├── backend   # Spring Boot REST API
    └── frontend  # Angular web application (planned)

### Backend

-   Java
-   Spring Boot
-   REST API
-   JSON-based game data definitions
-   Stat calculation engine

### Frontend

-   Angular
-   Communicates with the backend via REST
-   UI for selecting equipment and build components

------------------------------------------------------------------------

## How It Works

1.  The frontend requests **game data definitions** from the backend.
2.  The user selects items, gems, runes, jewels, pets, buffs, etc.
3.  The frontend sends the character configuration to the backend.
4.  The backend calculates the resulting stats and returns them.

------------------------------------------------------------------------

## API Overview

### Get Game Data

    GET /api/game-data

Returns all available game definitions including:

-   items
-   sets
-   jewels
-   gems
-   runes
-   dragonstones
-   pets
-   essences
-   buffs

------------------------------------------------------------------------

### Calculate Character Stats

    POST /api/calculate-stats

Input: character configuration\
Output: calculated character stats

Example request (not finalized):

``` json
{
  "class": "SPELLWEAVER",
  "items": [],
  "runeTrinkets": [],
  "jewelTrinkets": [],
  "dragonCrestTrinket": [],
  "pet": "DRAGON_CAT",
  "essence": "RED",
  "tonic": "POWER_TONIC",
  "physic": "PHYSIC_OF_POWER"
}
```

------------------------------------------------------------------------

## Running the Project

### Backend

Requirements:

-   Java 17+
-   Maven

Run the backend:

    mvn spring-boot:run

The REST API will start locally.

------------------------------------------------------------------------

### Frontend (planned)

Requirements:

-   Node.js
-   Angular CLI

Run the frontend:

    npm install
    ng serve

------------------------------------------------------------------------

## Project Goals

This project serves both as:

-   a **learning project for modern full-stack development**
-   a **tool for the Drakensang Online community** to experiment with
    builds and equipment combinations

------------------------------------------------------------------------

## Roadmap

Planned improvements include:

-   Full Angular frontend
-   Item filtering by slot and class
-   Build import/export
-   Build sharing
-   Detailed stat breakdown
-   Support for additional game systems

------------------------------------------------------------------------

## License

This project is licensed under the **MIT License**.

------------------------------------------------------------------------

## Disclaimer

This project is a **fan-made tool** and is not affiliated with or
endorsed by **Bigpoint** or **Drakensang Online**.
