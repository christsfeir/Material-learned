#include "Textbook.h"
#include "Reference.h"

TextBook::TextBook(){
	URL = "xxx";
}
TextBook::~TextBook(){
}
TextBook::TextBook(int uid, string title, string author, int year, string publish, int p, string URL) : 
	Book{uid, title, author, year, publish, p} {
	this->URL = URL;
}
void TextBook::Set(string x){
	URL = x;
}
string TextBook::Get(){
	return URL;
}
void TextBook::printTextBook(){
		cout << "Reference all info:\n";
		cout << "Uid: " << uid << "\n";
		cout << "Title: " << title << "\n";
		cout << "Author: " << author << "\n";
		cout << "Year: " << year << "\n";
		cout << "Publisher of Reference is: " << PublisherofReference << "\n";
		cout << "Number of Pages in Book are: " << getNumberOfPages() << "\n";
		cout << "URL provided: " << URL << "\n";
}
