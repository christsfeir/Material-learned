#pragma once
#include "Reference.h"

class Article : public Reference{
    public:
        Article();//default consturctor
        Article(int uid, string title, string author, int year, string info, int startPage, int endPage); //constructor with parameters
        ~Article();
        int getNumberOfPages();
        void getAll();
protected:
        string info;
        int startPage, endPage;
    };

