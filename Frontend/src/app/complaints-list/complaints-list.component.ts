import { Component, OnInit } from '@angular/core';
import { Complaints } from '../complaints';
import { ComplaintsService } from '../complaints.service';

@Component({
  selector: 'app-complaints-list',
  templateUrl: './complaints-list.component.html',
  styleUrls: ['./complaints-list.component.css']
})
export class ComplaintsListComponent implements OnInit {
  dataC:any;
  currentIndex = -1;
  currentComplaints:Complaints={
    id: '',
    topic: '',
    complaintDate: ''
  };

  constructor(private complaintsService :ComplaintsService) {
    this.complaintsService.getAll().subscribe(data=>this.dataC=data);
   }

  ngOnInit(): void {
  }
  setActiveComplaints(complaints: Complaints, index: number): void {
    this.currentComplaints= complaints;
    this.currentIndex = index;
  }

  delete(id : number): void {
    this.complaintsService.delete(id)
      .subscribe(
        response => {
          console.log(response);
          window.location.href = "/complaintsList";
        },
        error => {
          console.log(error);
        });
  }

}
