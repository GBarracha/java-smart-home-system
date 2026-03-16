# Smart Home Domotics System — Java & JavaFX

This project is a comprehensive **Smart Home** management application developed in **Java**. It was built as the final project for the **Object-Oriented Programming (POO)** course at **Instituto Politécnico de Setúbal (IPS)** to demonstrate advanced OOP architecture, data model separation, and GUI development.

---

## About the Project

The application simulates a central **Domotics Console** used to monitor and control various smart devices across different rooms in a house.

The project was developed in two main phases:

1. **Phase 1 — Core Logic** — A robust backend built using strict OOP principles, including Abstract Classes, Interfaces, Inheritance, Polymorphism, and custom Exception handling.
2. **Phase 2 — GUI Integration** — A dynamic, event-driven interface using **JavaFX**, with a clean separation between visual components and the underlying data model.

---

## Key Features

- **Room & Device Management** — Create, edit, and delete rooms, and dynamically assign smart devices to them.
- **Sensors & Actuators Simulation** — The system models interaction between paired devices:

  | Domain | Sensor | Actuator |
  |---|---|---|
  | 🌡️ Temperature | Thermometer | Air Conditioner |
  | 💡 Light | Light Detector | Light Switch / Bulb |
  | 🚪 Security | Lock Detector | Electric Latch |
  | 🪟 Position | Position Detector | Blind / Shutter |

- **Data Persistence** — Save and load the console's state (rooms and device configuration) using File I/O.
- **Interactive UI** — Custom event handlers, dialog boxes, and image-based nodes for an intuitive user experience.

---

## Architecture & Tech Stack

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/javafx-%23FF0000.svg?style=for-the-badge&logo=java&logoColor=white)

| Tool | Purpose |
|---|---|
| **Java** | Primary language |
| **JavaFX** | GUI framework |
| **MVC-like pattern** | Data model and UI separation |
| **Streams API** | Data sorting and functional-style processing |

**Core OOP concepts applied:** strong encapsulation, polymorphic collections for heterogeneous device management, and interface-driven design.

---

## How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/GBarracha/java-smart-home-system.git
   ```

2. Open the project in your preferred IDE (IntelliJ IDEA or Eclipse recommended).

3. Ensure the **JavaFX SDK** is configured in your project structure.

4. Run the main application class to launch the Domotics Console.

---

## Authors

- **Gonçalo Barracha**
