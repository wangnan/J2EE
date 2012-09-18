package grails101

class Meeting {

	static hasMany = [attachments:Attachment, users:User]
	
	static mapWith = 'mongo'
	String title
	Date startTime
	Date endTime
	String organizer
	String body
	
    static constraints = {
    }
}
