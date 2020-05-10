#pragma once
#include "Person.h"
#include "string"

class ReservationRequest : public Person{
public:
	ReservationRequest();
	ReservationRequest(const std::string &name, int day, int month, int year,
		std::string s, std::string d, int seat);
	~ReservationRequest();

	void setStart(std::string s);
	void setDestination(std::string d);
	void setSeatnum(int seat);
	int getGenNum();
	int getCountNum();
	std::string getStart();
	std::string getDestination();
	void setName(std::string n);
	int getSeatnum();
	void getEverything();

protected:
	int genNum = rand();
	int countNum = genNum;
	std::string start;
	std::string destination;
	int seatNum;
};

