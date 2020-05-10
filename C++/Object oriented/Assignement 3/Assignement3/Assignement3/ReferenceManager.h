#ifndef REFERENCEMANAGER_H
#define REFERENCEMANAGER_H
#include <cassert> // for assert()
#include "Reference.h"

class ReferenceManager : public Reference{
public:
    ReferenceManager(int capacity);
    bool add(Reference& reference);
    int get(int pos);
    bool deletes(int pos);
    bool search(int id);

private:
    int capacity;
    int lengthArr{}; //size data member to track number of references in the array
    Reference* pointerArr{}; //instance variable
};
#endif