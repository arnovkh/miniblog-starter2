
export class BlogPost {
  private _id: number;
  private _title: string;
  private _body: string;
  private _likes: number;
  private _replies: BlogPost[];



  public constructor(id: number, title: string, body: string, likes: number) {
    this._title = title;
    this._body = body;
    this._likes = likes;
    this._id = id;
    this._replies = new Array();
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  get body(): string {
    return this._body;
  }

  set body(value: string) {
    this._body = value;
  }

  get likes(): number {
    return this._likes;
  }

  set likes(value: number) {
    this._likes = value;
  }

  get replies(): BlogPost[] {
    return this._replies;
  }

  set replies(value: BlogPost[]) {
    this._replies = value;
  }



}
