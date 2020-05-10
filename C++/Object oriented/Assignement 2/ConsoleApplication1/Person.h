#pragma once
#include "Date.h"
#include<string>

class Person: public Date{
public:
	Person(std::string name, int day, int month, int year);
	Person();
	~Person();
	void setName(std::string n);
	std::string getName();
	void getEverything();

protected:
	std::string name;
};

