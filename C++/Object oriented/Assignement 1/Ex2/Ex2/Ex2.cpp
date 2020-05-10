//@Authors: Christian Sfeir 40120536 and Steven Arsan 40113224
#include<iostream>
#include<cstring>

using namespace std;


int check(char* exp){ // function to verufy characters in the expression

    if (*exp == '\0') return -1;    // if there is no string

    int res = 0; // variable res is the result
    int val = 0; // val to store the operation (*,-,/,+)
    int i = 0; // i to run the array

    
    while (isdigit(exp[i])){ // isdigit to verify if its an integer or not 
        res = res * 10 + (exp[i] - '0');
        i++;
    }

    
    while (exp[i]){ // loop the whole array of chars that act as strings
        char bruh = exp[i]; // store the operator variable bruh 
        // increment the index since we have utilized it
        i++;

        // clear val
        val = 0;

        
        while (isdigit(exp[i])){ // loop the whole array of chars that act as strings
            val = val * 10 + exp[i] - '0';
            i++;
        }

        
        if (bruh == '*')       
            res *= val; // depending on the operaotr perform operation on the result
        else if (bruh == '/') 
            res /= val;
        else if (bruh == '+') 
            res += val;
        else if (bruh == '-') 
            res -= val;
    }

    return res;
}

int main(int argc, char const* argv[])
{
    char string[50]; //a char array to act as a string
    cin >> string; //So the user can input his own expression
    cout << check(string); // print the result obtained in the function
}




