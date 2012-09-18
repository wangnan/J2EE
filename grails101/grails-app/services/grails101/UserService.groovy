package grails101

class UserService {

    def serviceMethod() {

    }
	
	def listUsers() {
		User.list()
	}
	
	def createUser(User u) {
		u.save()
	}
	
	def updateUser(User o) {
		User u = User.get(o.id)
		
	}
}
