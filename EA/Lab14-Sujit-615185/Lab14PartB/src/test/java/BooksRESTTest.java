import books.domain.Book;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class BooksRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetOneBook() {
        // add the book to be fetched
        Book book = new Book("878","Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        // test getting the book
        given()
                .when()
                .get("books/878")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn",equalTo("878"))
                .body("title",equalTo("Book 123"))
                .body("price",equalTo(18.95f))
                .body("author",equalTo("Joe Smith"));
        //cleanup
        given()
                .when()
                .delete("books/878");
    }

    @Test
    public void testDelete() {

        Book book = new Book("878", "Book 123", 18.95f, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/book").then()
                .statusCode(200);
        given()
                .when()
                .delete("book/878");
        given()
                .when()
                .get("books")
                .then()
                .body("isbn", hasSize(1));
    }

    @Test
    public void testPost() {
        Book book = new Book("234", "Book 3", 30.00, "Sujit");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/book").then()
                .statusCode(200);
        given()
                .when()
                .get("books")
                .then()
                .contentType(ContentType.JSON)
                .body("isbn", hasItems("123", "124", "234"));
//delete the book again
        given()
                .when()
                .delete("book/234");
    }

    @Test
    public void testUpdateBook() {
// add the contact
        Book book = new Book("878","Book 123", 18.95, "Joe Smith");
        Book updateBook = new Book("878","Book 234", 31.10, "Sujit");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/contacts").then()
                .statusCode(200);
//update contact
        given()
                .contentType("application/json")
                .body(updateBook)
                .when().put("/books/"+updateBook.getIsbn()).then()
                .statusCode(200);
// get the contact and verify
        given()
                .when()
                .get("books/878")
                .then()
                .statusCode(200)
                .and()
                .body("isbn",equalTo("878"))
                .body("title",equalTo("Book 234"))
                .body("price",equalTo(31.10f))
                .body("author",equalTo("Sujit"));
//cleanup
        given()
                .when()
                .delete("books/878");
    }

    @Test
    public void testGetAllBooks() {
// add the contacts
        Book book1 = new Book("878","Book 123", 18.95, "Joe Smith");
        Book book2 = new Book("234", "Book 3", 30.00, "Sujit");
        given()
                .contentType("application/json")
                .body(book1)
                .when().post("/contacts").then()
                .statusCode(200);
        given()
                .contentType("application/json")
                .body(book2)
                .when().post("/contacts").then()
                .statusCode(200);
// get all contacts and verify
        given()
                .when()
                .get("books")
                .then()
                .statusCode(200)
                .and()
                .body("books.isbn",hasItems("234", "878"))
                .body("books.title",hasItems("Book 3", "Book 123"))
                .body("books.price",hasItems(30.00f, 18.95f))
                .body("books.author",hasItems("Sujit", "Joe Smith"));
//cleanup
        given()
                .when()
                .delete("contacts/878");
        given()
                .when()
                .delete("contacts/234");
    }




}
