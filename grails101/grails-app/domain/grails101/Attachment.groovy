package grails101

class Attachment {

	static belongsTo = Meeting
	static mapWith = 'mongo'
	String name
	int size
    static constraints = {
    }
}
