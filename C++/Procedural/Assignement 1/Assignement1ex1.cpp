#include <iostream>
using namespace std;


int main()
{
	int studentGrade;


	std::cout << "What is the grade of the student? \n";
	cin >> studentGrade;


	while (studentGrade < 0 || studentGrade>100) 
	{
		if (studentGrade < 0) {
			std::cout << "Student grade cannot be under 0\nWhat is the grade of the student? \n";
		}
		else {
			std::cout << "Student grade cannot be above 100\nWhat is the grade of the student? \n";
		}
		cin >> studentGrade;
	}

	if (studentGrade < 40) 
	{
		std::cout << "F";
	}
	else if (studentGrade >= 40 && studentGrade < 45) {
		std::cout << "D-";
	}
	else if (studentGrade >= 45 && studentGrade < 50) {
		std::cout << "D";
	}
	else if (studentGrade >= 50 && studentGrade < 55) {
		std::cout << "D+";
	}
	else if (studentGrade >= 70 && studentGrade < 75) {
		std::cout << "B";
	}
	else if (studentGrade >= 65 && studentGrade < 70) {
		std::cout << "C+";
	}
	else if (studentGrade >= 60 && studentGrade < 65) {
		std::cout << "C";
	}
	else if (studentGrade >= 55 && studentGrade < 60) {
		std::cout << "C-";
	}
	else if (studentGrade >= 75 && studentGrade < 80) {
		std::cout << "B+";
	}
	else if (studentGrade >= 80 && studentGrade < 85) {
		std::cout << "A-";
	}
	else if (studentGrade >= 85 && studentGrade < 90) {
		std::cout << "A+";
	}
	else if (studentGrade >= 90) {
		std::cout << "A";
	}

}
