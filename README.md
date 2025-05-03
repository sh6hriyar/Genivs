# 🎵 Java Music Library Management System(Genivs)

This project is a **simple Java-based music management application** that allows users to register, log in, and interact with music-related data such as artists and songs. It's designed as a desktop application with a basic user interface, backed by serialized `.dat` files for persistent data storage.

## 📁 Project Structure

- `Main.java` - Entry point of the application.
- `Login.java`, `Register.java` - Handle user authentication and registration.
- `Account.java` - Represents user account details.
- `Artist.java`, `Song.java` - Define the data models for music content.
- `ArtistHome.java`, `MemberHome.java` - CLI classes for artist and member home pages.
- `Menu.java` - Shared interface menu for navigating between features.
- `DB.java` - Handles interaction with `.dat` files (pseudo-database).
- `accObj.dat`, `song.dat` - Serialized files for storing user and song data.

## ✅ Features

- User registration and login system
- Distinction between **member** and **artist** roles
- Artist can manage songs
- Members can explore available songs
- Data persistence using object serialization (`*.dat`)

## 🧰 Technologies Used

- **Java SE** (Core Java)
- **Object Serialization** for data storage

## 🗃️ Data Files

- `accObj.dat`: Stores user account information
- `song.dat`: Stores song metadata
- These are updated automatically during registration, login, and song management.

## 📌 Notes

- This project does not use a traditional database; instead, it serializes data to files.
- Basic validation is implemented; however, this is meant for educational/demo purposes.
- Future improvements could include:
  - Transition to a real database (e.g., MySQL)
  - Enhanced GUI with JavaFX
  - Song file management (currently metadata only)

## 📜 License

This project is open for learning purposes. No specific license is applied.