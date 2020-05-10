#pragma once

class Date{
public:
	Date(int day, int  month, int year);
	Date();
	~Date();
	void setDay(int d);
	void setMonth(int m);
	void setYear(int y);
	int getDay();
	int getMonth();
	int getYear();

protected:
	int day;
	int month;
	int year;
};

