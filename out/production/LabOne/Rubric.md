# Lab One: Making Change

## Course Details
- **Course**: Object-Oriented Programming with Java
- **Semester**: Spring 2024
- **Instructor**: Jon Baarsch
- **Due Date**: January 23 at Midnight

---

## Task 1: Making Change Application

### Overview
Create an application with the following specifications:
- **Function**: `makeChange(amt: double): Purse`
    - Takes a `double` amount.
    - Returns a `Purse` object containing the amount translated into the fewest possible coins and bills.

### Components

#### Denomination (Record)
- **Fields**:
    - `name: String`: Name of the denomination (e.g., Ten Note, Dime).
    - `amt: double`: Amount of money this denomination represents.
    - `form: String`: Either "bill" or "coin". (Could be an `enum` if familiar.)
    - `img: String`: Name of the image file representing this type of money.

#### Purse (Class)
- **Fields**:
    - `cash: Map<Denomination, Integer>`: Represents the money in the purse.
- **Methods**:
    - `add(type: Denomination, num: int): void`: Adds a specified number of a denomination.
    - `remove(type: Denomination, num: int): double`: Removes a specified number of a denomination and returns the amount.
    - `getValue(): double`: Returns the total amount in the purse.
    - `toString(): String`: Returns a string representation of the purse contents.

#### Register (Class)
- **Methods**:
    - `makeChange(amt: double): Purse`: Returns a `Purse` containing the specified amount in the fewest denominations.
    - `static main(String[] args): void`: Demonstrates the functionality of the `Register`.

---

## Task 2: Creating a GUI

### Overview
Develop a graphical user interface (GUI) for the application.

### Components

#### MakingChange (Class)
- **Description**: Contains the `main` function that creates a `JFrame` and adds a `RegisterPanel`.

#### RegisterPanel (Class, Extends `JPanel`)
- **Fields**:
    - `register: Register`: Object for handling application logic.
    - `inputPanel: JPanel`: Panel containing the text field for user input.
    - `input: JTextField`: Text field for entering the amount.
    - `changePanel: PursePanel`: Panel for displaying the change.
- **Inner Class**: `InputListener (Implements ActionListener)`
    - **Method**:
        - `actionPerformed(ActionEvent e): void`: Logic for processing input changes.

#### PursePanel (Class, Extends `JPanel`)
- **Fields**:
    - `purse: Purse`: Represents the purse contents (initialize as empty).
- **Methods**:
    - `paintComponent(Graphics g): void`: Logic for displaying the purse contents.

---

## Test Cases

### Console Tests

| **Input** | **Expected Output**                                                                 |
|-----------|-------------------------------------------------------------------------------------|
| `0`       | Empty Purse                                                                         |
| `1.25`    | 1 One-Dollar Note, 1 Quarter                                                       |
| `0.00001` | Empty Purse                                                                         |
| `0.005`   | 1 Penny                                                                             |
| `-5.45`   | Empty Purse                                                                         |
| `69.89`   | 1 Fifty-Dollar Note, 1 Ten-Dollar Note, 1 Five-Dollar Note, 4 One-Dollar Notes, 3 Quarters, 1 Dime, 4 Pennies |

### GUI Tests

| **Input** | **Expected Output**                                                                 |
|-----------|-------------------------------------------------------------------------------------|
| `0`       | Nothing                                                                             |
| `1.25`    | 1 one-dollar bill image, 1 quarter image                                           |
| `0.00001` | Nothing                                                                             |
| `0.005`   | 1 penny image                                                                      |
| `-5.54`   | Nothing                                                                             |
| `69.89`   | 1 fifty-dollar note image, 1 ten-dollar note image, 1 five-dollar note image, 4 one-dollar note images (stacked), 3 quarter images, 1 dime image, 4 penny images |

*Note*: Plurals in string representations are optional for this assignment.
