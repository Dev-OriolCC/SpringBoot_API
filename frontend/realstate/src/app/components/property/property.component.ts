import { Component,Input } from '@angular/core';

@Component({
  selector: 'app-property',
  templateUrl: './property.component.html',
  styleUrls: ['../../styles/bootstrap.scss', '../../styles/css/style.css']
})
export class PropertyComponent {
  
  @Input() image!: string;
  @Input() listingType!: string;
  @Input() type!: string;
  @Input() price!: number;
  @Input() title!: string;
  @Input() location!: string;
  @Input() squarefeet!: number;
  @Input() beds!: number;
  @Input() baths!: number;

}
