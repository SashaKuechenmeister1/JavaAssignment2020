/// Classes created: ///

Control:
- Allows the GUI to be displayed

MachineLearning:
- HashMap’s store data for each feature

- fileReader() reads in the data from "MLdata.csv" file and stores them in an Array List

- Frequency() goes through each of the inputs and increments the correct frequency HashMap which the predict() then makes use of to calculate the chance of having the virus.

CovidGUI:
- creates a Graphical User Interface
- allows user to select their symptoms and calculate their chance of having the Coronavirus

Input:

- Stores the data from the “MLdata.csv” file
- Stores the symptom attributes

/// Description of application: ///

I chose to do the Machine Learning assignment. My application allows the user to select certain listed symptoms and use these to predict their chance of having the Coronavirus. The calculations are done using the Naïve Bayes classifier. My application takes in the users’ inputs and then calculates the frequency of each attribute through the use of various HashMap’s. I created a GUI to take in the users’ inputs through checkboxes and a drop-down selection, however, I was unable to get any of my GUI functions to work as intended(it’s pretty much just a visual idea of what I was trying to achieve). To see the machine learning calculations, you need to manually change the values in the “actionPerformed” (I have left a NOTE comment and explained the process in my video demo as a guide). Video demo link is at the bottom of this README file

/// If had more time///

If I had a bit more time, I would have definitely spent more time trying to get my GUI to function properly.

/// Video DEMO ///

https://youtu.be/ntnkK78BoBs

