#pragma once
#include <string>
using namespace std;


class Person{
    protected:
        string name;
    public:
        Person(string n) {
            name = n;
        }

        virtual void printInfo() {
            cout << "name: " << getName();
        }

        string getName(){
            return this->name;
        }
        void setName(string name){
            this->name = name;
        }
    };
