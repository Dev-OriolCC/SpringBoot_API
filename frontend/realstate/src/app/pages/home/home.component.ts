import { Component, OnInit, ViewEncapsulation  } from '@angular/core';
import { TypeService } from 'src/app/service/type/type.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['../../styles/bootstrap.scss', '../../styles/css/style.css'],
})
export class HomeComponent implements OnInit {

  types:  any;
  
  constructor(private typeService: TypeService) {}

  ngOnInit(): void {
      console.log('Init');

      this.typeService.getAllTypes().subscribe(types => {
        console.log(types);
        this.types = types;
      });
      
      // try {
      //   this.http.get(API_ENDPOINT+'/types').subscribe(data => 
      //     this.data = data
      //   );
      // } catch (error) {
      //   console.log(error);
      // }
      //console.log(this.data);
  }

  fetchTypes(): void {
    this.typeService.getAllTypes().subscribe(types => {
      console.log(types);
    });
  }

}
