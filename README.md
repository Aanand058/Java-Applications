# Java-Applications

This repository contains a series of Java application workshops, each focusing on different programming concepts and project structures. Below is an overview of each workshop, its main features, and the organization of its source code.

---

## Workshop 1: Musical Instrument App
A console-based application modeling various musical instruments using OOP principles.

**Key Features:**
- Abstract classes for instrument families (Percussion, String, Woodwind)
- Interfaces for playable and fixable behaviors
- Concrete models: Drum, Flute, Guitar, Harp, Xylophone
- MVC structure: controllers, views, models

**Source Structure:**
- `abstracts/`: Abstract base classes for instrument families
- `interfaces/`: Interfaces for instrument behaviors
- `models/`: Concrete instrument classes
- `controllers/`: Main and instrument controller logic
- `views/`: Console view for instrument interaction

---

## Workshop 2: Pizza Ordering App
A JavaFX application for placing pizza orders, demonstrating GUI development and MVC.

**Key Features:**
- JavaFX UI for pizza ordering
- Models for Customer and Order
- Controller for pizza order logic
- FXML-based views and CSS styling

**Source Structure:**
- `application/`: Main app, FXML, and CSS
- `model/`: Customer and Order classes
- `controller/`: PizzaController for UI logic
- `view/`: MainView for the app interface

---

## Workshop 3: Vehicle Loan Calculator App
A JavaFX application to calculate vehicle loans, focusing on user input and financial calculations.

**Key Features:**
- JavaFX UI for loan calculation
- Model for VehicleLoan
- Controller for loan logic
- FXML-based views and CSS styling

**Source Structure:**
- `application/`: Main app and FXML
- `model/`: VehicleLoan class
- `controller/`: VehicleLoanController for UI logic
- `view/`: CarLoan.fxml, VehicleView, and CSS

---

## Workshop 4, 5, 6: Inventory Management App
A comprehensive JavaFX application for managing inventory, parts, and products, with persistent storage and advanced UI.

**Key Features:**
- JavaFX UI for inventory management
- Models for Part, Product, Inventory, InHouse, Outsourced
- Controllers for adding, modifying, and managing parts/products
- FXML-based forms and CSS styling
- Database access (Workshop 5&6)

**Source Structure:**
- `application/`: Main app and CSS
- `model/`: Inventory, Part, Product, InHouse, Outsourced, Example
- `controller/`: Controllers for all forms and main menu
- `views/`: FXML forms for all UI screens
- `database/`: Database access logic (Workshop 5&6)

---

## Tools Used
- **Eclipse IDE**: Primary development environment for all Java projects
- **Scene Builder**: Used for designing JavaFX UI layouts and FXML files
- **MySQL Workbench**: Database design and management for Workshop 5&6
- **Oracle**: Database system used for persistent storage in Workshop 5&6

## How to Run
Each workshop is self-contained. Navigate to the respective `src` folder and compile/run the `Main.java` file. For JavaFX apps, ensure JavaFX is set up in your environment.

---

## License
This repository is for educational purposes.
