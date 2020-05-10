#include "Reference.h"

Reference::Reference(){
	this->uid = 0;
	this->title = "xxx";
	this->author = "xxx";
	this->year = 0000;
} //default consturctor
Reference::~Reference() {}
Reference::Reference(int uid, string title, string author, int year) {
	this->uid = uid;
	this->title = title;
	this->author = author;
	this->year = year;
}
int Reference::getUid() {
	return uid;
}
string Reference::getTitle() {
	return title;
}
string Reference::getAuthor() {
	return author;
}
int Reference::getYear() {
	return year;
}
void Reference::setUid(int u) {
	this -> uid = u;
}
void Reference::setTitle(int t) {
	this->title = t;
}
void Reference::setAuthor(int a) {
	this->author = a;
}
void Reference::setYear(int y) {
	this->year = y;
}
void Reference::getAll() {
	cout << "Reference all info:\n";
	cout << "Uid: " << uid << "\n";
	cout << "Title: " << title << "\n";
	cout << "Author: " << author << "\n";
	cout << "Year: " << year << "\n";
}