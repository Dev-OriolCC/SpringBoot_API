import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-custom-button',
  template: `<a class={{styles}} href={{href}}>{{label}}</a>`,
  styleUrls: ['../../styles/bootstrap.scss', '../../styles/css/style.css']
})
export class CustomButtonComponent {
  @Input() styles!: string;
  @Input() label!: string;
  @Input() href!: string;
}
