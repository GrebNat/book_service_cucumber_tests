package steps;

/**
 * Created by Natalia_Grebenshchikova on 10/11/2017.
 */

import static api.BookApi.createBook;
import static api.BookApi.getBook;
import static steps.TestContext.apiValidation;
import static steps.TestContext.book;
import static steps.TestContext.id;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.Book;
import java.util.List;

public class CreateBookSteps {

  @Given("^I have book to add to library$")
  public void iHaveBookToAddToLibrary() throws Throwable {
    book = Book.test_book.clone();
  }

  @When("^I create new book$")
  public void iCreateNewBook() throws Throwable {
    TestContext.apiValidation = createBook(book);
    TestContext.id = apiValidation.getId();
  }


  @Then("^Status code should be (\\d+)$")
  public void statusCodeShouldBe(int status) throws Throwable {
    apiValidation.assertStatus(status);
  }

  @And("^Returned book json should be correct$")
  public void returnedBookJsonShouldBeCorrect() throws Throwable {
    apiValidation.assertBook(book);
  }

  @When("^I get created book from library$")
  public void iGetCreatedBookFromLibrary() throws Throwable {
    apiValidation = getBook(id);
  }

  @Given("^I have book to add to library with name \"([^\"]*)\"$")
  public void iHaveBookToAddToLibraryWithName(String arg0) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Given("^I have book to add to library with data below:$")
  public void iHaveBookToAddToLibraryWithDataBelow(DataTable table) throws Throwable {
    List<List<String>> booksRaw = table.raw();
    List<String> bookRaw = booksRaw.get(1);
    book = new Book(bookRaw.get(0), bookRaw.get(1), bookRaw.get(2), bookRaw.get(3), bookRaw.get(4),
        bookRaw.get(5));
  }
}