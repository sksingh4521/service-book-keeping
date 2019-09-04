Problem statement GEO Test Task Functional Requirements

Create RESTful API to search and manage magazines, comics, books and their authors
•Each author can have multiple publications 
•Each publication can have multiple authors 
•Author name is not unique
•Publication name is not unique 


Domain Model

Author
• name 

Publication
Magazine
 • title
 • year 
 • type (Printed, On-line) 
 
 Comics
 • title
 • year
 • hero (name of the hero featured in comics)
 Book 
 • title
 • year
 • genre (Drama, Novel, Detective)

 Use Cases
 • CRUD for Authors
 • CRUD for publications
 • Search publications by year and author 
	o Example: find all books written by Stephen King in 1990 
	• Search publications by author and any arbitrary attribute
	o Example: find all novels by Stephen King
	o Example: find all comics with Spider-man

	 Technical Requirements
• Any framework, ORM and library may be used 
• Relational database must be used to persist data
• No security required 
• Tests are not required 
• All model fields are required