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


---
<b>Solution:</b>

Step 1: Checkout project and build it through gradle
Step 2: Server should run at 8080 with h2 in memory database.
Step 3: Download postman, and find postman import file ./json dir.
Step 4: import json collection in Postman.
Step 5: execute createBulkPublisher from postman, it would create test data to validate functionality.
Ste 6 : Validate all the cases through other postman request in json.

---
<b>How this solution is extended ?</b>
We need to follow below standard step if new Publication needs to be added:
1. Add new Publication as Entity
2. Create appropiate composition(due to has-a relationship) and mapping as per requirement in Publication.java (Book,Comics, Authors are good existing example).
3. Create an entry in class Publication_ (StaticMetamodel).
4. To enable search, create a model by implementing LibraryBaseModel.
5. Add an entry in SearchDictionary.java as well(To externalize configuration).
6. <new_pub: value> add this parameter to requested body, search result should appear as per given value.

---
