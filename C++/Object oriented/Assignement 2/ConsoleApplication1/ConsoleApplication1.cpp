#include "stdafx.h"
#include "Date.h"
#include "Person.h"
#include "Passenger.h"
#include "ReservationRequest.h"
#include "ReservationManager.h"
#include "iostream"
#include "string"
using namespace std;

bool caseInsensitiveStringCompare(const string& str1, const string& str2) {
	if (str1.size() != str2.size()) {
		return false;
	}
	for (string::const_iterator c1 = str1.begin(), c2 = str2.begin(); c1 != str1.end(); ++c1, ++c2) {
		if (tolower(*c1) != tolower(*c2)) {
			return false;
		}
	}
	return true;
}


int main(){

	string ok = "Christian";
	string start = "Toronto";
	string dest = "Montreal";

	int seatNumber = 3;

	cout << "Class testing to show that they work:\n";

	Person person(ok, 28, 12, 2000);
	person.getEverything();
	ReservationRequest revReq(ok, 9, 2, 2020,  start, dest, seatNumber);
	revReq.getEverything();

	cout << "\n\n\n\n^THIS IS JUST FOR TESTING SAKE^\n\n\n\n\n\n";



	ReservationManager reservMan("Christ", 9, 2, 2020,
		start, dest, seatNumber, 1);
	int seatx, seaty;

	while(true){
	cout << "Enter what to do:\n"
		<< "1-Request Trip\n"
		<< "2-Search Trips by trip number\n"
		<< "3-Delete a trip\n"
		<< "4-Exit\n";
	int choice;
	cin >> choice;

	if (choice == 1) {
			string start;
			string destination;
			string name;

			cout << "Enter name:";
			cin >> name;
			reservMan.setName(name);
			cout << "Enter start location:\n";
			cin >> start;

			if(caseInsensitiveStringCompare(start, "toronto") || caseInsensitiveStringCompare(start, "montreal")
				|| caseInsensitiveStringCompare(start, "brockville") || caseInsensitiveStringCompare(start, "belleville")
				|| caseInsensitiveStringCompare(start, "kingston")){
				cout << "Start location is correct\n";
				reservMan.setStart(start);
			}else {
				cout << "Start location is incorrect\n";
				break;
			}

			
			
				cout << "Enter destination:";
				cin >> destination;
			
				if (caseInsensitiveStringCompare(destination, "toronto") || caseInsensitiveStringCompare(destination, "montreal")
					|| caseInsensitiveStringCompare(destination, "brockville") || caseInsensitiveStringCompare(destination, "belleville")
					|| caseInsensitiveStringCompare(destination, "kingston")) {
					cout << "Destination is correct\n";
					reservMan.setDestination(destination);
				}
				else {
					cout << "Destination is incorrect\n";
					break;
				}

			int sit;
			cout << "Enter the number of seat:\n";
			cin >> sit;
			reservMan.setSeatnum(sit);

			for (int i = 0; i < sit; i++){
				cout << "Enter the seat coodinates: (x then y): \n";
				cin >> seatx;
				cin >> seaty;
				if (reservMan.ifSuccess(seatx, seaty) == 1) {
					break;
					break;
				}
				cout << "Reservation is successful!\n";
				ReservationManager dlg;
				dlg.reservationRequestAdd(reservMan, seatx, seaty);
				reservMan.setArray(seatx, seaty);
			}
		reservMan.getArray();
		reservMan.getEverything();
		reservMan.getReq();

	}else if (choice == 2) {
		int number;
		cout << "Enter a trip number: ";
		cin >> number;

		if (reservMan.getReq2(number)) {
			reservMan.getEverything();
		}
	}
	else if (choice == 3) {

	
	}else if (choice == 4) {
		break;
	}
	
	}
	
}