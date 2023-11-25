Pelihara.in - Cloud Computing Team
==
Team Member:
--
Cloud Computing team is responsible to make API to be used by Mobile app, deploy the back-end, and allocate another resource using GCP. Cloud computing members of Pelihara.in consist of:
- Azzam Zhafran Imran c151dsx1630@bangkit.academy
- Vicky Firmansyah c151dsx1596@bangkit.academy

API
--
Pelihara.in apps using 2 kinds of API:
- **News Pet API** 
  This API build with some tools:
  - **Node.js** : JavaScript runtime environment to allows developers to run JavaScript code on the server-side
  - **Hapi** : Web framework to help build server side REST APIs. Helps on layers of authentication, tokenize, cors, etc.<br>

- **ChatBot API** - Contributes to the machine learning path in making it.
  This API is built with the following tools:
  - **Python** : A high-level programming language used to consume the model built in Python.
  - **Flask** : A web framework written in Python used to build REST APIs.

  For detailed documentation of the API, refer to the README.md file in each folder of the API.

Login & Register
--
<img width="560" alt="image" src="https://github.com/Rjndrkha/Acmetech/assets/88034186/0bfe1186-d72e-4565-bd2b-f4fab35f34ba">

**Firebase Authentication Service**

For login and registration, we use the Firebase Authentication Service. So, when a user wants to create an account or login into our app, 
the Firebase Authentication securely handles the account creation process and also securely authenticates the user. The code of the 
authentication is located in the MD site. So, when you want to access it go to MD directory on this repository

Deployment
--
This is diagram of the cloud architect of Pelihara.in app: <br><br>
<img width="560" alt="diagrams-cc-github" src="https://github.com/Rjndrkha/Acmetech/assets/88034186/ec6a3173-7373-4e2d-9a1a-ccc37a58062d">

Service that we use:
1. **Cloud Run** :  Build and deploy scalable containerized apps, this service used so the API can be consumed by the Pelihara.in apps side.
2. **Firestore** : Fully managed, scalable, and serverless document database. Used for to save data from pet news.
3. **Cloud Storage** : Managed service for storing unstructured data. Used for save image of pet news.

explanation of cloud architect diagrams:
1. The News API is deployed on Cloud Run
2. We utilize Firestore and Cloud Storage to hold the news content as a database and storage
3. The Chatbot API is deployed on Cloud Run
4. For the detailed on how to deploy each services, open the README.md for each API


