# Stackline accessment 

### Endpoints for multiple product related functions

Since I don't want to store the values read from the file in a DB or read the file everytime a functionality is called, I am reading it once and then passing it as a parameter to the respective method calls.
I am not familiar with the latest Java Spring Boot as my previous experience with REST APIs were with JAVA Servlets (which is outdated), so I was not able to write the "controller" aspect of the application but am willing to learn as time progresses

### Endpoint 1: autocomplete
#### Definition: Implement an autocomplete endpoint that can provide suggestions for product name, category, and brand given a prefix.

This functionality is implemented in the `Search` class under the `prefixSearch` method.
The method takes in the type, prefix and the list of products created by reading the file.
The `Products` list is looped over and only those products, which matche the given prefix criteria are returned (in a list format).

### Endpoint 2: search
#### Definition: Provide a query endpoint that can provide search results for any field in the data with pagination. When multiple fields are specified, the results should satisfy all conditions.

This functionality is implemented in the `Search` class under the `search` method.
The method takes in the conditions that needs to be met, the pagination criteria and the list of products created by reading the file.
The `Products` list is looped over and only those products, which match the given conditions are returned.
Since a given Product can match multiple conditions, we maintain a `Set` data structure to store the products that have matched the condition.
Once the we find all the products that match our given criteria, the pagination filter is applied and only a subset of the given set is returned

### Endpoint 3: keywords
#### Definition: Provide an endpoint that can provide keywords and frequencies from the product titles given. You may decide how to determine what a keyword is.

This functionality is implemented in the `Frequency` class under the `getFrequency` method.
The method takes in a list of keywords and the list of products created by reading the file.
The `keyword` list is looped over and for each keyword found in the title of a product, its frequency is calculated. 
The frequency calculation also takes into the consideration of the fact that the keyword can multiple time in a given title of a product,
example: for the give title `Katia Mini 8 Instant Camera Accessories with Instant Camera Case/Album/Selfie Len/Frames/Stickers/Strap/Filter for Fujifilm Instax Mini 8 Instant Film Camera - Set10 (Yellow)` and the keyword `Camera`,
the method would return `3` instead of `1`.
The output of the method is built in the desired format.

#### The `getEntityValue` method from the `EntityValue` class helps in maintaining a clean code and fetches the value corresponding to the input type.