import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-new-note-form',
  templateUrl: './new-note-form.component.html',
  styleUrls: ['./new-note-form.component.css']
})

export class NewNoteFormComponent {
  title = 'notepad-app';
  noteForm = new FormGroup({
    name: new FormControl(''),
    note: new FormControl('')
  })

  constructor(private http: HttpClient) { }

  makeid(length: number) {
    var result = '';
    var characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    var charactersLength = characters.length;
    for (var i = 0; i < length; i++) {
      result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result;
  }


  saveNote() {

    if (this.noteForm.controls['name'].value && this.noteForm.controls['note'].value) {
      var newNote = {
        'id': this.makeid(10),
        'name': this.noteForm.controls['name'].value,
        'note': this.noteForm.controls['note'].value
      }

      this.http.post<any>('http://localhost:8080/api/note', newNote).subscribe(data => {
        window.location.reload();
      })
    } else {
      alert("Name and note cannot be empty!")
    }

  }

}
