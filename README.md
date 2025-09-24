# Connect Four (Puissance 4)

A **Connect Four** game implemented in **Java** using **Object-Oriented Programming (OOP)** principles.

## 🎯 Objective
Recreate the classic Connect Four game with player management, grid handling, and automatic win detection.

## 🛠️ Technologies
- Java (OOP)
- IDE: IntelliJ / Eclipse

## 🚀 Features
- Two-player mode (turn-based)
- Automatic victory detection (rows, columns, diagonals)
- Dynamic grid management

## 📂 Project Structure
- `Case`, `CaseVide`, `Jaune`, `Rouge` → Token management  
- `Grille` → Game grid management  
- `Partie` → Main game logic  

## ▶️ Run the Project
```bash
# Compile
javac src/*.java -d bin

# Run
java -cp bin Partie
