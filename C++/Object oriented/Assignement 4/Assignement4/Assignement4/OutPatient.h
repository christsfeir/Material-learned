#pragma once
#include "Person.h"
#include "Date.h"
#include "Time.h"
#include "Doctor.h"

class OutPatient : public Person{
    protected:
        Date date;
        Time time;
        int charge;
        Doctor doc;
    public:
        void printInfo(){
            std::cout << this->date.date;
            std::cout << charge;
            std::cout << this->doc.specialization;
            std::cout << this->doc.license;
            std::cout << this->doc.getName();
        }

        OutPatient(string n, Date d, double c, Doctor don) : Person(n) {
            date = d;
            charge = c;
            doc = don;
        }

        void setDetails(Date date, Time time, int charge, Doctor doc, string name){
            this->setName(name);
            this->date.date = date.date;
            this->time.time = time.time;
            this->charge = charge;
            this->doc.specialization = doc.specialization;
            this->doc.license = doc.license;
            this->doc.setName(doc.getName());
        }
    };

