# Lab One

**Course**: CSCI 3381

**Professor**: Jon Baarsch

**Student**: Jewell Callahan

---

# Making Change

[ ] Create a function called makeChange <br>
[ ] Param **double** amount <br>
[ ] Return **Purse** object <br>
&nbsp; &nbsp; [ ] _amount_ is translated into
 fewest possible coins and bills <br>
<br>

## [ ] Currency [Denomination]

[ ] name: String (e.g. Ten note, Dime)<br>
[ ] amt: double (0.05, 1.09) <br>
[ ] form: String (bill, coin) <br>
[ ] img: String (img file) <br>

## [ ] Purse (Class)

[ ] cash: Map<Denomination, Integer>
     represents the money in the purse <br>

### Functions 

[ ] add(type: Denomination, num: int): void<br>
&nbsp; &nbsp; [ ] param **Denomination** & **int** num <br>
&nbsp; &nbsp; [ ] return void <br>

[ ] remove(type: Denomination, num: int): double <br>
&nbsp; &nbsp; param: **Denomination** & **int** num <br>
&nbsp; &nbsp; return: Amount current <br>

[ ] getValue(): double <br>
&nbsp; &nbsp; [ ] param  null <br>
&nbsp; &nbsp; [ ] return total amount in purse <br>

[ ] toString(): string <br>
&nbsp; &nbsp; [ ] param null <br>
&nbsp; &nbsp; [ ] return string representation of 
    amount total <br>

## [ ] Register(Class)

### Functions

[ ] makeChange(amt:double): Purse: <br>
&nbsp; &nbsp; [ ] param **double** amount <br>
&nbsp; &nbsp; [ ] return *Purse* <br>

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

