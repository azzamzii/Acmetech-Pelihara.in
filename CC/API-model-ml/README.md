## ML Model API - Chatbot

###### This repository contains documentation for an Chatbot APIs built with Python. It provides a APIs use untill deploy using Cloud Run
###### Deployed link: ([Click Here](http://handlebarsjs.com/))
For the chatbot APIs, we write it in Python using Flask as web framework. The APIs used for consume the model of machine learning (.h5 file)


| Endpoint | Method | Description |
|:--------------:|:--------------:|:--------------:|
| /chat        | POST         | User send an input of string, then the server processes the input and generates a response based on the input provided.        |

## Run the APIs on local

### Setup
- Text Editor
- Clone this repository and go to the directory (API-model-ml)
- Postman

### How To Run the Server
1. Open the terminal on the directory of the file
2. Change app.run() in the last line, into this code:
   ```sh
   app.run(debug=True)
   ```
3. Create Venv environtment to install Python packages and libraries specific to this environment
   ```sh
   python -m venv myenv
   ```
4. Activate the virtual environment:
   ```sh
   .\myenv\Scripts\activate
   ```
5. Install the libraries and packages:
   ```sh
    install flask
    install scikit-learn
    install tensorflow
    ```
6. Run the server:
    ```sh
    python -m flask run
    ```
7. The server will be running on port that spesification in the app.py and we can check through Postman
    <img width="560" alt="Postman view" src="https://github.com/Rjndrkha/Acmetech/assets/88034186/8f8058b8-0f21-4bcb-8e77-79cdabe2556c">

## Deploy to Cloud
### Setup
- Google Cloud Platform
- Postman

### How To Deploy in Cloud Run
1. Go to Google Cloud Platform (GCP) console
2. Click the Activate Cloud Shell then click "Open Editor" button to open text editorin the GCP
3. Clone this repository through shell and go to this directory (API-model-ml)
4. Create **requirements.txt** file to install libraries and package and add this following code into the file
   ```sh
   flask
   tensorflow
   scikit-learn
   numpy
   ```

5. Create **Dockerfile** file to save the step of configuration and execution. Add this following code into **Dockerfile**
   ```sh
   FROM python:3.9

   RUN pip install --no-cache-dir --upgrade pip==23.1.2

   WORKDIR /API-model-ml

   COPY requirement.txt .

   RUN pip install --no-cache-dir -r requirement.txt

   COPY . .

   CMD [ "python", "app.py" ]
   ```
   > **Note:** for **step 6-9** change the **PROJECT-ID** based on your project-id and **DOCKER-NAME** based on your preference.
6. Build dockerfile in shell terminal
   ```sh
   docker build -t gcr.io/PROJECT-ID/DOCKER-NAME .
   ```
7. Input Docker configuration into the container
   ```sh
   docker push gcr.io/PROJECT-ID/DOCKER-NAME
   ```
8. Deploy the container through **Cloud Run**
   ```sh
   gcloud run deploy --image gcr.io/PROJECT-ID/DOCKER-NAME --platform managed
   ```
9. We can get the link of our application that already deployed
10. We also can test the API through postman
   <img width="560" alt="image" src="https://github.com/Rjndrkha/Acmetech/assets/88034186/98b0d88e-f048-4210-ae55-b75dbd943301">

