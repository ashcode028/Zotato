# Zotato
Food Delivery App Low Level Implementation.
This application primarily is a platform for restaurants and diners to connect facilitated by food
delivery executives. This employs OOP principles, e.g., interfaces, inheritance,
polymorphism, whichever provides the best and most appropriate design.
![](http://www.mithoma.com/wp-content/uploads/2019/03/foodmitho.jpg)
The application needs to serve the following features:
1) Customers are generally charged 40/- delivery charge per order. There are additionally,
two special categories:
● Elite Customers - Free delivery (50/- off on bill value greater than 200/- after
restaurant discount)
● Special Customers - 20/- delivery charge per order (25/- off on bill value greater
than 200/- after restaurant discount)
(Note: Apply restaurant discount first on bill value, then apply customer discount)
2) Restaurants do not generally have overall bill discounts. However there are additionally,
two special categories.
○ Fast food - Has an option to discount overall bill value
○ Authentic restaurants - Has the option to discount overall bill value + 50/- off on
all orders (if bill is greater than 100/- after overall bill value discount)

3) Each food item must have a unique ID for ease of selection. Each food item can have
their own individual discounts which must be taken into account when entering a food
item.
4) Restaurants need to pay 1% of the total bill value (after discounts) to the food tech
company (Assume Restaurants have surplus money to pay)
5) Owners must add categories to each food item so that customers can have clarity. The
categories consist of : "Starter", "Main Course", "Dessert", "Beverage".
6) Customers start with Rs. 1000/- in their account, which will be called the wallet. (For
sake of simplicity, assume this is the maximum which a customer can spend, no more
top-up)
7) There is a reward scheme for customers as follows -
○ Fast food - 10 points per 150/- spent
○ Authentic restaurants - 25 points per 200/- spent
○ Rest - 5 points per 100/- spent
(All the above rewards are applicable on total order value after all discounts, 1
point = 1 rupee)

8) The reward points must be added:
○ Customer - To the rewards account of the customer.
○ Restaurant - The same points must also be added to the restaurant
(Restaurants don’t use the reward points, it is just for rating purpose)

9) When a customer makes a purchase, the amount must be deducted from the rewards
account first and then from the wallet.
10) A customer may add food items from only one restaurant in a single order.
11) Customers must always add items to cart, be shown the order final total before placing
the order.

