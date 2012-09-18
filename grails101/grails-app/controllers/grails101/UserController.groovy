package grails101

import grails.converters.JSON
import grails.converters.XML
import groovy.json.JsonBuilder;


class UserController {
	
	def afterInterceptor = { model, modelAndView ->
		println model
		
	}
    def index() { }
	
	def show() {
		if(params.method.equals('json')) {
			def u = User.list()
			if(params.callback != null) {
				render "${params.callback}(${u as JSON})"
				
			} else 
			render u as JSON 
		} else if(params.method.equals('xml')) {
			def u = User.list()
			render u as XML
		}
	}
}
