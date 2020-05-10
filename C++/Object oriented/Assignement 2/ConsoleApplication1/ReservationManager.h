#pragma once
#include "ReservationRequest.h"
#include "Passenger.h"
#include "array"
#include "iostream"
#include "string"
#include <vector>



class ReservationManager : public ReservationRequest, public Passenger{
public:
	ReservationManager();
	ReservationManager(const std::string& name, int day, int month, int year,
		std::string s, std::string d, int seat, int num);
	~ReservationManager();
	int getStationLeft(std::string currentStation, std::string endStation);
	int ifSuccess(int x, int y);
	void reservationRequestAdd(ReservationManager reserv, int x, int y);
	void getArray();
	void setArray(int x, int y);
	void setPassenger();
	bool getReq2(int bruh);
	void getEverything();
	void setName(std::string n);
	void setNum(int ni);

protected:
	std::string stations[5] = { "Montreal", "Dorval", "Brockville", "Belleville", "Toronto" };
	int arr[5][5] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	std::vector<ReservationRequest> reservationRequest;
	std::vector<int> passenger;
	

};

