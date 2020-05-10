#include "stdafx.h"
#include "Date.h"
#include "Person.h"
#include "string"
#include <iostream>

Person::Person(std::string n, int day = 0, int month = 0, int year = 0) : Date{day, month, year} {
	name = n;
}

Person::Person(){
}

Person::~Person() {
}

void Person::setName(std::string n) {
	name = n;
}

std::string Person::getName() {
	return name;
}

void Person::getEverything(){
	std::cout << "***********************\n";
	std::cout << "Name: " << name << "\n";
	std::cout << "Birthday: " << day << "/" << month << "/" << year << "\n";
	std::cout << "***********************\n";
}
