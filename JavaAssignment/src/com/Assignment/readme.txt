Description of application:
I chose to do the Machine Learning assignment. My application allows the user to select certain listed symptoms and use these to predict their chance of having the Coronavirus. The calculations are done using the Naïve Bayes classifier which is a classification technique based on Bayes’ theorem with an assumption of independence among predictors. The application takes in the users’ inputs and then calculates the frequency of each attribute through the use of HashMap. You can access these features using the GUI I have designed; however, I was unable to get any of my GUI functions to work (its pretty much just a visual idea of what I was trying to achieve). To see the machine learning calculations, you need to manually change the values in the “action Performed” .

Classes created:
Control:
* Function: 
o Allows the GUI to be displayed
MachineLearning:
* Function:
o HashMaps store data for each feature
o fileReader() reads in the data from "MLdata.csv" file and stores them in an ArrayList
o Frequency() goes through each of the inputs and increments the correct frequency HashMap which the predict() then makes use of to calculate the chance of having the virus.

CovidGUI:
* Function:
o creates a Graphical User Interface
o allows user to select their symptoms and calculate their chance of having the Coronavirus
Input:
* Function:
o Stores the data from the “MLdata.csv” file
o Stores the symptom attributes
