#!/usr/bin/python -tt

class Encounter:
	def __init__(self, id, patient, date, type_val, reason_for_visit, observations):
		self.id = id
		self.patient = patient
		self.date = date
		self.type = type_val
		self.reason_for_visit = reason_for_visit
		self.observations = observations

class Observation:
	def __init__(self, name, value, applies, issued, identifier, subject):
		self.name = name
		self.value = value
		self.applies = applies
		self.issued = issued
		self.identifier = identifier
		self.subject = subject

class Patient:
	def __init__(self, id, first_name, middle_name, last_name, date_of_birth, gender, race):

class PCE:
	def __init__(self, id, desc):
		self.id = id
		self.desc = desc