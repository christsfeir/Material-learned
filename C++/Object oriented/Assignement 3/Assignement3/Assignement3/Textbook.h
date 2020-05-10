#pragma once
#include "Book.h"
#include "Reference.h"

class TextBook : public Book{
public:
	TextBook();
	~TextBook();
	TextBook(int uid, string title, string author, int year, string publish, int p, string URL);
	void Set(string x);
	string Get();
	void printTextBook(); //print function for Text Book
protected:
	string URL;
};
