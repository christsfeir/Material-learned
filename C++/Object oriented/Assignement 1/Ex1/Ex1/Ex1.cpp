// @Authors: Christian Sfeir 40120536 Steven Arsan 40113224
//

#include <iostream>
#include "Ex1.h"
using namespace std;

// This function returns value of a Roman symbol 
int value(char intermediate)
{
    if (intermediate == 'I')
        return 1;
    if (intermediate == 'V')
        return 5;
    if (intermediate == 'X')
        return 10;
    if (intermediate == 'L')
        return 50;
    if (intermediate == 'C')
        return 100;
    if (intermediate == 'D')
        return 500;
    if (intermediate == 'M')
        return 1000;

    return -1;
}

// Returns decimal value of roman numerals

// Driver Program
// The main's job is to let the user input the roman numbers and then call the function that converts the roman numerals to integers
int main(){
    // Considering inputs given are valid as said in the message on moodle
    int n;
    cout << "Enter the size of the roman number: \n";
    cin >> n;

    char* roman = new char[n];
    cout << "Enter the number: \n";
    cin >> roman;
    cout << "Integer form of Roman Numeral is "
        << decimalConverting(n, roman) << endl;
}


// verifications on if it should be adding or substrating depending on if the numerals value after it is greater or smaller
int decimalConverting(int n, char* roman){
    // Initialize result 
    int res = 0;
    // Traverse given input 
    for (int i = 0; i < n; i++){
        // Getting value of symbol s[i] 
        int convert1 = value(roman[i]);

        if (i + 1 < n){
            // Getting value of symbol s[i+1] 
            int convert2 = value(roman[i + 1]);

            // Comparing both values 
            if (convert1 >= convert2){
                // Value of current symbol is greater 
                // or equal to the next symbol 
                res = res + convert1;
            }else{
                res = res + convert2 - convert1;
                i++; // Value of current symbol is 
                     // less than the next symbol 
            }
        }else{
            res = res + convert1;
        }
    }
    return res;
}
