#include "stdafx.h"
#include "ReservationRequest.h"
#include "Person.h"
#include "iostream"

ReservationRequest::ReservationRequest(){

}

ReservationRequest::ReservationRequest(const std::string& name, int day, int month, int year,
	std::string star, std::string dest, int seatNu) : Person{name, day, month, year}, 
	start{ star }, destination{ dest }, seatNum{seatNu}{
	start = star;
	destination = dest;
	seatNum = seatNu;
}

ReservationRequest::~ReservationRequest(){
}

void ReservationRequest::setStart(std::string s){
	start = s;
}

void ReservationRequest::setDestination(std::string d){
	destination = d;
}

void ReservationRequest::setSeatnum(int seat){
	while (seat <= 0 || seat > 4) {
		std::cout << "Enter a seat number between 1 and 4:";
		int s = 0;
		std::cin >> s;
		setSeatnum(s);
	}
	if (seat > 0 && seat <= 4) {
	seatNum = seat;
	}
	
}

int ReservationRequest::getGenNum(){
	return genNum;
}

int ReservationRequest::getCountNum(){
	countNum += 1;
	return countNum;
}

std::string ReservationRequest::getStart(){
	return start;
}

std::string ReservationRequest::getDestination(){
	return destination;
}

void ReservationRequest::setName(std::string n){
	name = n;
}

int ReservationRequest::getSeatnum(){
	return seatNum;
}

void ReservationRequest::getEverything(){
	std::cout << "************************\n";
	std::cout << "Name: " << name << "\n";
	std::cout << "Start/Destination: " << start << "/" << destination << "\n";
	std::cout << "Number of seats: " << seatNum << "\n";
	std::cout << "Date: " << day << "/" << month << "/" << year << "\n";
	std::cout << "************************\n";
}
