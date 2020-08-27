package com.qa.notes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

// give code (code refers to a type of error when trying to access url)  and message for response status
@ResponseStatus (code= HttpStatus.NOT_FOUND, reason = "The note with this ID does not exist")
public class NoteNotFoundException extends EntityNotFoundException {
}
