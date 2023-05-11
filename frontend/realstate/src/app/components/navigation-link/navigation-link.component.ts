import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-navigation-link',
  template: `<a href={{href}} class={{styles}}>{{label}}</a>`,
  styleUrls: ['../../styles/bootstrap.scss', '../../styles/css/style.css']
})
export class NavigationLinkComponent {
  @Input() label!: string;
  @Input() href!: string;
  @Input() styles!: string;
}
