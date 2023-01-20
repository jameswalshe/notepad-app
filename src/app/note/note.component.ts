import { Component, Inject, Input, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent implements OnInit {


  @Input() name: string = "";
  @Input() note: string = "";
  @Input() id: string = "";

  constructor(private http: HttpClient) { }


  ngOnInit(): void {

  }

  deleteNote(id: string) {
    let deleteID = {"id":id}
    this.http.post<any>('http://localhost:8080/api/deleteNote', deleteID).subscribe(data => {
      window.location.reload();
    })
  }

}
