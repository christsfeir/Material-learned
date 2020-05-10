#include <iostream>
#include<conio.h>
using namespace std;

int main() {

	int num1;

	cout << "Enter the first integer \n";
	cin >> num1;

	int num2;

	cout << "Enter the second integer \n";
	cin >> num2;

	int num3;

	cout << "Enter the third integer \n";
	cin >> num3;
	cout << "\n";

	cout << "The right order is: ";

	if (num1 >= num2 && num2 >= num3) {
		cout << num1 << ", " << num2 << ", " << num3 << "\n";
	}
	else if (num1 > num3 && num2 < num3) {
		cout << num1 << ", " << num3 << ", " << num2 << "\n";
	}
	else if (num1 < num2 && num1 > num3) {
		cout << num2 << ", " << num1 << ", " << num3 << "\n";
	}
	else if (num1 < num2 && num3 < num2) {
		cout << num2 << ", " << num3 << ", " << num1 << "\n";
	}
	else if (num1 < num2 && num2 < num3) {
		cout << num3 << ", " << num2 << ", " << num1 << "\n";
	}
	else if (num1 > num2 && num2 < num3) {
		cout << num3 << ", " << num1 << ", " << num2 << "\n";
	}
}