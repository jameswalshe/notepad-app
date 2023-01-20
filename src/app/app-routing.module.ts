import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewNoteFormComponent } from './new-note-form/new-note-form.component';
import { ViewNoteComponent } from './view-note/view-note.component';

const routes: Routes = [
  { path: 'new-note', component: NewNoteFormComponent },
  { path: 'view', component: ViewNoteComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes,  {useHash : true })],
  exports: [RouterModule]
})

export class AppRoutingModule { }
