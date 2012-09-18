package grails101



import grails.test.mixin.*
import org.junit.*
import groovy.json.JsonBuilder

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserTests {

	void testSomething() {
		try {
			for(int i = 0; i < 5; i++) {
				User u = new User(firstName:i, lastName:'lastName', company:'company', email: 'email', phone:'phone', username:'username' + i)
				u.save(flush:true);
				int a = User.count
				println a
			}
		} catch( Exception e) {
			e.printStackTrace();
		}
		
		def ul = User.list()
		def a = ['a':'a', 'b':'b', 'c':'c']
		def json = new JsonBuilder()
		json(ul.toArray())
		json.toString()
	}
}
