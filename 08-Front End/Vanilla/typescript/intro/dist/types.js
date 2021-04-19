"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Meaningful = void 0;
// basic
//  declaration name : type = value
const num = 8;
// inferring types from assignment
let stringy = "STRINGY";
// cannot be done because ts has inferred the string type from the assignment
// stringy = true;
// any will let you do anything you want with the type
let anything = [];
anything = "";
anything = 9;
anything = true;
anything = undefined;
// tuple, a tuple array with an optional position
const hey = [['', 8], ['', 7, true]];
let somethingelse;
let somethingNew;
somethingNew = 9;
somethingNew = ['', 8];
// generics
const someFun = (phrase) => console.log(phrase);
someFun('hey there');
class Meaningful {
    constructor(_instant) {
        this._instant = _instant;
    }
    get instant() {
        return this._instant;
    }
    set instant(t) {
        this._instant = t;
    }
    isTruthy() {
        return Boolean(this._instant);
    }
}
exports.Meaningful = Meaningful;
const m = new Meaningful("instant");
console.log(m.isTruthy());
const strNum = '44';
console.log(strNum);
console.log(strNum);
// actual use case of type casting
// const query = document.getElementById("id") as HTMLInputElement;
// const value = query.value;
// if(value){
//     console.log(value.toUpperCase());
// }
const five = 5;
const strFive = "5";
console.log(five == strFive);
