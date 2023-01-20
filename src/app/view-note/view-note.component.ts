import { HttpClient } from '@angular/common/http';
import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-note',
  templateUrl: './view-note.component.html',
  styleUrls: ['./view-note.component.css']
})

export class ViewNoteComponent implements OnInit {

  note: any = [];

  constructor(private http: HttpClient, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.http.get<any>('http://localhost:8080/api/viewNote/' + params['nid']).subscribe(data => {
        this.note = data[0];
        console.log(data)
     })  
    });
  }

}
