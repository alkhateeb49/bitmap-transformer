# bitmap-transformer: Lab02
---
Done By:<br/>
* Areej Obaid <br/>
* Mohamad Alkhateeb <br/><br/>
### Class 4
| The files  | The Methods |
|------------|-------------|
| bitmap_transformer.java | read, save, transformer|
| bitmap_transformer.Test | test1Transfrom, test2Transfrom, test3Transfrom, test4Transfrom |<br/>
We spent 4H 

---
## Documentation

First we created instance of our class, and then if we create the instece with params,
 the constrector will call the Transfrom method dirictly and if we didn't pass params the constractor will not call anything,
 and we can call the Transfrom method from the created opject.

When Transfrom method call it will call the read method to read the file with the input path,
 and then use the output data of the read file to create a new updated version file with Editing with editing depending on chosen filter.