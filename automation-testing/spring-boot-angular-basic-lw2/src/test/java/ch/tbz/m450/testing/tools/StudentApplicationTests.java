package ch.tbz.m450.testing.tools;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


@SpringBootTest
class StudentApplicationTests {

	@Test
	public void testGetAllStudents() {
		given()
				.when()
				.get("http://localhost:8081/students")
				.then()
				.statusCode(200)
				.body("[0].id", equalTo(1))
				.body("[0].name", equalTo("Jonas"))
				.body("[0].email", equalTo("jonas@tbz.ch"))
				.body("[1].id", equalTo(2))
				.body("[1].name", equalTo("Patrick"))
				.body("[1].email", equalTo("patrick@tbz.ch"))
				.body("[2].id", equalTo(3))
				.body("[2].name", equalTo("Yves"))
				.body("[2].email", equalTo("yves@tbz.ch"))
				.body("[3].id", equalTo(4))
				.body("[3].name", equalTo("Peter"))
				.body("[3].email", equalTo("peter@tbz.ch"))
				.body("[4].id", equalTo(5))
				.body("[4].name", equalTo("Ann"))
				.body("[4].email", equalTo("ann@tbz.ch"));
	}
}
