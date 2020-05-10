#include <iostream>
using namespace std;

int main() 
{

	int celcius = 1;
	std::cout << "Celcius \tFahrenheit \tKelvin \n";

	while(celcius <=20)
	{
		double fahrenheit = static_cast<double>(celcius) * (1.8) + 32;
		double kelvin = static_cast<double>(celcius) + 273.15;

		std::cout << celcius << "\t\t";
		std::cout << fahrenheit << "\t\t";
		std::cout << kelvin << "\n";
		celcius += 1;
	}


}
