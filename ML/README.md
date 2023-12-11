Pelihara.in - Machine Learning Team
==
Team Member:
--
Machine Learning members of Pelihara.in consist of:
- Arin Kistia Nugraeni M066DSY0332@bangkit.academy
- Muhammad Ghaly Alghifari M151DSX0123@bangkit.academy


Importing Libraries:
--
import tensorflow as tf
import numpy as np

This code imports the TensorFlow and NumPy libraries, which are commonly used for machine learning and numerical computations.


Installing Libraries:
--
!pip install nltk
!pip install colorama
!pip install Flask

These lines use the !pip install command to install three Python libraries: NLTK, Colorama, and Flask. NLTK (Natural Language Toolkit) is used for natural language processing tasks, Colorama is used for adding colors to the terminal output, and Flask is a web framework for building web applications.


JSON Data:
--
data = {
    ...
}
This section defines a Python dictionary named data that contains a set of pre-defined patterns and responses. The dictionary represents a simple rule-based chatbot system, where each pattern is associated with one or more possible responses.

Cat Health Conditions:
After the JSON data section, there are multiple dictionary entries representing different health conditions for cats. Each entry has a "tag" representing the condition, "patterns" containing phrases related to the condition, and "responses" providing recommended treatments or actions for that condition. These entries seem to be part of a larger data set related to veterinary information for cats.

Saving the Trained Model:
--
model.save("chat_model.h5")

This line saves the trained model as an HDF5 file named "chat_model.h5". The model was likely trained using a deep learning framework like TensorFlow.

Saving the Fitted Tokenizer:
--
with open('tokenizer.pickle', 'wb') as handle:
    pickle.dump(tokenizer, handle, protocol=pickle.HIGHEST_PROTOCOL)
    
This code block saves the fitted tokenizer object using the Pickle module. The tokenizer is a component used to preprocess and tokenize text data, and it is saved as a binary file named "tokenizer.pickle".

Saving the Fitted Label Encoder:
--
with open('label_encoder.pickle', 'wb') as enc_file:
    pickle.dump(tag_encoder, enc_file, protocol=pickle.HIGHEST_PROTOCOL)
    
Similarly, this code block saves the fitted label encoder object, which is used to encode categorical labels as numerical values. The label encoder is saved as a binary file named "label_encoder.pickle".


Loading JSON Data:
--
with open('pet.json', 'r') as file:
    data = json.load(file)

This section loads JSON data from a file named "pet.json". The JSON file likely contains patterns, responses, and tags for the chatbot's conversation.

Defining the chat() Function:
The chat() function is defined, which encapsulates the chatbot's functionality. It performs the following steps:
Loads the trained model, tokenizer, and label encoder from the saved files.
Sets the maximum length parameter for input sequences.
Enters a loop to continuously interact with the user.
Takes user input and checks if the input is "quit" to exit the loop.
Preprocesses the user input using the tokenizer and pad sequences to the defined maximum length.
Uses the loaded model to predict the tag or label for the user input.
Searches for the appropriate response based on the predicted tag in the loaded JSON data.
Prints a randomly selected response if a valid tag is found.
If no valid tag is found, it prints a default response indicating that the chatbot doesn't understand the input.
The loop continues until the user enters "quit".
Finally, the code starts the chatbot by calling the chat() function.
