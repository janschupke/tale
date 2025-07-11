# Tale #

A tale of a yellow wanderer who finds himself in a forest. He is very yellow. The trees are tiny. Nothing makes sense.

## System Requirements

- **Java**: JDK 11 or higher
- **Memory**: Minimum 2GB RAM
- **Graphics**: OpenGL 2.0 compatible graphics card
- **Storage**: 100MB available space

## Installation

### Prerequisites

1. **Install Java Development Kit (JDK)**
   - Download and install JDK 11 or higher from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://adoptium.net/)
   - Verify installation: `java -version`

2. **Install Gradle (Optional)**
   - The project includes Gradle Wrapper, so Gradle installation is not required
   - If you prefer to install Gradle globally: `brew install gradle` (macOS) or download from [gradle.org](https://gradle.org/install/)

### Building from Source

1. **Clone the Repository**
   ```bash
   git clone https://github.com/janschupke/tale.git
   cd tale
   ```

2. **Build the Project**
   ```bash
   # Using Gradle Wrapper (recommended)
   ./gradlew build
   
   # Or with global Gradle installation
   gradle build
   ```

## Running the Game

### Desktop Version

1. **Run the Game**
   ```bash
   # Using Gradle Wrapper
   ./gradlew desktop:run
   
   # Or with global Gradle
   gradle desktop:run
   ```

2. **Create Executable JAR**
   ```bash
   ./gradlew desktop:dist
   ```
   The executable JAR will be created in `desktop/build/libs/`

### Controls

- **Movement**: WASD or Arrow Keys
- **Interact**: Space or Enter
- **Menu**: Escape
- **Message Log**: E
- **Quest Log**: Q
- **Inventory**: I
- **Hint Dialogs**: H
- **Pause**: P

### Game Controls

- **Menu Navigation**: Use mouse or keyboard
- **Dialog Interaction**: Click or press Enter
- **Inventory Management**: Click items to view details
- **Quest Tracking**: View active and completed quests

## Development

### Project Structure

```
tale/
├── core/                   # Main game logic
│   ├── assets/             # Game resources
│   │   ├── audio/          # Sound effects and music
│   │   ├── fonts/          # Font files
│   │   ├── languages/      # Localization files
│   │   ├── maps/           # Level maps
│   │   ├── skins/          # UI skins
│   │   └── textures/       # Graphics and sprites
│   └── src/                # Source code
├── desktop/                # Desktop platform code
└── test/                   # Test files
```

### Building for Development

```bash
# Clean build
./gradlew clean build

# Run tests
./gradlew test

# Generate documentation
./gradlew javadoc
```

## Troubleshooting

### Common Issues

**"Gradle not found"**
- Use the included Gradle Wrapper: `./gradlew` instead of `gradle`

**"Java version incompatible"**
- Ensure JDK 11+ is installed and JAVA_HOME is set correctly

## Credits

- **Programming**: Jan Schupke
- **Game Design**: Jan Schupke
- **Soundtrack**: Jan Schupke
- **Graphics**: opengameart.org
- **Voice Acting**: affordableaudio4everyone.com
- **Text Inspirations**: fantasynamegenerators.com
