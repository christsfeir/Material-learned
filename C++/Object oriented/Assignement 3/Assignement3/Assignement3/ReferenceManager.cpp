#include "ReferenceManager.h"

ReferenceManager::ReferenceManager(int capacity) : //regular Constructor
   lengthArr{ capacity } {
    assert(capacity >= 0);
    if (capacity > 0) {
        pointerArr = new Reference[capacity]{};
    }      
}
bool ReferenceManager::add(Reference& reference){
    int i;
    for (i = 0; i < capacity; i++){
        if (pointerArr[i].getUid() == 0){
            pointerArr[i] = reference;
            return true;
        }else{
            return false;
        }
    }
}

int ReferenceManager::get(int pos){
        return pointerArr[pos].getUid();
}

bool ReferenceManager::deletes(int pos){
    if (pos >= capacity || pos < 0)
        return false;
    else {
        for (int i = pos; i < capacity; i++) {
            pointerArr[i] = pointerArr[i + 1];
        }
        return true;
    }
}

bool ReferenceManager::search(int id){
    for (int i = 0; i < capacity; i++) {
        if (pointerArr[i].getUid() == id) {
            return true;
        }
    }
    return false;
}

