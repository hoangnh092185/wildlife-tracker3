# :file_folder: [Wildlife_Tracker](https://github.com/hoangnh092185/wildlife-tracker3.git) :file_folder:


  __Version 1.0.0: September 30, 2016__
## by [Nhat Hoang](https://github.com/hoangnh092185)

### Description
__*Individual Project for Epicodus Java Programming*__

## Objectives

* An interface or inherited class provides similar content in different classes.
* Database timestamps are included for each sighting.
* At least two Exceptions can be thrown and caught.
* Constants are used in at least one class.

## stories
* As a park ranger, I need to be able to add sighted animals to the animal list.
* As an ranger, I need to be able to add additional information for endanger animal : health, age.
* As an ranger, I need to fill where, when and who when document animal.

## Setup

In PSQL:
* CREATE DATABASE wildlife_tracker;
* CREATE TABLE animals (id serial PRIMARY KEY, name varchar, health varchar, age varchar, type varchar);
* CREATE TABLE sightings (id serial PRIMARY KEY, location varchar, rangername varchar, animalid int, timesighted timestamp);
* CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;

### Setup/Installation
*Clone or download and extract to use, or click [here](https://github.com/hoangnh092185/wildlife-tracker3.git) to view.*


### Technologies Used
###### HTML, CSS, Bootstrap, Java, Spark, Sql

### Legal
*Licensed under the GNU General Public License v3.0*

Copyright &copy; 2016 **_Nhat Hoang_**
