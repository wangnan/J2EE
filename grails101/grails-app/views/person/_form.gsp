<%@ page import="grails101.Person" %>



<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'age', 'error')} ">
	<label for="age">
		<g:message code="person.age.label" default="Age" />
		
	</label>
	<g:textField name="age" value="${personInstance?.age}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="person.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" value="${personInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="person.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" value="${personInstance?.lastName}"/>
</div>

