# Lab One

**Course**: CSCI 3381

**Professor**: Jon Baarsch

**Student**: Jewell Callahan

---

# Making Change

[x] Create a function called makeChange <br>
[x] Param **double** amount <br>
[x] Return **Purse** object <br>
&nbsp; &nbsp; [x] _amount_ is translated into
 fewest possible coins and bills <br>
<br>

## [x] Currency [Denomination]

[x] name: String (e.g. Ten note, Dime)<br>
[x] amt: double (0.05, 1.09) <br>
[x] form: String (bill, coin) <br>
[x] img: String (img file) <br>

## [ ] Purse (Class)

[x] cash: Map<Denomination, Integer>
     represents the money in the purse <br>

### Functions 

[x] add(type: Denomination, num: int): void<br>
&nbsp; &nbsp; [x] param **Denomination** & **int** num <br>
&nbsp; &nbsp; [x] return void <br>

[x] remove(type: Denomination, num: int): double <br>
&nbsp; &nbsp; [x] param: **Denomination** & **int** num <br>
&nbsp; &nbsp; [x] return: Amount current <br>

[x] getValue(): double <br>
&nbsp; &nbsp; [x] param  null <br>
&nbsp; &nbsp; [x] return total amount in purse <br>

[x] toString(): string <br>
&nbsp; &nbsp; [x] param null <br>
&nbsp; &nbsp; [x] return string representation of 
    amount total <br>

## [x] Register(Class)

### Functions

[x] makeChange(amt:double): Purse: <br>
&nbsp; &nbsp; [x] param **double** amount <br>
&nbsp; &nbsp; [x] return *Purse* <br>

---

# Create a GUI

## [ ] MakingChange(Class)

[ ] Contains **main** <br>
&nbsp; &nbsp; [ ] create a JFrame <br>
&nbsp; &nbsp; [ ] add a RegisterPanel <br>

[ ] register: Register <br>
&nbsp; &nbsp; - handles application logic <br>

[ ] inputPanel: JPanel <br>
&nbsp; &nbsp; - panel containing the text field for user
    input <br>

[ ] input: JTextField <br>
&nbsp; &nbsp; - text field for entering the
    amount

[ ] changePanel: PursePanel <br>
&nbsp; &nbsp; - panel for displaying change <br>

### Inner Class

[ ] InputListener <br>
&nbsp; &nbsp; [ ] implements ActionListener <br>

**Function** <br>

&nbsp; &nbsp; [ ] actionPerformed (ActionEvent): void<br>
&nbsp; &nbsp; &nbsp; &nbsp;
            [ ] param: actionPerformed <br>
&nbsp; &nbsp; &nbsp; &nbsp;
            [ ] return void <br>

This function will handle logic for processing
 input changes. <br>

## [ ] PursePanel (Class, Extends JPanel)

[ ] purse: Purse (represent purse)<br>

### Functions
[ ] paintComponent(Graphics g): void <br>
&nbsp; &nbsp; [ ] param **Graphics** g <br>
&nbsp; &nbsp; [ ] return void <br>
Logic for displaying the purse contents

