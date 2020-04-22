# "Work interview assignment"

Domain / Business objects representing civil registry information.
Contains three classes (+ 1 enum, and 1 test class):

* Person
* Address
* Workplace

Business methods that would be required for a fully working software implementation 
are not demonstrated here. However some are described in the sections below. 


### Person
A person has 3 attributes: 
* His/Her identifying id string (Primary Key), 
* Basic information (first and last names, address, birthdate and a possible date of death) and a 
* Workplace

A persons relatives' id strings are listed in the attribute relativeIds. 
Id is the key (which could be used to fetch other persons information) and the relationship (Enum) is the value.

Adding a relative could send a call to check whether the relative exists, if not, create it and add current person as their relative.

Adding a workplace to a Person should also add the Persons id to the employee list (and persist). This is only demonstrated in junit tests with a list of workplace employees.



### Address
Address class has attributes representing 
* Street name, 
* Street number, 
* Apartment/staircase letter and 
* An apartment number.

### Workplace
Workplace class has attributes for 
* name, 
* Address,
* a list of workers' ids.

# Unit tests
The project has two quite simple Junit 5 tests, which can be run with maven from the cmd/terminal using:

> maven clean test

Main Application/Software or database connections etc. are not implemented as per instructions. 