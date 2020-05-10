#include "Article.h"

Article::Article(){
} //default consturctor
Article::~Article(){
}
Article::Article(int uid, string title, string author, int year, string info, int startPage, int endPage) :
	Reference(uid, title, author, year) {
	this->uid = uid;
	this->title = title;
	this->author = author;
	this->year = year;
	this->info = info;
	this->startPage = startPage;
	this->endPage = endPage;
}
int Article::getNumberOfPages(){
    return endPage - startPage + 1;
}
void Article::getAll() {
	cout << "Reference all info:\n";
	cout << "Uid: " << uid << "\n";
	cout << "Title: " << title << "\n";
	cout << "Author: " << author << "\n";
	cout << "Year: " << year << "\n";
	cout << "Info: " << info << "\n";
	cout << "Page count: " << endPage - startPage + 1 << "\n";
}