#include <iostream>
using namespace std;

int main() {

	int num1 = 0;
	bool ver = true;
	int intermidiate = 0;
	int product = 1;

	cout << "Enter a positive integer: \n";
	cin >> num1;

	

	while (intermidiate <= num1) {

		if (intermidiate % 2 == 1) {
			product = product * intermidiate;
		}

		intermidiate++;
	}

	cout << "Product of all odd numbers smaller than " << num1 << " is: " << product;

}