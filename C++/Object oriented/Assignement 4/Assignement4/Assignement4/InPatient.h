#pragma once
#include <iostream>
#include "Person.h"
#include "Date.h"
#include "Time.h"
#include "Doctor.h"

class InPatient : public Person{
    Date admission;
    Date discharge;
    Doctor doc;
    int bed;
    double charge;

public:
    void printInfo(){
        std::cout << this->admission.date;
        std::cout << this->discharge.date;
        std::cout << bed;
        std::cout << charge;
        std::cout << this->doc.specialization;
        std::cout << this->doc.license;
        std::cout << this->doc.getName();
    }

    InPatient(string n, Date a, Date d, int b, double c, Doctor don) : Person (n){
        admission = a;
        discharge = d;
        doc = don;
        bed = b;
        charge = c;
    }

    void setDetails(Date adm, Date dis, int bed, double charge, Doctor doc, string name){
        this->setName(name);
        this->admission.date = adm.date;
        this->discharge.date = dis.date;
        bed = bed;
        charge = charge;
        this->doc.specialization = doc.specialization;
        this->doc.license = doc.license;
        this->doc.setName(doc.getName());
    }
};

