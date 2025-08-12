# 🕹️ Hangman Game in Java

<a href="https://github.com/Caroline-Teixeira/hangman_game/blob/main/README.md"><img src="https://raw.githubusercontent.com/yammadev/flag-icons/refs/heads/master/png/BR%402x.png" alt="Portuguese" ></a>


![Made with Java](https://img.shields.io/badge/Made%20with-Java-orange?style=for-the-badge&logo=java)

## 📖 Description

This **Hangman Game** is a console application developed in **Java 21**, inspired by the classic word guessing game. The user chooses a topic (e.g., house, programming, food), tries to guess the word letter by letter, and visualizes progress with an interactive console interface that displays the gallows, hidden word, remaining attempts, and used letters. The project follows a layered architecture (Model, Service, View, Util, Exception) for organization and maintainability.

## 🎯 Features

- ✅ Start a new game with topic selection
- ✅ Input a letter to reveal parts of the word
- ✅ Display current game state (gallows, hidden word, attempts, used letters)
- ✅ Input validation (e.g., only valid letters, existing topics)
- ✅ Topic suggestions when an invalid topic is entered
- ✅ Display colored messages in console for feedback (success, error, warning, information)
- ✅ Console interface with interactive menus in Sudoku style

## 📂 Project Structure

```
.
├── src/
│   ├── br/com/hangman/
│   │   ├── exception/
│   │   │   ├── GameIsFinishedException.java
│   │   │   └── LetterAlreadyInputtedException.java
│   │   ├── model/
│   │   │   ├── GameBoard.java
│   │   │   ├── GameStatus.java
│   │   │   └── HangmanChar.java
│   │   ├── service/
│   │   │   └── GameBoardService.java
│   │   ├── util/
│   │   │   ├── AnsiColors.java
│   │   │   ├── ConsolePrinter.java
│   │   │   ├── HangmanDisplay.java
│   │   │   └── WordSelector.java
│   │   ├── view/
│   │   │   └── Menu.java
│   │   └── Main.java
└── README.md
```

## 🚀 How to Run

### 🖥️ Via IDE
1. Import the project into your IDE (e.g., IntelliJ IDEA, Eclipse).
2. Make sure **Java 21** or higher is configured.
3. Run the `Main.java` class located in `br.com.hangman`.

### 🖥️ Via Terminal
1. Clone the repository and compile/execute with the commands below.
2. Make sure **Java 21** or higher is installed.

### Prerequisites:
- **Java 21** or higher installed

### Clone the repository:
```bash
git clone https://github.com/[your-username]/[your-repository].git
```

### Navigate to the directory:
```bash
cd [your-repository]
```

### Compile and run:
```bash
javac src/br/com/hangman/*.java src/br/com/hangman/*/*.java
java -cp src br.com.hangman.Main
```

## 🛠️ Technologies Used

- **Java 21**

## 📖 Explanation of Main Classes and Packages

**Packages**
- `exception` → Custom exceptions (`GameIsFinishedException`, `LetterAlreadyInputtedException`) for specific error handling.
- `model` → Classes that represent game logic (`GameBoard`, `HangmanChar`, `GameStatus`).
- `service` → Business logic to manage game state (`GameBoardService`).
- `util` → Utility classes for gallows display, console formatting, and word selection (`HangmanDisplay`, `ConsolePrinter`, `AnsiColors`, `WordSelector`).
- `view` → Console-based user interface with interactive menus (`Menu`).

**Main Classes**
- `Main` → Application entry point, initializes the menu.
- `Menu` → Main console interface, manages user interaction with numbered options (start game, input letter, display state, exit).
- `GameBoardService` → Manages game logic, such as word initialization, letter processing, and status updates.
- `GameBoard` → Represents game attributes (word, used letters, remaining attempts, status).
- `HangmanChar` → Represents word attributes with visibility control.
- `GameStatus` → Enum for game states (INCOMPLETE, WON, LOST).
- `WordSelector` → Selects random words based on chosen topic, with valid topic suggestions.
- `HangmanDisplay` → Displays graphical gallows based on number of errors.
- `ConsolePrinter` → Utility for formatted printing with colors in console.
- `AnsiColors` → Constants for console color formatting.

## 📌 Tips to Improve or Expand

- 🖥️ Implement a graphical interface with JavaFX or Swing to replace the console.
- 📚 Load words from an external file or database in `WordSelector`.
- 🎮 Add difficulty levels (e.g., longer words or fewer attempts).
- 📊 Include scoring based on remaining attempts.
- 🔍 Improve topic suggestion system.
- 🧪 Add unit tests with JUnit to validate `GameBoardService` and `WordSelector`.
- 📱 Create a version with REST API for integration with web or mobile frontends.

## 📄 License

This project is under the [MIT](LICENSE) license.

## 👨‍💻 Author

<a href="https://github.com/Caroline-Teixeira">Caroline 💙</a>

---

📌 *Project developed for the DIO (Digital Innovation One) challenge.*
