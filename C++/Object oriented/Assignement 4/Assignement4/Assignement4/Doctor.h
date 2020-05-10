#pragma once
#include "Person.h"

class Doctor : public Person{
    public:
        string specialization;
        string license;

        Doctor(string n = "", string s = "", string l = "") : Person(n) {
            specialization = s;
            license = l;
        }

        void printInfo() {
            cout << "name: " << getName();
            cout << "specialization: " << specialization;
            cout << "license: " << license;
        }

};