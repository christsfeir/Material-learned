#pragma once
#include "Reference.h"
using namespace std;

class Book : public Reference{
    public:
        Book(); //default consturctor
        Book(int uid, string title, string author, int year, string publish, int p); //constructor with parameters
        int getNumberOfPages();
        void printBook();
    protected:
    string PublisherofReference;
    int pagesinBook;
    };


