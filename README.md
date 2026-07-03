# DSOBuildSim

Full-stack application for simulating and calculating complex, rule-based character statistics.

The system consists of a Spring Boot backend that handles the core calculation logic and a planned Angular frontend for interactive configuration and visualization.

The application is inspired by the MMORPG Drakensang Online and allows users to experiment with different equipment and build configurations.

**Technologies:** Java, Spring Boot, REST API, Angular (in progress)

---

## Features

- REST API for calculating character stats based on complex dependencies  
- Rule-based processing of multiple entity types  
- Automatic handling of interactions (e.g. set bonuses, modifiers)  
- Modular stat calculation engine  

**Domain entities include:**
- Items (unique, mythic, sets)  
- Enhancements (gems, runes, jewels)  
- Additional modifiers (pets, buffs, essences)  

---

## Architecture

The project follows a **backend + frontend architecture**.

```
DSOBuildSim
├── backend   # Spring Boot REST API
└── frontend  # Angular web application (planned)
```

### Backend Architecture

The backend follows a layered architecture:

- **Controller layer** (REST endpoints)  
- **Service layer** (business logic)  
- **Domain model** (entities and rule system)  

The stat calculation is implemented as a modular system where different components contribute to the final result.

### Backend Tech Stack

- Java  
- Spring Boot  
- REST API  
- JSON-based data definitions  

### Frontend (planned)

- Angular  
- Communication via REST API  

---

## How It Works

1. The frontend requests game data definitions from the backend  
2. The user selects items, enhancements and modifiers  
3. The frontend sends the configuration to the backend  
4. The backend calculates and returns the resulting stats  

---

## API Overview

### Get Game Data

```
GET /api/game-data
```

Returns all available definitions (items, gems, runes, pets, etc.).

---

### Calculate Character Stats

```
POST /api/stats/calculate
```

Calculates final character stats based on the provided configuration.

### Example Request

```json
{
  "characterClass": "SPELLWEAVER",
  "items": {
    "BOOTS": {
      "itemType": "WINTER_BOOTS",
      "level": 145,
      "gems": [
        { "gemType": "ONYX", "tier": 17 }
      ]
    }
  },
  "pet": {
    "petType": "DRAGON_CAT",
    "tier": 5
  }
}
```

Note: The actual request structure is significantly more complex and includes many additional systems (e.g. runes, jewels, buffs, skill trees). The example above is simplified for readability.

### Example Response

```json
{
  "stats": {
    "DAMAGE": 1504828.10,
    "CRIT_VALUE": 401796.79,
    "ATTACK_SPEED": 4.46,
    "HEALTH_POINTS": 4463101.28,
    "ARMOR_VALUE": 48945.96,
    "BLOCK_VALUE": 319956.94,
    "MOVEMENT_SPEED": 13.13
  }
}
```

Note: The actual response includes more stats. The example above is simplified for readability.

---

## Testing

- Unit tests for core calculation logic  
- Focus on correctness of stat computation and rule interactions  

---

## Running the Project

### Backend

**Requirements:**
- Java 17+
- Maven  

**Run:**
```
mvn spring-boot:run
```

The REST API will start locally.

---

### Frontend (planned)

**Requirements:**
- Node.js  
- Angular CLI  

**Run:**
```
npm install
ng serve
```

---

## Purpose

This project was developed to practice building structured backend systems with non-trivial business logic and to improve skills in API design and clean architecture.

Additionally, it can be used as a tool for experimenting with different character configurations.

---

## Roadmap

- Angular frontend  
- Item filtering  
- Build import/export  
- Build sharing  
- Detailed stat breakdown  
- Support for additional systems  

---

## License

This project is licensed under the MIT License.

---

## Disclaimer

This project is a fan-made tool and is not affiliated with or endorsed by Bigpoint or Drakensang Online.
