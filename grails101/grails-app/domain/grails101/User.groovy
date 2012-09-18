package grails101

class User {

	static belongsTo = Meeting
	static hasMany = [meetings: Meeting]
	static mapWith = 'mongo'
	String username
	String firstName
	String lastName
	String email
	String phone
	String company
    static constraints = {
    }
}
