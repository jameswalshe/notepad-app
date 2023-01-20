import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})

export class SidebarComponent implements OnInit {

  p: number = 1;

  constructor(private http: HttpClient) { }
  notes: any = []

  ngOnInit(): void {
    this.http.get<any>('http://localhost:8080/api/notes').subscribe(data => {
     this.notes = data;
  })  
  }

}
