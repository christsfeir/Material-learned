#include<iostream>
#include <iomanip>
#include<string>
#include <stdlib.h>
#include<fstream>

using namespace std;

bool check(string);
void engToPigLatin(char& runSentinel, std::string& word, bool& input);
void first(string);
void conversion(string);
const int MAX_SIZE = 175;           //max size of array constant
const int MAX_WORD_SIZE = 23;       //max size of word string constant
typedef string StringArray[MAX_SIZE];   //string array
int PrintDictionary(void);           //printDictionary function
void PrintHeading();   //PrintHeading function
void ClosingMessage();   //ClosingMessage function



string pigLatintoEnglish(string str) {

    int len = str.length(); //If sting ends with "way" then remove that part and print the remaining string.
    if (str[len - 1] == 'y' && str[len - 2] == 'a' && str[len - 3] == 'w') {
        return str.substr(0, len - 4);
    }//if string does not end with "way"

    int index = -1;
    for (int i = len - 1; i >= 0; i--) {
        if (str[i] == '-') {
            index = i;
            break;
        }
    }
    string s1 = str.substr(index + 1);
    string s = s1.substr(0, s1.length() - 2) + str.substr(0, index);
    return s;
}

int main(){
    int choice;

    do {
        cout << "Would you like to:\n"
            << "1-Convert english to pig latin\n"
            << "2-Convert pig latin to english\n";
        cin >> choice; //force them to have to chose 1 or 2, else the program will crash
    } while (choice != 1 && choice !=2);
    

    if(choice ==1 ){
        string word = ""; //array or chars, or how we call it a string
        bool input = false;
        char runSentinel = 'y';
        engToPigLatin(runSentinel, word, input); //function to convert it to piglatin
    }else {
        string str;
        cout << "Enter an English Sentence : \n";
        cin >> str;
        string s = pigLatintoEnglish(str);
        cout << s;
        return 0;
    
    }

    
}

void engToPigLatin(char& runSentinel, std::string& word, bool& input)
{
    cout << "Would you like to convert? (y/n)";
    cin >> runSentinel;

    do
    {

        if (runSentinel == 'y' || runSentinel == 'Y')
        {
            cout << "Please enter the word you would like to be translated, \n" << endl;
            cin >> word;
            input = check(word);
        }
        else {
            exit(0);
        }

        if (input == false)
        {
            first(word);
            //();
        }
        cin.ignore();
        cout << "Would you like to translate a word? (y/n)";
        cin >> runSentinel;


    } while (runSentinel != 'n');
}

bool check(string word)
{
    bool verification = false;
    int Length = word.length();
    int Counter = 0;
    char* specificLetter = &word.at(0);

    while (Counter < Length && verification == false)
    {
        if (!isalpha(*specificLetter))
        {
            cout << *specificLetter << "is not an acceptable entry. Please re-enter your word.";
            verification = true;
        }

        if (isspace(*specificLetter))
        {
            cout << *specificLetter << "is not an acceptable entry. Please re-enter your word.";
            verification = true;
        }

        *specificLetter++;
        Counter++;

    }
    return verification;
}

void first(string word)
{
    char first;
    first = word.at(0);

    if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u' || first == 'y' 
        || first == 'A' || first == 'E' || first == 'I' || first == 'O' || first == 'U' || first == 'Y')
    {
        cout << "In Pig Latin, that would be: " << word << "-way" << endl;
    }
    else
    {
        conversion(word);
    }
}

void conversion(string word)
{
    char first;
    char last = word.length();

    first = word.at(0);
    string rest = word.substr((1), (last - 1));
    cout << "In Pig Latin, that would be " << rest << "-" << first << "ay." << endl;
}


