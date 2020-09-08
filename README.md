This is the final project for the course "Web Applications with Java support" that took place in the first semester of the third year in college. 
This project changes the brightness of an image using only Java, I used BlueJ for running the app and writting code <br>
Steps in execution: <br>
-reads the folder from where the image is taken for modification;<br>
-reads the folder where the output image will be saved;<br>
-choses the image to be modified;<br>
-read from the keyboard how much the brightness will change;<br>
-do the modification of the image;<br>
-in every step of the execution the execution time is being calculated and shown in console;<br>
<br>
At the beginning of the app, the user can choose if the input will be introduced via keyboard or visual interface.<br>
OOP concepts used: encapsulation, inheritance, polimorphism, abstractization, overwrite etc.<br>
This app is made of 5 classes and one interface:<br>
-FisierInput.class - the interface with two methods about reading the input and output files.<br>
-FisierOutput.class - abstract class that implements the interface and overwrites its methods. 
In this class the  setters and getters are implemented. Also it adds a new  method to get the image address.<br>
-Fisiere.class - inherits the FisiereOutput.class and adds a new attribute: image adress. Also it overwrites the parent methods.<br>
-Modifica.class - inherits the Fisiere.class and reads from the keyboard the luminosity factor that will change the brightness.
Also implements the modification method and has an attribute of type Image.<br>
-Image.class - has setters and getters and modifies the image pixel by pixel.<br>
-Main.class - has an instance of the Modifica.class and calls its methods.<br>
Some screenshots:<br>
![image](https://user-images.githubusercontent.com/64609288/92453858-72ccd080-f1c8-11ea-8eef-97fb0b12df26.png)
![image](https://user-images.githubusercontent.com/64609288/92453866-76605780-f1c8-11ea-9127-0927cb202ca6.png)
![image](https://user-images.githubusercontent.com/64609288/92453879-7bbda200-f1c8-11ea-8d69-78ae85b67ff1.png)
![image](https://user-images.githubusercontent.com/64609288/92453886-7f512900-f1c8-11ea-937a-5afe391d3923.png)
![image](https://user-images.githubusercontent.com/64609288/92453895-824c1980-f1c8-11ea-9232-693525abaed1.png)
![image](https://user-images.githubusercontent.com/64609288/92453903-86783700-f1c8-11ea-9ec8-667326724010.png)
![image](https://user-images.githubusercontent.com/64609288/92453912-8aa45480-f1c8-11ea-9744-ad176e4732a2.png)
