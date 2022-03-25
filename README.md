# InterviewProgram3

A department store needs to calculate and apply basic sales tax for the products sold
in its stores. Sales tax is applied as standard 10% for all items, except Books, Food and
Medical products.
An additional 5% import duty is levied on all imported products, with no exceptions.
Write a program to prepare and print the receipt for every purchase. The receipt
should list the name of all the items and their price (including tax), finishing with the
total cost of the items, and the total amounts of sales taxes paid. The rounding rules
for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded
up to the nearest 0.05) amount of sales tax.

INPUT FORMAT:
<product-1>:<quantity>:<unit-price>
<product-2>:<quantity>:<unit-price>
<product-3>:<quantity>:<unit-price>
.
.
.

OUTPUT FORMAT:
<product-1>:<quantity>:<total-price-with-tax>
<product-2>:<quantity>:<total-price-with-tax>
<product-3>:<quantity>:<total-price-with-tax>
.
.
.
TAX: <total-sales-tax>
TOTAL: <total>
Examples:
Input #1
Book : 1 : 12.49
Music CD : 1 : 14.99
Chocolate Bar : 1 : 0.85
OUTPUT #1
Book : 1 : 12.49
Music CD : 1 : 16.99
Chocolate Bar : 1 : 0.85
TAX: 1.50
TOTAL: 29.83

Input #2
Imported Chocolate : 1 : 10.00
Imported Perfume : 1 : 47.50
OUTPUT #2
Imported Chocolate : 1 : 10.50
Imported Perfume : 1 : 54.65
TAX: 7.65
TOTAL: 65.15
