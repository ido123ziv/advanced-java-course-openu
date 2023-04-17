# Menu Application
This Menu read from `menu.txt` and adds a menu to memory, represent to user and then lets him order.               
Orders are made by Creating a file with Username and ID and order details.              
The ID validation is made with the Regex: `[a-zA-Z]+\d{9}`, let's break it down:
- `[a-z]` all small case letters allowed
- `[A-Z]` all capital case letters allowed
- `\d{9}` must be a 9-digit sequence 

**Important**           
* Must use `---` to separate menu items.
* ID is a set of characters and then a 9-digit number, if fail to supply an error message will pop.

## Examples
success run:            
![Menu](menu.jpg?raw=true)
confirm:                            
![confirm](confirm.jpg?raw=true)
id input:                             
![id-input](name%20input.jpg?raw=true)


