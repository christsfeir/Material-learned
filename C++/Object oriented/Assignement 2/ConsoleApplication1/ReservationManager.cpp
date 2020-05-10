#include "stdafx.h"
#include "ReservationManager.h"

ReservationManager::ReservationManager(){
}

ReservationManager::ReservationManager(const std::string& name= "", int day = 0, int month = 0, int year = 0,
	std::string s = "", std::string d = "", int seat = 0, int num = 0) :
	ReservationRequest(name, day, month, year, s, d, seat), Passenger(num){
	for (int i = 0; i < num; i++) {
		requestNum = std::rand();
		req.push_back(requestNum);
	}
}

ReservationManager::~ReservationManager(){
}

int ReservationManager::getStationLeft(std::string currentStation, std::string endStation){
	int k, l;
	for (int i = 0; i < 5; i++){
		if (stations[i] == currentStation) {
			k = i;
		}
	}
	
	for (int j = 0; j < 5; j++) {
		if (stations[j] == endStation) {
			l = j;
		}
	}
	return l - k;
}

int ReservationManager::ifSuccess(int x, int y){
		
			if (arr[x][y] == 0) {
				std::cout << "Seat empty!\n";
				return 0;
			}
			else {
				std::cout << "Seat is taken!\n";
				return 1;
			}
}

void ReservationManager::reservationRequestAdd(ReservationManager reserv, int seatx, int seaty){	
		reservationRequest.push_back(reserv);
		arr[seatx][seaty] = 1;
}

void ReservationManager::setArray(int x, int y) {
	for (int i = 0; i < 5; i++){
		for (int j = 0; j < 5; j++){
			if (i == x && j == y) {
				arr[i][j] = 1;
			}
		}
	}
}

void ReservationManager::setPassenger(){
		for (int i = 0; i < passenger.size(); i++) {
			std::cout << "Trip Number " << i + 1 << ": ";
			std::cout << passenger[i] << "\n";
		}
}



bool ReservationManager::getReq2(int bruh) {
	for (size_t i = 0; i < req.size(); i++) {
		if (req[i] == bruh) {
			return true;
		}
	}
	return false;
}

void ReservationManager::getEverything(){
	std::cout << "************************\n";
	std::cout << "Name: " << ReservationRequest::name << "\n";
	std::cout << "Start/Destination: " << start << "/" << ReservationRequest::destination << "\n";
	std::cout << "Number of seats: " << ReservationRequest::seatNum << "\n";
	std::cout << "Date: " << ReservationRequest::day << "/" << ReservationRequest::month << "/" 
		<< ReservationRequest::year << "\n";
	std::cout << "************************\n";
}

void ReservationManager::setName(std::string n){
	ReservationRequest::name = n;
}

void ReservationManager::setNum(int ni){
	Passenger::num = ni;
}

void ReservationManager::getArray() {
	std::cout << "Seat Chart of the train: \n";
	for (int i = 0; i < 5; i++) {
		std::cout << "--------------------\n|";
		for (int j = 0; j < 5; j++) {
			std::cout << arr[i][j] << " | ";
		}
		std::cout << "\n";
	}
	std::cout << "--------------------\n";
}


