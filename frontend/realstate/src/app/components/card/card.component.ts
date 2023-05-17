import { Component, Input, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['../../styles/bootstrap.scss', '../../styles/css/style.css'],
})
export class CardComponent {
  
  @Input() name!: string;
  @Input() number!: string;
  @Input() image!: string;
  @Input() href!: string;
  @Input() styles!: string;
  //
}
