
# RPG Combat System (IFT1025B - W24)

Welcome to the RPG Combat System project! This text-based RPG adventure allows you to create a hero and embark on a quest filled with battles, strategic decisions, and character development. Designed as a university project, it showcases object-oriented programming skills through engaging game mechanics.

## Table of Contents

- [Overview](#overview)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Gameplay](#gameplay)
  - [Quest Phrase Format](#quest-phrase-format)
  - [Sample Quests](#sample-quests)
- [Testing](#testing)
  - [Test Prompts](#test-prompts)
- [License](#license)


## Overview

The RPG Combat System is a simple yet immersive game that puts you in the shoes of a hero navigating through a series of challenges. Whether it's fighting off enemies, healing, or training to become stronger, each decision you make affects the outcome of your quest.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java Development Kit (JDK)

### Installation

1. Clone the repo:
   ```
   git clone https://your-repository-url-here
   ```
2. Compile the Java files:
   ```
   javac Main.java
   ```
3. Run the game:
   ```
   java Main "your quest phrase here"
   ```

## Gameplay

### Quest Phrase Format

Input phrases should be structured as follows:
```
"HeroName,InitialHealth,AttackPoints, action1, action2, ..."
```

### Sample Quests

Embark on various quests by structuring your input phrase according to the hero's journey you wish to experience. Each action taken by the hero, whether battling enemies or resting, will determine the success of their quest.

## Testing

### Test Prompts

Validate your game's logic and functionality using predefined test prompts and compare your results with expected outcomes.

- **Alan's Quest:** `"Alan,200,25, fought 20 enemies, rested, fought 2 enemies, trained to get 69 attack points, fought 2 enemies"` should result in Alan dying after beating 2 enemies at level 1.

More test prompts are available in the documentation to help you ensure the game operates as intended.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.

