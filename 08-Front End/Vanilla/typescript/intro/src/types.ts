// basic
//  declaration name : type = value
const num: number = 8;
// inferring types from assignment
let stringy = "STRINGY";
// cannot be done because ts has inferred the string type from the assignment
// stringy = true;

// any will let you do anything you want with the type
let anything: any = [];
anything = "";
anything = 9;
anything = true;
anything = undefined;

// tuple, a tuple array with an optional position
const hey: [string, number, boolean?][] = [
  ["", 8],
  ["", 7, true],
];

// create custom types
type me = [string, number, boolean];
let somethingelse: me;
// somethingelse = 8;

// type unions where the variables can be of either type
type newMe = [string, number] | number;
let somethingNew: newMe;
somethingNew = 9;
somethingNew = ["", 8];

// generics
const someFun = <T>(phrase: T) => console.log(phrase);
someFun<string>("hey there");

export class Meaningful<T> {
  constructor(private _instant: T) {}

  get instant(): T {
    return this._instant;
  }
  set instant(t: T) {
    this._instant = t;
  }

  isTruthy(): boolean {
    return Boolean(this._instant);
  }
}

const m = new Meaningful<string>("instant");
console.log(m.isTruthy());

const strNum: unknown = "44";
console.log(<number>strNum);
console.log(strNum as number);

// actual use case of type casting
// const query = document.getElementById("id") as HTMLInputElement;
// const value = query.value;

// if(value){
//     console.log(value.toUpperCase());
// }
const five: any = 5;
const strFive: any = "5";
console.log(five == strFive);

function makeOne(
  innerNum: number,
  name?: string,
  valid?: string[],
  ...args: string[]
) {}

makeOne(4, "", [""], "", "", "", "", "");
makeOne(4, null);

function errorThrower(val:string): never {
  throw new TypeError(
    `method was implemented in so many 
    ways that it now throws a typeError ${val}
    if you try and run this`
  );
}
