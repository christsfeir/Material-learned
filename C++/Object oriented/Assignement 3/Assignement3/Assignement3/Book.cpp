#include "Book.h"

Book::Book() { //Default Constructor
    PublisherofReference = "xxx";
    pagesinBook = 0;
}//default consturctor
Book::Book(int uid, string title, string author, int year, string publish, int p) :
    Reference{uid, title, author, year} { //Parameterised Constructor
    this->PublisherofReference = publish;
    this->pagesinBook = p;
}
int Book::getNumberOfPages(){
    return pagesinBook;
}
void Book::printBook(){ //print function for Book
    cout << "Reference all info:\n";
    cout << "Uid: " << uid << "\n";
    cout << "Title: " << title << "\n";
    cout << "Author: " << author << "\n";
    cout << "Year: " << year << "\n";
    cout << "Publisher of Reference is: " << PublisherofReference << "\n";
    cout << "Number of Pages in Book are: " << getNumberOfPages() << "\n";
}