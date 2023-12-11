## API Pet News

###### This repository contains documentation for news APIs. It provides a APIs uses untill deploy using Cloud Run
###### Deployed link: ([Click Here](https://backend-newspet-ewk4drcdjq-et.a.run.app))
For the news APIs, we write it in node.js using Hapi as web framework.


| Endpoint | Method | Description |
|:-------------- |:--------------:|:---------:|
| /Cat        | POST         | Admin input content, image, publisher, and title of the dog news <br> (This is an upcoming features) |
| /Cat/{id}        | Get         | Android apps get the data of the cat news based on id of each news |
| /Cat        | Get         | Android apps get all the data of the cat news |
| /Dog        | POST         | Admin input content, image, publisher, and title of the dog news <br> (This is an upcoming features)        |
| /Dog/{id}        | Get         | Android apps get the data of the cat news based on id of each news |
| /Dog        | Get         | Android apps get all the data of the dog news |

## Run the APIs on local

### Setup
- Text Editor
- Clone this repository and go to the directory (API-news-pet)

### How To Run the Server
1. Open the terminal on the directory of the file
2. Change **Port** and **Host** on server.js with this code
   ```sh
   port: 8000,
   host: "localhost",
   ```
3. Run the server:
   ```sh
   npm run start
   ```
4. The server will be running on port that spesification in the app.py and we can check through Postman
    <img width="560" alt="image" src="https://github.com/Rjndrkha/Acmetech/assets/88034186/03c5f086-acf2-43c6-b8e2-a9c22ba5a8d7">

## Deploy to Cloud
### Setup
- Google Cloud Platform
- Postman

### How To Deploy in Cloud Run
1. Go to Google Cloud Platform (GCP) console
2. Click the Activate Cloud Shell then click "Open Editor" button to open text editorin the GCP
3. Clone this repository through shell and go to this directory (API-news-pet)
4. Create **requirements.txt** file to install libraries and package and add this following code into the file
   ```sh
   flask
   tensorflow
   scikit-learn
   numpy
   ```

5. Create **Dockerfile** file to save the step of configuration and execution. Add this following code into **Dockerfile**
   ```sh
   FROM node:16

   WORKDIR / API-news-pet

   COPY package*.json ./

   RUN npm install --production

   COPY . .

   CMD [ "node", "server.js" ]
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

#### Postman view
<img width="400" alt="image" src="https://github.com/Rjndrkha/Acmetech/assets/88034186/fc632cc9-e5da-41dc-9211-fceb0d466129">
<img width="400" alt="image" src="https://github.com/Rjndrkha/Acmetech/assets/88034186/e381a545-7da2-42a5-ace2-1faf97b9ca87">
<img width="400" alt="image" src="https://github.com/Rjndrkha/Acmetech/assets/88034186/11d3567f-57fd-49d6-8389-3ffef38e576f">
<img width="400" alt="image" src="https://github.com/Rjndrkha/Acmetech/assets/88034186/07111938-c784-4d10-baa3-026897620a6d">




