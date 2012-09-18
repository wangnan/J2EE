import grails101.User

class BootStrap {

    def init = { servletContext ->
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
    }
    def destroy = {
    }
}
