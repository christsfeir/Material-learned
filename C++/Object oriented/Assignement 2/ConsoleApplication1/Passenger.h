#pragma once
#include "Person.h"
#include "vector"

class Passenger : public Person{
public:
	Passenger();
	~Passenger();
	Passenger(int j);
	void getReq();

protected:
	int requestNum = 0;
	int num;
	std::vector <int> req;
};

