//@Authors: Christian Sfeir 40120536 Steven Arsan
#include <iostream>
#include <string>
#include "Reference.h"
#include "Article.h"
#include "Book.h"
#include "TextBook.h"


int main(){
	cout << "TESTING REFERENCE CLASS:\n\n";
	Reference r(1, "To kill a mockingbird", "Harper Lee", 1960);
	r.getAll();
	cout << "\n\n\n";
	cout << "TESTING ARTICLE CLASS:\n\n";
	Article a(2, "What Everyone Ought To Know About [...]", "Dan devito", 2006, 
		"[...] is finaly here, this article will tell you everything about it!",
		1, 6);
	a.getAll();
	cout << "\n\n\n";
	cout << "TESTING BOOK CLASS:\n\n";
	Book b(3, "The great Gatsby", "F. Scott Fitzgerald", 1925, "Charles Scribner's Sons", 218);
	b.printBook();
	cout << "\n\n\n";
	cout << "TESTING TEXTBOOK CLASS:\n\n";
	string URL = "https://stores.concordia.ca/catalog";
	TextBook t(4, "Advanced Engineering Mathematics", "Zill", 2017, "978-1-284-12454-5", 1417, URL);
	t.printTextBook();
	return 0;
}