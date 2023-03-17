# Expected Output:
## basic flow
```bash
Please Choose an option:
[1] -> Start new Buy
[2] -> get Cashier Total
[3] -> get Cashier Balance
[-1] -> exit

1
Starting new Buy!
Please Choose an option:
[0] -> return to main menu
[1] -> Add new Item Buy
[2] -> get current Total
[3] -> Pay
[4] -> See Details
[-1] -> exit

Which Item to add?
0 - milk, 1 - eggs, 2 - tea, 3 - honey
enter the num please

1
How many would you like?

2
Please Choose an option:
[0] -> return to main menu
[1] -> Add new Item Buy
[2] -> get current Total
[3] -> Pay
[4] -> See Details
[-1] -> exit

1
Which Item to add?
0 - milk, 1 - eggs, 2 - tea, 3 - honey
enter the num please

3
How many would you like?

3
Please Choose an option:
[0] -> return to main menu
[1] -> Add new Item Buy
[2] -> get current Total
[3] -> Pay
[4] -> See Details
[-1] -> exit

2
79.0
Please Choose an option:
[0] -> return to main menu
[1] -> Add new Item Buy
[2] -> get current Total
[3] -> Pay
[4] -> See Details
[-1] -> exit

4
Items list: 
priceOfItem=8.0, quantity=3, totalSum=24.0
priceOfItem=8.0, quantity=2, totalSum=16.0
priceOfItem=9.0, quantity=2, totalSum=18.0
priceOfItem=7.0, quantity=3, totalSum=21.0

Please Choose an option:
[0] -> return to main menu
[1] -> Add new Item Buy
[2] -> get current Total
[3] -> Pay
[4] -> See Details
[-1] -> exit

3
That will be 79.0
Please enter cash amount
80
Payment accepted
New Balance is:79.0
Please Choose an option:
[1] -> Start new Buy
[2] -> get Cashier Total
[3] -> get Cashier Balance
[-1] -> exit

3
Balance: 79.0
Please Choose an option:
[1] -> Start new Buy
[2] -> get Cashier Total
[3] -> get Cashier Balance
[-1] -> exit

2
Total: 79.0
```
## Cancel a buy
```bash
Starting new Buy!
Please Choose an option:
[0] -> return to main menu
[1] -> Add new Item Buy
[2] -> get current Total
[3] -> Pay
[4] -> See Details
[-1] -> exit

Which Item to add?
0 - milk, 1 - eggs, 2 - tea, 3 - honey
enter the num please

0
How many would you like?

0
Please Choose an option:
[0] -> return to main menu
[1] -> Add new Item Buy
[2] -> get current Total
[3] -> Pay
[4] -> See Details
[-1] -> exit

0
Please Choose an option:
[1] -> Start new Buy
[2] -> get Cashier Total
[3] -> get Cashier Balance
[-1] -> exit

Please Choose an option:
[1] -> Start new Buy
[2] -> get Cashier Total
[3] -> get Cashier Balance
[-1] -> exit

-1
```
# not enough money
```bash
Please Choose an option:
[1] -> Start new Buy
[2] -> get Cashier Total
[3] -> get Cashier Balance
[-1] -> exit

3
Balance: 0.0
Please Choose an option:
[1] -> Start new Buy
[2] -> get Cashier Total
[3] -> get Cashier Balance
[-1] -> exit

1
Starting new Buy!
Please Choose an option:
[0] -> return to main menu
[1] -> Add new Item Buy
[2] -> get current Total
[3] -> Pay
[4] -> See Details
[-1] -> exit

Which Item to add?
0 - milk, 1 - eggs, 2 - tea, 3 - honey
enter the num please

2
How many would you like?

3
Please Choose an option:
[0] -> return to main menu
[1] -> Add new Item Buy
[2] -> get current Total
[3] -> Pay
[4] -> See Details
[-1] -> exit

1
Which Item to add?
0 - milk, 1 - eggs, 2 - tea, 3 - honey
enter the num please

2
How many would you like?

2
Please Choose an option:
[0] -> return to main menu
[1] -> Add new Item Buy
[2] -> get current Total
[3] -> Pay
[4] -> See Details
[-1] -> exit

2
40.0
Please Choose an option:
[0] -> return to main menu
[1] -> Add new Item Buy
[2] -> get current Total
[3] -> Pay
[4] -> See Details
[-1] -> exit

4
Items list: 
priceOfItem=8.0, quantity=3, totalSum=24.0
priceOfItem=8.0, quantity=2, totalSum=16.0

Please Choose an option:
[0] -> return to main menu
[1] -> Add new Item Buy
[2] -> get current Total
[3] -> Pay
[4] -> See Details
[-1] -> exit

3
That will be 40.0
Please enter cash amount
30
Not enough money
Payment accepted
New Balance is:0.0
```