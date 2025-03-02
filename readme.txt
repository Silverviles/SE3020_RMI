9. Use the synchronized keyword when declaring the function that increments the client count to make it thread safe.
10. Current implementation is singleton.
    *Per Client :- We can make this per client using a service factory that can be used to serve an instance of the math server to the client instead of serving itself.
    *Per Call Instantiation :- We can declare a new math server object inside each add, subtract, multiply and divide methods and have another factory service serve each function.
