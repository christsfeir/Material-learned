#include <iostream>

using namespace std;

int main() {

	int num1 = 0;
	int sum = 0;
	int product = 1;
	int inter;

	cout << "Enter an integer \n";
	cin >> num1;
	inter = num1;


	while (inter != 0) {
		sum = sum + inter % 10;
		product = product * (inter % 10);
		inter = inter / 10;
	}

	cout << "Sum of each digit: " << sum << "\n";
	cout << "product of each digit: " << product << "\n";
}
