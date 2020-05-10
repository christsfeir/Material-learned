#pragma once
#include <iostream>

using namespace std;

class Reference{
public:
	Reference(); //default consturctor
	~Reference(); 
	Reference(int uid, string title, string author, int year); //constructor with parameters
	int getUid();
	string getTitle();
	string getAuthor();
	int getYear();
	void setUid(int u);
	void setTitle(int t);
	void setAuthor(int a);
	void setYear(int y);
	void getAll();
protected:
	int uid;
	string title, author;
	int year;
	};



