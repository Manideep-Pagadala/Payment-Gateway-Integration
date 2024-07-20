
# `Payment Gateway‬ Integration`

`Project Summary`

This project involves creating a payment processing system that integrates a merchant application with a payment gateway using Spring Boot. The Payment Gateway provides APIs for making payments and checking payment status, returning unique payment references. The Merchant Application Backend interfaces with these APIs to handle payment requests and status checks for the user interface. Finally, a simple Merchant Application UI enables users to make payments and check their statuses through forms, providing a seamless online shopping experience.



## Tech Stack

`Java 17`,

 `SpringBoot 3.3.1`, 

 `Angular 18.0.1`, 

 `MySql 9.0.0`,

 `node v20.15.1`, 

 `Docker 27.0.3`,



## Software Installations

### `Java Setup`

#### Step-1. Download JDK 17


Go to the [JDK 17 Download Page](https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz).

Download the `jdk-17_linux-x64_bin.tar.gz` file.

#### Step-2. Install JDK 17

 **Extract the downloaded archive and set path in .bashrc file**


```bash
export JAVA_HOME= <your path> /jdk-17
export PATH=$JAVA_HOME/bin:$PATH
```

#### Step-3. Verify Installation

```bash
java -version
```

### `Angular Setup through NVM`

#### Step-1: Install Node (Node Version Manager)

```bash
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.7/install.sh | bash
```
#### Step-2: Download and install Node.js (you may need to restart the terminal)

```bash
nvm install 20
```

#### Step-3: Verifiy the right Node.js & NPM version is in the environment

```bash
node -v # should print `v20.15.1`

npm -v # should print `10.7.0`
```

#### Step-4: Install Angular CLI
Once Node.js and npm are installed, you can install the Angular CLI globally using npm:

```bash
npm install -g @angular/cli
```
#### Step-5: Verify Installation

```bash
ng version
```

### `Eclipse IDE Setup`

#### Step-1: Download Eclipse zip file

Go to the [Eclipse official website](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2024-06/R/eclipse-jee-2024-06-R-linux-gtk-x86_64.tar.gz).

Download the `eclipse-jee-2024-06-R-linux-gtk-x86_64.tar.gz` file.

#### Step-2: Extract and Launch Eclipse IDE

##### Open File Manager, go to the Downloads folder, right-click on eclipse-jee-2024-06-R-linux-gtk-x86_64.tar.gz, and select Extract Here to reveal the eclipse folder.


### `Postman  Setup`

#### Step-1: Download Postman zip file from official page

```bash
https://dl.pstmn.io/download/latest/linux_64
```
#### Step-2: Extract and Launch postman 

##### Open File Manager, go to the Downloads folder, right-click on zip file, and select Extract Here to reveal the Postman folder.















## `Project Setup`

‬ Create two Spring Boot starter projects and one angular project

 ## `1. Payment Gateway Application‬ `

  #### Required Dependencies 
     . Spring Web
     . Spring MySQL Driver
     . Spring JDBC
     . Devtools
     . Lombok
     . swagger ('springdoc' from mvn repository)     
 

 **Configure database credentials in YAML file. Develop persistence layer using Spring JDBC. Implement service classes and REST controllers to manage business logic and expose APIs.**


 ## `2. ‭Merchant Application‬ `
#### Required Dependencies 
     . Spring Web
     . Devtools
     . Lombok
     . swagger ('springdoc' from mvn repository)


 **Develop service layer to communicate with Payment Gateway application. Create REST endpoints to handle merchant-specific operations.**


## `3. ‭Merchant UI `


  #### Step 1: Create a New Angular Project
Create a new Angular project using Angular CLI:

```bash
ng new  < project-name >
```

#### Step 2: Navigate to the Project Directory
Change into your project directory:

```bash
cd < project-name >
```
#### Step 3: Devolop Web pages 
The Merchant UI Angular project facilitates payment interactions with a backend Merchant API. Two main components handle different tasks:

**make-payment component:** Allows users to submit payments and view status updates.

**check-payment-status component:** Enables users to check payment status using reference IDs.

#### Step 4: Serve the Application
Compile and serve the Angular application locally:

```bash
ng serve --open
```

This will compile the application and open it in your default web browser at http://localhost:4200.


## `4. Database Setup‬ `
#### Step-1: Run Mysql in Docker Container and configure credentials

```bash
docker run --name <container-name> -e MYSQL_ROOT_PASSWORD= <your-password> -d mysql:latest 

```
#### Step-2: Connect to MySQL Command line
Access MySQL command line interface inside the Docker container:



```bash
docker exec -it <container-name> mysql -u root -p 

```
#### Step 3: Run SQL DDL Scripts for Database and Table Creation


```bash
create databse <db-name>

use <db-name>

CREATE TABLE <table-name> (
    payment_ref_id VARCHAR(255) PRIMARY KEY,
    merchant_id VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    currency_type VARCHAR(3) NOT NULL,
    order_id VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    date_of_payment DATE NOT NULL
);
```
**Alternatively, store DDL scripts in schema.sql at /src/main/resources and configure in application.yml:**

 ```bash
spring:
  sql:
    init:
      mode: always
      platform: mysql
      schema-locations: classpath:schema.sql

 ```





