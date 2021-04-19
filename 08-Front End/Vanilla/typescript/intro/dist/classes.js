"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.FirstClass = void 0;
class FirstClass {
    // we can use modifiers in the constructor params to declare them as
    //      fields
    constructor(name, age) {
        this.name = name;
        this.age = age;
        // this.name=name;
        // this.age=age;
    }
}
exports.FirstClass = FirstClass;
class SecondClass {
    // in ts, we can have 'optional params'
    constructor(name, age, temp) {
        this.name = name;
        this.age = age;
        console.log(temp);
    }
}
class ThirdClass extends FirstClass {
    something(x) {
        let some;
        if (x > 5) {
            some = 'true';
        }
        return some.toString();
    }
}
class SomeClass {
    constructor(num) {
        this.num = num;
    }
}
const first = new FirstClass("hey", 4);
const second = new SecondClass('name');
