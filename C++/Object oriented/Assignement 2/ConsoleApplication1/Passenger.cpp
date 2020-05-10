#include "stdafx.h"
#include "iostream"
#include "Passenger.h"

Passenger::Passenger(){
}

Passenger::~Passenger(){
}

Passenger::Passenger(int j){
	num = j;
}

void Passenger::getReq(){
	for (size_t i = 0; i < req.size(); i++){
		std::cout << "Trip #" << i + 1 << ": " << req[i] << "\n";
	}
}

