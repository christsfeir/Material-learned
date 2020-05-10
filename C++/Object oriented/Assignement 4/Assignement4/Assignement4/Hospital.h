#pragma once
#include <vector>
#include "iostream"
#include "OutPatient.h"
#include "InPatient.h"
using namespace std;

class Hospital{
    vector<InPatient> IP;
    vector<OutPatient> OP;
    vector<Doctor> docs;
    static int capacity;
public:
    
    Hospital(int capacity = 500) {
        this->capacity = capacity;
    };
    int getCapacity() {
        return capacity;
    }
    void setCapacity(int c) {
        capacity = c;
    }
    void setIP(InPatient inPatient) {
        IP.push_back(inPatient);
    }
    void setOP(OutPatient outPatient) {
        OP.push_back(outPatient);
    }
    void setDoctor(Doctor doc) {
        docs.push_back(doc);
    }
    void getAllIP() {
        for (size_t i = 0; i < IP.size(); i++){
            IP[i].printInfo();
        }
    }
    void getAllOP(){
        for (size_t i = 0; i < OP.size(); i++) {
            OP[i].printInfo();
        }
    }
    void getAllDoc() {
        for (size_t i = 0; i < docs.size(); i++) {
            docs[i].printInfo();
        }
    }

};

