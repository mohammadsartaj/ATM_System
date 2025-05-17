# 🏧 ATM System - Java + MySQL + Swing GUI

A secure and user-friendly ATM (Automated Teller Machine) system built using **Java**, **MySQL**, and **Java Swing (JFrames)** for the graphical user interface. This desktop application simulates core ATM functionalities like user authentication, balance inquiry, deposits, withdrawals, and transaction history. 💳💰

---

## 📌 Features

- 🔐 **User Authentication** (Card number + PIN)
- 💵 **Withdraw and Deposit** functionalities
- 📋 **Transaction History** tracking
- 💳 **Balance Inquiry**
- 🖥️ **Modern Swing GUI** using JFrames
- 🗃️ MySQL database backend
- 🧩 Modular and clean Java code structure

---

## 🛠️ Technologies Used

- **Java SE**
- **MySQL** (JDBC)
- **Swing** (JFrames for GUI)
- **NetBeans** or **IntelliJ IDEA** (recommended for development)

---

## 🖼️ GUI Preview

> _Screenshots !!
> ![1](https://github.com/user-attachments/assets/96ed8210-10d9-483e-82ba-f8225d9e8e48)
> ![2](https://github.com/user-attachments/assets/971e384b-4ba9-46ac-b92c-be88af338ec6)
> ![adminLogin](https://github.com/user-attachments/assets/c6093292-b6dd-4af3-95fe-fe090d0439df)
> ![adminMenu](https://github.com/user-attachments/assets/833ac781-443d-46f5-9712-652d00cbc82e)
> ![userLogin](https://github.com/user-attachments/assets/3822bfe1-ef5a-4a42-bb0e-d5ee934fd9ae)
> ![userMenu](https://github.com/user-attachments/assets/c17c5f3a-8496-4747-b21f-4a1c98267350)



---

## 🚀 Getting Started

### 📦 Prerequisites

Make sure you have the following installed:

- Java JDK 8 or higher
- MySQL Server
- A Java IDE (e.g., NetBeans, IntelliJ)
- MySQL JDBC Connector

### 🧰 Setup Instructions

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/atm_system.git
   cd atm_system
2. Set Up the Database:

Create a MySQL database (e.g., atm_db)

Run the SQL script provided in database/atm_schema.sql to create the necessary tables

3. **Configure Database Connection:**

  In your Java project, locate the database connection class and update the credentials:
   ```bash
  String url = "jdbc:mysql://localhost:3306/atm_db";
  String user = "your_mysql_user";
  String password = "your_mysql_password";
```
4. **Run the Application:**
    Compile and run the main class (e.g., Main.java) to launch the application.


   



