import {Component, Injectable, Input, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BlogPost} from '../BlogPost';
import {BlogService} from '../BlogService';

@Component({
  selector: 'app-my-posts',
  templateUrl: './my-posts.component.html',
  styleUrls: ['./my-posts.component.css']
})
@Injectable
export class MyPostsComponent implements OnInit {


  constructor( private service: BlogService ) {

  }


  ngOnInit() {
  }

  public getPosts(userId: number)  {

    return this._blogs;
  }

}
