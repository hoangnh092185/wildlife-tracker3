# :file_folder: [Wildlife_Tracker](https://github.com/hoangnh092185/wildlife_tracker-) :file_folder:


  __Version 1.0.0: September 23, 2016__
## by [Nhat Hoang](https://github.com/hoangnh092185)

### Description
__*Individual Project for Epicodus Java Programming*__

Create a webpage that have all the elements that meet the client needs listed below.
Test all the class methods with gradle test function before integrating functionality into Sparks.
Include CRUD functionality include for each class in Sparks.
Spark routes fallow RESTful convention.

## stories
* As a park ranger, I need to be able to see a list of all sighted animals.
* As an ranger, I need to be able to select a animal, see their health, and see a * list of all rangers that seen that animal.
* As an ranger, I need to add new animals to our system when they are sighted.
* As an ranger, I need to be able to add new animals to a specific animal species.
* As an ranger, I need to be able to update a animal's details.
* As an ranger, I need to be able to update a ranger's details.

## Setup

In PSQL:
* CREATE DATABASE wildlife_tracker;
* CREATE TABLE animals (id serial PRIMAY KEY, name varchar);
* CREATE TABLE sightings (id serial PRIMARY KEY, name varchar, health varchar, age varchar);
* CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;

### Setup/Installation
*Clone or download and extract to use, or click [here](https://github.com/hoangnh092185/wildlife_tracker-) to view.*


### Technologies Used
###### HTML, CSS, Bootstrap, Java, Spark, Sql

### Legal
*Licensed under the GNU General Public License v3.0*

Copyright &copy; 2016 **_Nhat Hoang_**
