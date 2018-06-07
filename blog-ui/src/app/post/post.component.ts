import {Component, Injectable, Input, OnInit} from '@angular/core';
import {BlogPost} from '../BlogPost';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
@Injectable
export class PostComponent implements OnInit {
@Input Blog: BlogPost;
  constructor() { }

  ngOnInit() {
  }

}
