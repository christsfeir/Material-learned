#include <iostream>
#include "InPatient.h"
#include "OutPatient.h"
#include "Date.h"
#include "Doctor.h"
#include "Bed.h"
#include "Hospital.h"

int main(){

    Date admission1("January 1st 2020");
    Date discharge1("January 10th 2020");
    Doctor d1("Walid", "surgeon", "1234");
    Bed bed(0);
    InPatient I1("Walid Junior", admission1, discharge1, bed.getID(), 100, d1);
    Hospital hospital(500);
    hospital.setCapacity(hospital.getCapacity() - bed.getIds());
    Date date("March 10th 2020");
    Doctor d2("Jean", "cardiac", "1235");
    OutPatient O1("Walid", date, 150, d2);

    if (hospital.getCapacity() == 0 || bed.getIds() == 500) {
    cout<< "No more inpatient, the hospital doesn't have the capacity."}
    return 0;
}
